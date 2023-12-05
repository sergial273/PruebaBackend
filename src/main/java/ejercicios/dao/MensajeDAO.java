package ejercicios.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ejercicios.dto.Mensaje;

@Repository
public interface MensajeDAO extends JpaRepository<Mensaje, Long>{
	
}