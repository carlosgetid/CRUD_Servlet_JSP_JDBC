package net.consorcio.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import net.consorcio.entidad.Postulante;
import net.consorcio.interfaces.PostulanteDAO;
import net.consorcio.utils.MySqlBDConexion;
public class MySqlPostulanteDAO implements PostulanteDAO {

	@Override
	public Postulante find(int cod) {
		Postulante bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select *from tb_postulante where cod=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				bean=new Postulante();
				bean.setCodigo(rs.getInt(1));
				bean.setNombres(rs.getString(2));
				bean.setApellidos(rs.getString(3));
				bean.setEdad(rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}

	@Override
	public List<Postulante> listAll() {
		List<Postulante> lista=new ArrayList<Postulante>();
		Postulante bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select *from tb_postulante";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new Postulante();
				bean.setCodigo(rs.getInt(1));
				bean.setNombres(rs.getString(2));
				bean.setApellidos(rs.getString(3));
				bean.setEdad(rs.getInt(4));
				lista.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public int save(Postulante bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="insert into tb_postulante values(null,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getNombres());
			pstm.setString(2, bean.getApellidos());
			pstm.setInt(3, bean.getEdad());
			salida=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}


	@Override
	public int update(Postulante bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="update tb_postulante set nom=?,ape=?,edad=? where cod=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getNombres());
			pstm.setString(2, bean.getApellidos());
			pstm.setInt(3, bean.getEdad());
			pstm.setInt(4, bean.getCodigo());
			salida=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public int delete(int cod) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="delete from tb_postulante where cod=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1,cod);
			salida=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

}
