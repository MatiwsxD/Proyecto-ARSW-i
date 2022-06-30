package edu.escuelaing.arsw.proyecto.model;

import java.util.ArrayList;

public class User {
    public User (){

    }
    private String name;
    private String password;
    private Integer pGanadas = 0;
    private Integer pPerdidas = 0;
    private ArrayList<String> mejoras = new ArrayList<String>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getpGanadas() {
        return pGanadas;
    }

    public void setpGanadas(Integer pGanadas) {
        this.pGanadas = pGanadas;
    }

    public Integer getpPerdidas() {
        return pPerdidas;
    }

    public void setpPerdidas(Integer pPerdidas) {
        this.pPerdidas = pPerdidas;
    }

    public ArrayList<String> getMejoras() {
        return mejoras;
    }

    public void setMejoras(ArrayList<String> mejoras) {
        this.mejoras = mejoras;
    }
}
