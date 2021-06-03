package com.example.ejemplo01.security.service;

import com.example.ejemplo01.security.entity.Usuario;
import com.example.ejemplo01.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existByEmail(String email) {
        return usuarioRepository.existByEmail(email);
    }

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
