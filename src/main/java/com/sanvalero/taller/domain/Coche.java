package com.sanvalero.taller.domain;

public class Coche {
    
    private int id;
    private String matricula;
    private String marca;
    private String modelo;
    private String tipo;
    private int velocidadMaxima;
    private boolean arreglado;
    
    public Coche() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public boolean isArreglado() {
        return arreglado;
    }

    public void setArreglado(boolean arreglado) {
        this.arreglado = arreglado;
    }

    @Override
    public String toString() {
        return "Coche{" + "id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", tipo=" + tipo + ", velocidadMaxima=" + velocidadMaxima + ", arreglado=" + arreglado + '}';
    }
}
