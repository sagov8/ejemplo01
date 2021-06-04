package com.example.ejemplo01.security.service;

import com.example.ejemplo01.security.entity.Usuario;
import com.example.ejemplo01.security.entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        if (usuarioService.getByNombreUsuario(nombreUsuario).isPresent()){
            Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
            return UsuarioPrincipal.build(usuario);
        }else{
            return null;
        }

    }
}
