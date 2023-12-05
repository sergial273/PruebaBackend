package ejercicios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ejercicios.dto.Mensaje;
import ejercicios.dto.Partida;
import ejercicios.service.PartidaServiceImpl;

@RestController
@RequestMapping("/Partida")
public class PartidaController {

	@Autowired
	PartidaServiceImpl PartidaService;

	@PostMapping("")
	public Partida createPartida(@RequestBody Partida Partida) {
		return PartidaService.savePartida(Partida);
	}
	
	@GetMapping("/{idPartida}/mensajes")
    public ResponseEntity<List<Mensaje>> getMensajesDePartida(@PathVariable Long idPartida) {
        List<Mensaje> mensajes = PartidaService.getMensajesDePartida(idPartida);
        if (mensajes != null) {
            return new ResponseEntity<>(mensajes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/videojuego/{idVideojuego}")
    public ResponseEntity<List<Partida>> getPartidasPorVideojuego(@PathVariable Long idVideojuego) {
        List<Partida> partidas = PartidaService.getPartidasPorVideojuego(idVideojuego);
        if (partidas != null) {
            return new ResponseEntity<>(partidas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
