package net.consorcio.interfaces;

import java.util.List;

import net.consorcio.entidad.Postulante;

public interface PostulanteDAO {
	public Postulante find(int cod);
	public List<Postulante> listAll();
	public int save(Postulante bean);
	public int update(Postulante bean);
	public int delete(int cod);
	
}
