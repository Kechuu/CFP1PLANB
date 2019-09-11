/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;

/**
 *
 * @author araa
 */
public class Horario {
    
    private int idHorario;
    private Time desde;
    private Time hasta;
    private int dia;

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Time getDesde() {
        return desde;
    }

    public void setDesde(Time desde) {
        this.desde = desde;
    }

    public Time getHasta() {
        return hasta;
    }

    public void setHasta(Time hasta) {
        this.hasta = hasta;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
    
}
