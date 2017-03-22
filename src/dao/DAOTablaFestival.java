/**-------------------------------------------------------------------
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 *
 * Materia: Sistemas Transaccionales
 * Ejercicio: VideoAndes
 * -------------------------------------------------------------------
 */
package dao;


import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import vos.*;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los requerimientos de la aplicación
 * @author Juan
 */
public class DAOTablaFestival {


	/**
	 * Arraylits de recursos que se usan para la ejecución de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexión a la base de datos
	 */
	private Connection conn;

	/**
	 * Método constructor que crea DAOVideo
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOTablaFestival() {
		recursos = new ArrayList<Object>();
	}

	/**
	 * Método que cierra todos los recursos que estan enel arreglo de recursos
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
	 * Método que inicializa la connection del DAO a la base de datos con la conexión que entra como parámetro.
	 * @param con  - connection a la base de datos
	 */
	public void setConn(Connection con){
		this.conn = con;
	}


	public ArrayList<Festival> darFestivales() throws SQLException, Exception {
		ArrayList<Festival> festivales = new ArrayList<Festival>();

		String sql = "SELECT * ISIS2304A261720.FESTIVAL";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			int idCiudad = Integer.parseInt(rs.getString("ID_CIUDAD"));
			Date fechaInicio = rs.getDate("FECHAINICIO");
			Date fechaFinal = rs.getDate("FECHAINICIO");
			festivales.add(new Festival(id, idCiudad, fechaInicio, fechaFinal));
		}
		return festivales;
	}


	
	public ArrayList<Festival> buscarFestivalPorName(String name) throws SQLException, Exception {
		ArrayList<Festival> festivales = new ArrayList<Festival>();

		String sql = "SELECT * ISIS2304A261720.FESTIVAL ='" + name + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			int idCiudad = Integer.parseInt(rs.getString("ID_CIUDAD"));
			Date fechaInicio = rs.getDate("FECHAINICIO");
			Date fechaFinal = rs.getDate("FECHAINICIO");
			festivales.add(new Festival(id, idCiudad, fechaInicio, fechaFinal));
		}

		return festivales;
	}

	
	public void addFestival(Festival festival) throws SQLException, Exception {

		String sql = "INSERT INTO ISIS2304A261720.FESTIVAL VALUES (";
		sql += festival.getId() + ",'";
		sql += festival.getIdCiudad() + "',";
		sql += festival.getFechaInicio() + "',";
		sql += festival.getFechaFinal() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}


	public void updateFestival(Festival festival) throws SQLException, Exception {

		String sql = "UPDATE ISIS2304A261720.FESTIVAL SET ";
		sql += "ID_CIUDAD='" + festival.getIdCiudad() + "',";
		sql += "FECHAINICIO='" + festival.getFechaInicio() + "',";
		sql += "FECHAFINAL=" + festival.getFechaFinal();
		sql += " WHERE id = " + festival.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	
	public void deleteFestival(Festival festival) throws SQLException, Exception 
	{

		String sql = "DELETE FROM ISIS2304A261720.FESTIVAL";
		sql += " WHERE id = " + festival.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	

}
