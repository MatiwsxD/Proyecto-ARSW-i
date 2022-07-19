package edu.escuelaing.arsw.proyecto.services;

import edu.escuelaing.arsw.proyecto.model.User;
import edu.escuelaing.arsw.proyecto.persistence.AutentificationLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesLogin {
   AutentificationLogin data = new AutentificationLogin();
    public void registrarPlayer(String usuario,String correo ,String contraseña){
        User userProfile = new User();
        userProfile.setName(usuario);
        userProfile.setPassword(contraseña);
        userProfile.setCorreo(correo);
        data.insertar(userProfile);
    }

    public boolean estaRegistrado(String correo){
        return data.isRegister(correo);
    }



    public boolean loginPlayer(String correo, String contraseña){
        return data.getUserLogin(correo, contraseña);
    }

    public User getUser(String usuario){
        return data.getUser(usuario);
    }

}
