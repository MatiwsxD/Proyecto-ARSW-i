package edu.escuelaing.arsw.proyecto.controller;


import edu.escuelaing.arsw.proyecto.services.ServicesLogin;
import edu.escuelaing.arsw.proyecto.services.ServicesRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Level;
import java.util.logging.Logger;
@RestController
@RequestMapping(value = "/tictac")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class TicTacToeServiceController {
    @Autowired
    ServicesLogin serviciosLogin;
    @Autowired
    ServicesRoom serviciosSala;
    @PostMapping("/registry/{usuario}/{correo}/{password}")
    public ResponseEntity<?> registerPlayer(@PathVariable( value= "usuario")String usuario, @PathVariable(value = "correo") String correo, @PathVariable( value= "password") String password){
        serviciosLogin.registrarPlayer(usuario,correo, password);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @GetMapping("/login/{correo}/{password}")
    public ResponseEntity<?> loginPlayer(@PathVariable(value = "correo") String correo, @PathVariable(value = "password")String contraseña){

       return new ResponseEntity<>(serviciosLogin.loginPlayer(correo,contraseña), HttpStatus.ACCEPTED);

    }

    @GetMapping("/getUser/{correo}")
    public ResponseEntity<?> getUser(@PathVariable(value = "correo") String correo){
        return new ResponseEntity<>(serviciosSala.getPerfil(correo), HttpStatus.ACCEPTED);

    }

    @GetMapping("/checkUser/{correo}")
    public ResponseEntity<?> loginPlayer(@PathVariable(value = "correo") String correo){
        return new ResponseEntity<>(serviciosLogin.estaRegistrado(correo), HttpStatus.ACCEPTED);

    }
    @GetMapping("/players/{sala}")
    public ResponseEntity<?> introducirEnSala(@PathVariable(value = "sala") String sala){
        return new ResponseEntity<>(serviciosSala.playersInRoom(sala),HttpStatus.ACCEPTED);
    }

   @GetMapping("createRoom/{sala}")
    public ResponseEntity<?> crearSala(@PathVariable("sala") String sala){
        return new ResponseEntity<>(serviciosSala.createRoom(sala), HttpStatus.ACCEPTED);
    }

    @PostMapping("/resetRoom/{sala}")
    public ResponseEntity<?> resetRoom(@PathVariable("sala") String sala){
        serviciosSala.resetSala(sala);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
   @PostMapping("Winner/{correo}")
    public ResponseEntity<?> addWinner(@PathVariable("correo") String correo){
        serviciosSala.addWinn(correo);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
   }
    @PostMapping("Loser/{correo}")
    public ResponseEntity<?> addLoser(@PathVariable("correo") String correo){
        serviciosSala.addLoser(correo);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
