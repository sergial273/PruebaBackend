package ejercicios.service;

import java.util.List;


import ejercicios.dto.Mensaje;
import ejercicios.dto.Partida;

public interface IPartidaService {

	public Partida savePartida(Partida Partida);

	public List<Mensaje> getMensajesDePartida(Long idPartida);
	
	public List<Partida> getPartidasPorVideojuego(Long idVideojuego);

}