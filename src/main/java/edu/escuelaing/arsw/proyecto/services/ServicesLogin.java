package edu.escuelaing.arsw.proyecto.services;

import edu.escuelaing.arsw.proyecto.model.User;
import edu.escuelaing.arsw.proyecto.persistence.AutentificationLogin;

public class ServicesLogin {
    public void registrarPlayer(String usuario, String contraseña){
        User userProfile = new User();
        userProfile.setName(usuario);
        userProfile.setPassword(contraseña);
        AutentificationLogin data = new AutentificationLogin();
        data.insertar(userProfile);
    }
}
