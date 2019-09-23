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
public class MotivoBaja {
    
    private int idMotivoBaja;
    private String detalle;

 
    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getIdMotivoBaja() {
        return idMotivoBaja;
    }

    public void setIdMotivoBaja(int idMotivoBaja) {
        this.idMotivoBaja = idMotivoBaja;
    }
    
    @Override
    public String toString(){
        return this.detalle;
    }
}
