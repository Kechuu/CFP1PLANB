/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author araa
 */
public class Domicilio {
    
    private int idDomicilio;
    private int nroLote;
    private String telefono;
    private Lugar idLugar;
    private int idEdificio;

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public int getNroLote() {
        return nroLote;
    }

    public void setNro(int nroLote) {
        this.nroLote = nroLote;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Lugar getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(Lugar idLugar) {
        this.idLugar = idLugar;
    }

    public int getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(int idEdificio) {
        this.idEdificio = idEdificio;
    }
    
    
}
