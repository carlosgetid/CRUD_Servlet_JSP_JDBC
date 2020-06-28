package net.consorcio.service;

import java.util.List;

import net.consorcio.entidad.Postulante;
import net.consorcio.fabrica.DAOFactory;
import net.consorcio.interfaces.PostulanteDAO;

public class PostulanteService {
	DAOFactory dao = DAOFactory.getDAOFactory(1);
	
	PostulanteDAO daoPostulante=dao.getPostulanteDAO();
	
	public Postulante buscar(int cod) {
		return daoPostulante.find(cod);
	}
	
	public List<Postulante> listar(){
		return daoPostulante.listAll();
	}
	
	public int registrar(Postulante bean) {
		return daoPostulante.save(bean);
	}
	
	public int actualizar(Postulante bean) {
		return daoPostulante.update(bean);
	}
	
	public int eliminar(int cod) {
		return daoPostulante.delete(cod);
	}
	
	
	
	
	
	
}
