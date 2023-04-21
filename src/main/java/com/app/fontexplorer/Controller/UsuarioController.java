package com.app.fontexplorer.Controller;


import com.app.fontexplorer.Entities.Usuario;
import com.app.fontexplorer.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
