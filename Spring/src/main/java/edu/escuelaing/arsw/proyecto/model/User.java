package edu.escuelaing.arsw.proyecto.model;

import java.util.ArrayList;

public class User {
    private String name;
    private String correo;
    private String password;
    private Integer pGanadas = 0;
    private Integer pPerdidas = 0;
    public User (){

    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

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

}
