package ejercicios.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ejercicios.dto.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
	
}