/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jesus
 */
public class Caracter {
    private int idCaracter;
    private String detalle;

    public int getIdCaracter() {
        return idCaracter;
    }

    public void setIdCaracter(int idCaracter) {
        this.idCaracter = idCaracter;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    public String toString(){
        return this.detalle;
    }
}
