package ejercicios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejercicios.dao.UsuarioDAO;
import ejercicios.dto.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	UsuarioDAO UsuarioDAO;

	public Usuario saveUsuario(Usuario Usuario) {
		return UsuarioDAO.save(Usuario);
	}
	
	public Usuario updateUsuario(Usuario Usuario) {
		return UsuarioDAO.save(Usuario);
	}
	
	public Usuario usuarioPerId(Long id) {
		return UsuarioDAO.findById(id).get();
	}
}