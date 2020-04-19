package edu.prueba.dao;



import edu.prueba.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
  //parametro que usa spring para la seguridad, debe ser asi
    Usuario findByUsername(String username);
}
