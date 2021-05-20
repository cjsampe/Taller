package com.sanvalero.taller.dao;

import com.sanvalero.taller.domain.Coche;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CocheDAO {

    private Conexion conexion;
    
    public CocheDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public void registrarCoche(Coche coche) throws SQLException {
        String sql = "INSERT INTO coches (matricula, modelo) VALUES (?, ?)";
        
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(sql);
        sentencia.setString(1, coche.getMatricula());
        sentencia.setString(2, coche.getModelo());
        sentencia.executeUpdate();
    }
    
    // No se permite modificar la matricula y se usa como criterio para la busqueda
    // en la operación de modificación
    // TODO Falta terminarlo
    public void modificarCoche(Coche coche) throws SQLException {
        String sql = "UPDATE coches SET modelo = ? WHERE matricula = ?";
        
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(sql);
        sentencia.setString(1, coche.getModelo());
        sentencia.setString(2, coche.getMatricula());
        sentencia.executeUpdate();
    }
    
    public void eliminarCoche(String matricula) throws SQLException {
        String sql = "DELETE FROM coches WHERE matricula = ?";
       
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(sql);
        sentencia.setString(1, matricula);
        sentencia.executeUpdate();
    }
    
    public ArrayList<Coche> obtenerCoches() throws SQLException {
        String sql = "SELECT id, matricula, modelo FROM coches";
        ArrayList<Coche> coches = new ArrayList<>();
        
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
            Coche coche = new Coche();
            coche.setId(resultado.getInt(1));
            coche.setMatricula(resultado.getString(2));
            coche.setModelo(resultado.getString(3));
            
            coches.add(coche);
        }
        
        return coches;
    }
    
    // Sin usar en Taller
    public ArrayList<Coche> obtenerCoches(String cadenaBusqueda) throws SQLException {
        String sql = "SELECT * FROM coches WHERE modelo = ?";
        ArrayList<Coche> coches = new ArrayList<>();
        
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(sql);
        sentencia.setString(1, cadenaBusqueda);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
            Coche coche = new Coche();
            coche.setId(resultado.getInt(1));
            coche.setMatricula(resultado.getString(2));
            coche.setModelo(resultado.getString(3));
            
            coches.add(coche);
        }
        
        return coches;
    }
    
    public int obtenerCantidadCoches() {
        String sql = "SELECT COUNT(*) FROM coches";
        int cantidad = 0;
        
        // TODO 
        
        return cantidad;
    }
    
    public void arreglarCoche(String matricula) {
        String sql = "UPDATE coches SET arreglado = TRUE WHERE matricula = ?";
    }
}
