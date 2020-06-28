package net.consorcio.fabrica;

import net.consorcio.dao.MySqlPostulanteDAO;
import net.consorcio.interfaces.PostulanteDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public PostulanteDAO getPostulanteDAO() {
		// TODO Auto-generated method stub
		return new MySqlPostulanteDAO();
	}

}
