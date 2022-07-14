package edu.escuelaing.arsw.proyecto.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionSQL {
    Connection conn=null;
    private String url = "jdbc:postgresql://ec2-18-204-142-254.compute-1.amazonaws.com:5432/de02prt19oul2j?sslmode=require";
    private String usuario = "ddxrjkhfmijtep";
    private String clave = "31d2ce960d66bc70a7740f3146ef0f4865af4244ffcc505a2ef9bdbfacb413d2";

    public Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            conn=DriverManager.getConnection(url,usuario,clave);

        } catch (Exception e) {
            Logger.getLogger(AutentificationLogin.class.getName()).log(Level.SEVERE, null, e);
            //System.out.println("Error conexion base de datos");
        }
        return conn;
    }

}