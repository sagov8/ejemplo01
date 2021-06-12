
package com.example.ejemplo01.repository;

import com.example.ejemplo01.entity.Producto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sagov8
 */
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
    
    Optional<Producto> findByName(String name);
    Producto findById(int id);
    boolean existsByName(String name);
}
