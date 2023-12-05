package ejercicios.service;


import ejercicios.dto.Usuario;

public interface IUsuarioService {
	
	public Usuario saveUsuario(Usuario Usuario);

	public Usuario updateUsuario(Usuario Usuario);
	
	public Usuario usuarioPerId(Long id);

}