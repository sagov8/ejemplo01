package com.example.ejemplo01.security.repository;

import com.example.ejemplo01.security.entity.Rol;
import com.example.ejemplo01.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository <Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
