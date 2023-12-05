package ejercicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejercicios.dao.VideojuegoDAO;
import ejercicios.dto.Videojuego;

@Service
public class VideojuegoServiceImpl implements IVideojuegoService{

	@Autowired
	VideojuegoDAO VideojuegoDAO;

	public List<Videojuego> getVideojuegos() {
		return VideojuegoDAO.findAll();
	}

}
