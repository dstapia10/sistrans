package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Actor;
import vos.Obra;
import vos.ReporteFuncion;
import vos.ReporteObra;

public class DAOTablaObra {
	
	/**
	 * Arraylits de recursos que se usan para la ejecuciÃ³n de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexiÃ³n a la base de datos
	 */
	private Connection conn;

	/**
	 * MÃ©todo constructor que crea DAOVideo
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOTablaObra() {
		recursos = new ArrayList<Object>();
	}

	/**
	 * MÃ©todo que cierra todos los recursos que estan enel arreglo de recursos
	 * <b>post: </b> Todos los recurso del arreglo de recursos han sido cerrados
	 */
	public void cerrarRecursos() {
		for(Object ob : recursos){
			if(ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}

	/**
	 * MÃ©todo que inicializa la connection del DAO a la base de datos con la conexiÃ³n que entra como parÃ¡metro.
	 * @param con  - connection a la base de datos
	 */
	public void setConn(Connection con){
		this.conn = con;
	}


	public ArrayList<Obra> darObras() throws SQLException, Exception {
//		ArrayList<Obra> obras = new ArrayList<Obra>();
//
//		String sql = "SELECT * FROM ACTOR";
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		ResultSet rs = prepStmt.executeQuery();
//
//		while (rs.next()) {
//			int cedula = Integer.parseInt(rs.getString("CEDULA"));
//			String nombre = rs.getString("NOMBRE");
//			int compañia = Integer.parseInt(rs.getString("ID_COMPAÑIA"));
//			String nacionalidad = rs.getString("NACIONALIDAD");
//			obras.add(new Actor(cedula, compañia, nombre, nacionalidad));
//		}
//		return obras;
		return null;
	}



	public ArrayList<Obra> buscarObraPorName(String name) throws SQLException, Exception {
//		ArrayList<Actor> actores = new ArrayList<Actor>();
//
//		String sql = "SELECT * FROM ACTOR WHERE NAME ='" + name + "'";
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		ResultSet rs = prepStmt.executeQuery();
//
//		while (rs.next()) {
//			int cedula = Integer.parseInt(rs.getString("CEDULA"));
//			String nombre = rs.getString("NOMBRE");
//			int compañia = Integer.parseInt(rs.getString("ID_COMPAÑIA"));
//			String nacionalidad = rs.getString("NACIONALIDAD");
//			actores.add(new Actor(cedula, compañia, nombre, nacionalidad));
//		}
//
//		return actores;
		return null;
	}
	
	public ArrayList<Obra> buscarObraPorId(int id) throws SQLException, Exception {
//		ArrayList<Actor> actores = new ArrayList<Actor>();
//
//		String sql = "SELECT * FROM ACTOR WHERE NAME ='" + name + "'";
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		ResultSet rs = prepStmt.executeQuery();
//
//		while (rs.next()) {
//			int cedula = Integer.parseInt(rs.getString("CEDULA"));
//			String nombre = rs.getString("NOMBRE");
//			int compañia = Integer.parseInt(rs.getString("ID_COMPAÑIA"));
//			String nacionalidad = rs.getString("NACIONALIDAD");
//			actores.add(new Actor(cedula, compañia, nombre, nacionalidad));
//		}
//
//		return actores;
		return null;
	}


	public void addObra(Obra obra) throws SQLException, Exception {

		String sql = "INSERT INTO ISIS2304A261720.OBRA VALUES ('";
		sql += obra.getId() + "','";
		sql += obra.getNombre() + "','";
		sql += obra.getRequerimientos() + "','";
		sql += obra.getIdioma() + "','";
		sql += obra.getDescripcion() + "','";
		sql += obra.getCosto()+ "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	

	public void updateObra(Obra obra) throws SQLException, Exception {

		String sql = "UPDATE ISIS2304A261720.OBRA SET ";
		sql += "NOMBRE='" + obra.getNombre() + "',";
		sql += "REQUERIMIENTOS='" + obra.getRequerimientos() + "',";
		sql += "IDIOMA='" + obra.getIdioma() + "',";
		sql += "COSTO=" + obra.getCosto() + "'";
		sql += " WHERE ID = " + obra.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}


	public void deleteObra(Obra obra) throws SQLException, Exception {

		String sql = "DELETE FROM ISIS2304A261720.OBRA";
		sql += " WHERE ID = " + obra.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public ReporteObra darReporteObraPorId(int nId) throws SQLException, Exception {
		ArrayList<Obra> obras = new ArrayList<Obra>();

		String sql = "SELECT * FROM OBRA, FUNCION WHERE OBRA.ID=FUNCION.IDOBRA AND OBRA:ID=";
		sql += nId;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		
		
		while (rs.next()) {
			int idFuncion = Integer.parseInt(rs.getString("FUNCION.ID"));
			
			
		}
		
		
		
		return null;
	}
	
}
