package edu.escuelaing.arsw.proyecto.services;


import edu.escuelaing.arsw.proyecto.model.User;
import edu.escuelaing.arsw.proyecto.persistence.AutentificationLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServicesRoom {
    AutentificationLogin data = new AutentificationLogin();
    private Map<String, Integer> rooms = new HashMap<String, Integer>();
    private boolean isInit = false;

    public void initServicesRoom(){
        rooms.put("A",0);
        rooms.put("B",0);
        rooms.put("C",0);
        rooms.put("D",0);
        rooms.put("E",0);
        rooms.put("F",0);
        rooms.put("G",0);

    }
    public Integer playersInRoom(String sala){
        return rooms.get(sala);

    }

    public void resetSala(String sala){
        rooms.replace(sala, 0);
    }

    public boolean createRoom(String sala){
        boolean flag = false;
        if(!isInit){
            initServicesRoom();
            isInit=true;
        }
        if(rooms.containsKey(sala) && rooms.get(sala)<2){
            Integer temp = rooms.get(sala);
            rooms.replace(sala, temp+1);
            flag = true;
        } else if (!rooms.containsKey(sala)) {
            rooms.put(sala,1);
            flag = true;
        }
        System.out.println(rooms.toString());
        return flag;
    }

    public User getPerfil(String correo){
        return data.getUser(correo);
    }
    public void addWinn(String correo){
        data.actualizarWinner(correo);
    }
    public void addLoser(String correo){
        data.actualizarLoser(correo);
    }

}
