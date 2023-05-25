package com.app.fontexplorer.Controller;


import com.app.fontexplorer.Entities.Usuario;
import com.app.fontexplorer.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/seeUsuarios")
    @ResponseBody
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }


    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            return new ResponseEntity<>("El email ya existe en la base de datos", HttpStatus.BAD_REQUEST);
        }
        if (usuarioRepository.existsByUsuario(usuario.getUsuario())) {
            return new ResponseEntity<>("El usuario ya existe en la base de datos", HttpStatus.BAD_REQUEST);
        }
        usuarioRepository.save(usuario);
        return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.OK);
    }
}
