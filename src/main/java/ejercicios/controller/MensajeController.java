package ejercicios.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ejercicios.dto.Mensaje;
import ejercicios.service.MensajeServiceImpl;

@RestController
@RequestMapping("/Mensaje")
public class MensajeController {

	@Autowired
	MensajeServiceImpl MensajeService;

	@PostMapping("")
	public Mensaje createMensaje(@RequestBody Mensaje Mensaje) {
		return MensajeService.saveMensaje(Mensaje);
	}

	@PutMapping("/{id}")
	public Mensaje updateMensaje(@PathVariable(name = "id") Long id, @RequestBody Mensaje Mensaje) {

		Mensaje MensajeSelected = new Mensaje();

		MensajeSelected = MensajeService.mensajePerId(id);

		MensajeSelected.setPartida(Mensaje.getPartida());
		MensajeSelected.setUsuario(Mensaje.getUsuario());
		MensajeSelected.setContenido(Mensaje.getContenido());
		MensajeSelected.setFechaEnvio(Mensaje.getFechaEnvio());

		MensajeSelected = MensajeService.updateMensaje(MensajeSelected);

		return MensajeSelected;
	}

	@DeleteMapping("/{id}")
	public void deleteMensaje(@PathVariable(name = "id") Long id) {
		MensajeService.deleteMensaje(id);
	}

}
