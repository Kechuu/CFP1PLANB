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
public class Lugar {
    
    private int idLugar;
    private String nombre;
    private int nivel;
    private int de;

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getDe() {
        return de;
    }

    public void setDe(int de) {
        this.de = de;
    }
    
<<<<<<< HEAD
    public String toString(){
        return this.nombre;
    }
    
=======
    @Override
    public String toString(){
        return this.nombre;
    }
>>>>>>> 0fc1aca62c37cbff9225c6ec3675ae559b3b8fbb
    
}
