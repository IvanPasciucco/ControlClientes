package edu.prueba.dao;


import edu.prueba.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDao extends JpaRepository<Persona, Long>{
    
}
