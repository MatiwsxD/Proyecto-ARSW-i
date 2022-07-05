package edu.escuelaing.arsw.proyecto.persistence;

import edu.escuelaing.arsw.proyecto.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutentificationLogin extends ConexionSQL{
    java.sql.Statement st;
    ResultSet rs;

    public boolean getUserLogin(String correo, String contraseña) {
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from register where correo='" + correo + "';";
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
            String sql = "insert into users(Usuario,Correo,Contraseña,pGanadas,pPerdidas,Mejoras) values('" + user.getName() + "','" + user.getCorreo() + "','" + user.getPassword() + "','" +user.getpGanadas()  + "','" + user.getpPerdidas()+ "','" + user.getMejoras()  + "');";
            st.execute(sql);
            st.close();
            conexion.close();
        } catch (Exception e) {
            Logger.getLogger(AutentificationLogin.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    public User getUser(String user) {
        User userInfo = new User();
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from register where user='" + user + "';";
            rs = st.executeQuery(sql);
            rs.next();
            userInfo.setName(rs.getString("Usuario"));
            userInfo.setpGanadas(rs.getInt("pGanadas"));
            userInfo.setpPerdidas(rs.getInt("pPerdidas"));
            return userInfo;
        }
        catch (Exception e) {
            Logger.getLogger(AutentificationLogin.class.getName()).log(Level.SEVERE, null, e);
            //System.out.println("no se encontro registro");
            return userInfo;
        }


    }







}