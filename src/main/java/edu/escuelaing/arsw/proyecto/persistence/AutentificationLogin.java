package edu.escuelaing.arsw.proyecto.persistence;

import edu.escuelaing.arsw.proyecto.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutentificationLogin extends ConexionSQL{
    java.sql.Statement st;
    ResultSet rs;

    public boolean getUserLogin(String iduser, String contraseña) {
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from register where idusuario='" + iduser + "';";
            rs = st.executeQuery(sql);
            if (rs.next() && rs.getString("password").equals(contraseña)) {
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e) {
            Logger.getLogger(AutentificationLogin.class.getName()).log(Level.SEVERE, null, e);
            //System.out.println("no se encontro registro");
            return false;
        }


    }

    public void insertar(User user) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into users(Usuario,Contraseña,Mejoras) values('" + user.getName() + "','" + user.getPassword() + "','" + user.getMejoras()  + "');";
            st.execute(sql);
            st.close();
            conexion.close();
        } catch (Exception e) {
            Logger.getLogger(AutentificationLogin.class.getName()).log(Level.SEVERE, null, e);
        }
    }







}