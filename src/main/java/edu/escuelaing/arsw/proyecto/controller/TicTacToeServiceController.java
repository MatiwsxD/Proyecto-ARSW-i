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
    public ResponseEntity<?> registerPlayer(@RequestParam( value= "usuario")String usuario, @RequestParam(value = "correo") String correo, @RequestParam( value= "password") String password){
        serviciosLogin.registrarPlayer(usuario,password, correo);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @GetMapping("/login")
    public ResponseEntity<?> loginPlayer(@RequestParam(value = "correo") String correo, @RequestParam(value = "password")String contraseña){

       return new ResponseEntity<>(serviciosLogin.loginPlayer(correo,contraseña), HttpStatus.ACCEPTED);

    }

    @GetMapping("/getUser")
    public ResponseEntity<?> getUser(@RequestParam(value = "user") String user){
        return new ResponseEntity<>(serviciosLogin.getUser(user), HttpStatus.ACCEPTED);

    }

    @PutMapping("/addRecompenza")
    public ResponseEntity<?> addRecompensa(@RequestParam(value = "user") String user, @RequestParam(value = "rescompensa") String recompensa){
        serviciosLogin.regRecompenza(user, recompensa);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
