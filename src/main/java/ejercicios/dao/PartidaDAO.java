package ejercicios.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ejercicios.dto.Partida;
import ejercicios.dto.Videojuego;

@Repository
public interface PartidaDAO extends JpaRepository<Partida, Long>{
	List<Partida> findByVideojuego(Videojuego Videojuego);
}