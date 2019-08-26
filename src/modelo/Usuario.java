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
public class Usuario {
    
    private int idUsuario;
    private String pass;
    private int jerarquia;
    private Persona idPersona;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(int jerarquia) {
        this.jerarquia = jerarquia;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }
    
    
}
