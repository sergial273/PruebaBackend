package ejercicios.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ejercicios.dto.Usuario;
import ejercicios.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl UsuarioService;


	@PostMapping("")
	public Usuario createUsuario(@RequestBody Usuario Usuario) {
		return UsuarioService.saveUsuario(Usuario);
	}
	
	@PutMapping("/{id}")
	public Usuario updateUsuario(@PathVariable(name = "id") Long id, @RequestBody Usuario Usuario) {

		Usuario UsuarioSelected = new Usuario();

		UsuarioSelected = UsuarioService.usuarioPerId(id);

		UsuarioSelected.setNombreUsuario(Usuario.getNombreUsuario());
		UsuarioSelected.setUsuarioSteam(Usuario.getUsuarioSteam());
		UsuarioSelected.setPartidasCreadas(Usuario.getPartidasCreadas());
		UsuarioSelected.setPartidasUnidas(Usuario.getPartidasUnidas());

		UsuarioSelected = UsuarioService.updateUsuario(UsuarioSelected);

		return UsuarioSelected;
	}


}