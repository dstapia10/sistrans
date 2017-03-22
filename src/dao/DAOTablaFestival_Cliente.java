package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Actor;
import vos.Festival_Cliente;

public class DAOTablaFestival_Cliente {
	
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
	public DAOTablaFestival_Cliente() {
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


	public ArrayList<Festival_Cliente> darFestivalClientes() throws SQLException, Exception {
//		ArrayList<Actor> actores = new ArrayList<Actor>();
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
//			actores.add(new Actor(cedula, compañia, nombre, nacionalidad));
//		}
//		return actores;
		
		return null;
	}



	public ArrayList<Festival_Cliente> buscarFestivalClientePorCedula(int nCedula) throws SQLException, Exception {
//		ArrayList<Actor> actores = new ArrayList<Actor>();
//
//		String sql = "SELECT * FROM ACTOR WHERE CEDULA ='" + cedula2 + "'";
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
	
	public ArrayList<Festival_Cliente> buscarFestivalClientePorIdFestival(int idFestival) throws SQLException, Exception {
//		ArrayList<Actor> actores = new ArrayList<Actor>();
//
//		String sql = "SELECT * FROM ACTOR WHERE CEDULA ='" + cedula2 + "'";
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


	public void addFestivalCliente(Festival_Cliente festivalCliente) throws SQLException, Exception {
//		String sql = "INSERT INTO ACTOR VALUES ('";
//		sql += actor.getCedula() + "','";
//		sql += actor.getNombre() + "','";
//		sql += actor.getIdCompania() + "','";
//		sql += actor.getNacionalidad()+ "')";
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
	}
	

	public void updateFestivalCliente(Festival_Cliente festivalCliente) throws SQLException, Exception {
//		String sql = "UPDATE ACTOR SET ";
//		sql += "NOMBRE='" + actor.getNombre() + "',";
//		sql += "ID_COMPAÑIA='" + actor.getIdCompania() + "',";
//		sql += "NACIONALIDAD='" + actor.getNacionalidad()+ "'";
//		sql += " WHERE CEDULA = " + actor.getCedula();
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
	}


	public void deleteFestivalCliente(Festival_Cliente actor) throws SQLException, Exception {
//		String sql = "DELETE FROM ACTOR";
//		sql += " WHERE CEDULA = " + actor.getCedula();
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
	}

}
