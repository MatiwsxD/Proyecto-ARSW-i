package edu.escuelaing.arsw.proyecto.services;

import edu.escuelaing.arsw.proyecto.model.User;
import edu.escuelaing.arsw.proyecto.persistence.AutentificationLogin;
import org.springframework.stereotype.Service;

@Service
public class ServicesLogin {
    public void registrarPlayer(String usuario,String correo ,String contraseña){
        User userProfile = new User();
        userProfile.setName(usuario);
        userProfile.setPassword(contraseña);
        userProfile.setCorreo(correo);
        AutentificationLogin data = new AutentificationLogin();
        data.insertar(userProfile);
    }

    public boolean estaRegistrado(String usuario){
        AutentificationLogin data = new AutentificationLogin();
        return data.isRegister(usuario);
    }

    public boolean loginPlayer(String correo, String contraseña){
        AutentificationLogin data = new AutentificationLogin();
        return data.getUserLogin(correo, contraseña);
    }

    public User getUser(String usuario){
        AutentificationLogin data = new AutentificationLogin();
        return data.getUser(usuario);
    }
    public void regRecompenza(String recompenza, String recompensa){
        AutentificationLogin data = new AutentificationLogin();
        ///Queda pendiente por ver si se puede guardar un array en postgres

    }
}
