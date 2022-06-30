package edu.escuelaing.arsw.proyecto.controller;


import edu.escuelaing.arsw.proyecto.services.ServicesLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tbInteractivo")
public class TicTacToeServiceController {
    @Autowired
    //servicesTicTacToes serviciosInGame;
    ServicesLogin serviciosLogin;

    @PutMapping("/registry")
    public ResponseEntity<?> registerPlayer(@RequestParam( value= "usuario")String usuario, @RequestParam( value= "password") String password){
        serviciosLogin.registrarPlayer(usuario,password);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
