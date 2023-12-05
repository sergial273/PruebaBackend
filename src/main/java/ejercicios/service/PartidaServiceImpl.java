package ejercicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejercicios.dao.PartidaDAO;
import ejercicios.dao.VideojuegoDAO;
import ejercicios.dto.Mensaje;
import ejercicios.dto.Partida;
import ejercicios.dto.Videojuego;

@Service
public class PartidaServiceImpl implements IPartidaService{

	@Autowired
	PartidaDAO PartidaDAO;
	
	@Autowired
	VideojuegoDAO VideojuegoDAO;

	public Partida savePartida(Partida Partida) {
		return PartidaDAO.save(Partida);
	}
	
	public List<Mensaje> getMensajesDePartida(Long idPartida) {
        Partida partida = PartidaDAO.findById(idPartida).orElse(null);
        if (partida != null) {
            return partida.getMensajes();
        }
        return null;
    }
	
	public List<Partida> getPartidasPorVideojuego(Long idVideojuego) {
        Videojuego videojuego = VideojuegoDAO.findById(idVideojuego).orElse(null);
        if (videojuego != null) {
            return PartidaDAO.findByVideojuego(videojuego);
        }
        return null;
    }
	
}
