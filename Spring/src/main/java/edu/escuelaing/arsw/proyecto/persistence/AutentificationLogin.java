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
            String sql = "select * from registro where correo='" + correo + "';";
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
            String sql = "insert into registro(usernames,correo,password,pganadas,pperdidas) values('" + user.getName() + "','" + user.getCorreo() + "','" + user.getPassword() + "','" +user.getpGanadas()  + "','" + user.getpPerdidas()+"');";
            st.execute(sql);
            st.close();
            conexion.close();
        } catch (Exception e) {
            Logger.getLogger(AutentificationLogin.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    public User getUser(String correo) {
        User userInfo = new User();
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from registro where correo='" + correo + "';";
            rs = st.executeQuery(sql);
            if(rs.next()){
                userInfo.setName(rs.getString("usernames"));
                userInfo.setpGanadas(Integer.valueOf(rs.getString("pganadas")));
                userInfo.setpPerdidas(Integer.valueOf(rs.getString("pperdidas")));
            }
            else{
                userInfo.setName("No value");
            }

            return userInfo;
        }
        catch (Exception e) {
            Logger.getLogger(AutentificationLogin.class.getName()).log(Level.SEVERE, null, e);
            //System.out.println("no se encontro registro");
            return userInfo;
        }


    }

    public boolean isRegister(String correo) {
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from registro where correo='" + correo + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
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
    public void actualizarWinner(String correo) {
        User userInfo = new User();
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from registro where correo='" + correo + "';";
            rs = st.executeQuery(sql);
            if(rs.next()){
                userInfo.setName(rs.getString("usernames"));
                userInfo.setCorreo(rs.getString("correo"));
                userInfo.setPassword(rs.getString("password"));
                userInfo.setpGanadas(1+Integer.valueOf(rs.getString("pganadas")));
                userInfo.setpPerdidas(Integer.valueOf(rs.getString("pperdidas")));
                String sql2="delete from registro where correo='"+correo+"'; ";
                st.executeUpdate(sql2);
                insertar(userInfo);

            }
        }
        catch (Exception e){
            Logger.getLogger(AutentificationLogin.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void actualizarLoser(String correo) {
        User userInfo = new User();
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from registro where correo='" + correo + "';";
            rs = st.executeQuery(sql);
            if(rs.next()){
                userInfo.setName(rs.getString("usernames"));
                userInfo.setCorreo(rs.getString("correo"));
                userInfo.setPassword(rs.getString("password"));
                userInfo.setpGanadas(Integer.valueOf(rs.getString("pganadas")));
                userInfo.setpPerdidas(1+Integer.valueOf(rs.getString("pperdidas")));
                String sql2="delete from registro where correo='"+correo+"'; ";
                st.executeUpdate(sql2);
                insertar(userInfo);

            }
        }
        catch (Exception e){
            Logger.getLogger(AutentificationLogin.class.getName()).log(Level.SEVERE, null, e);
        }
    }








}