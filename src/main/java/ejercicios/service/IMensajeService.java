package ejercicios.service;

import ejercicios.dto.Mensaje;

public interface IMensajeService {

	public Mensaje saveMensaje(Mensaje Mensaje);

	public Mensaje updateMensaje(Mensaje Mensaje);

	public void deleteMensaje(Long id);
	
	public Mensaje mensajePerId(Long id);

}