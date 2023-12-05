package ejercicios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejercicios.dao.MensajeDAO;
import ejercicios.dto.Mensaje;

@Service
public class MensajeServiceImpl implements IMensajeService{

	@Autowired
	MensajeDAO MensajeDAO;

	public Mensaje saveMensaje(Mensaje Mensaje) {
		return MensajeDAO.save(Mensaje);
	}
	
	public Mensaje updateMensaje(Mensaje Mensaje) {
		return MensajeDAO.save(Mensaje);
	}
	
	public void deleteMensaje(Long id) {
		MensajeDAO.deleteById(id);
	}
	
	public Mensaje mensajePerId(Long id) {
		return MensajeDAO.findById(id).get();
	}
}