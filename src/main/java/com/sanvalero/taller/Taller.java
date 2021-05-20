package com.sanvalero.taller;

import com.sanvalero.taller.dao.CocheDAO;
import com.sanvalero.taller.dao.Conexion;
import com.sanvalero.taller.domain.Coche;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Taller {
    
    private boolean salir;
    private Scanner teclado;
    private Conexion conexion;
    private CocheDAO cocheDAO;
    
    public Taller() {
        salir = false;
        teclado = new Scanner(System.in);
        conexion = new Conexion();
        conexion.conectar();
        cocheDAO = new CocheDAO(conexion);
    }
    
    public void ejecutar() { 
        do {
            System.out.println("Aplicación GesTaller v0.1");
            System.out.println("1. Ver coches");
            System.out.println("2. Registrar coche");
            System.out.println("3. Modificar coche");
            System.out.println("4. Eliminar coche");
            System.out.println("x. Salir");
            System.out.print("Selecciona: ");
            String opcion = teclado.nextLine();
            
            switch (opcion) {
                case "1":
                    verCoches();
                    break;
                case "2":
                    registrarCoche();
                    break;
                case "3":
                    modificarCoche();
                    break;
                case "4":
                    eliminarCoche();
                    break;
                case "x":
                    salir();
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while(!salir);
    }
    
    private void verCoches() {
        try {
            ArrayList<Coche> coches = cocheDAO.obtenerCoches();
            for (Coche coche : coches) {
                System.out.println(coche);
            }
        } catch (SQLException sqle) {
            System.out.println("Se ha producido un problema leyendo los datos");
            sqle.printStackTrace();
        }
    }
    
    private void registrarCoche() {
        System.out.println("Matricula?: ");
        String matricula = teclado.nextLine();
        System.out.println("Modelo?: ");
        String modelo = teclado.nextLine();
        // TODO Solicitar el resto de campos
        Coche coche = new Coche();
        coche.setMatricula(matricula);
        coche.setModelo(modelo);
        
        try {
            cocheDAO.registrarCoche(coche);
            System.out.println("El coche se ha registrado correctamente");
        } catch (SQLException sqle) {
            System.out.println("Se ha producido un problema. Inténtelo de nuevo");
            sqle.printStackTrace();
        }
    }
    
    private void modificarCoche() {
        
    }
    
    private void eliminarCoche() {
        System.out.println("Matricula?: ");
        String matricula = teclado.nextLine();
        
        try {
            cocheDAO.eliminarCoche(matricula);
            System.out.println("El coche se ha eliminado correctamente");
        } catch (SQLException sqle) {
            System.out.println("Se ha producido un problema. Inténtelo de nuevo");
            sqle.printStackTrace();
        }
    }
    
    private void salir() {
        salir = true;
    } 
}
