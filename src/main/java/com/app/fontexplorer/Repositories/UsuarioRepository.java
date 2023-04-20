package com.app.fontexplorer.Repositories;

import com.app.fontexplorer.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsuario(String usuario);

    boolean existsByEmail(String email);
}