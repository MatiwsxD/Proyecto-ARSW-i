package edu.escuelaing.arsw.proyecto.services;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServicesRoom {
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
}
