package ejercicios.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ejercicios.dto.Videojuego;

@Repository
public interface VideojuegoDAO extends JpaRepository<Videojuego, Long>{
	
}