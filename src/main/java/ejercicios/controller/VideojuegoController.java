package ejercicios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ejercicios.dto.Videojuego;
import ejercicios.service.VideojuegoServiceImpl;

@RestController
@RequestMapping("/Videojuego")
public class VideojuegoController {

	@Autowired
	VideojuegoServiceImpl VideojuegoService;

	@GetMapping("/all")
	public List<Videojuego> getAll() {
		return VideojuegoService.getVideojuegos();
	}


}
