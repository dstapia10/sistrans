/**-------------------------------------------------------------------
 * $Id$
 * Universidad de los Andes (Bogot谩 - Colombia)
 * Departamento de Ingenier铆a de Sistemas y Computaci贸n
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

import vos.*;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los requerimientos de la aplicaci贸n
 * @author Juan
 */
public class DAOTablaActor {


	/**
	 * Arraylits de recursos que se usan para la ejecuci贸n de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexi贸n a la base de datos
	 */
	private Connection conn;

	/**
	 * M茅todo constructor que crea DAOVideo
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOTablaActor() {
		recursos = new ArrayList<Object>();
	}

	/**
	 * M茅todo que cierra todos los recursos que estan enel arreglo de recursos
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
	 * M茅todo que inicializa la connection del DAO a la base de datos con la conexi贸n que entra como par谩metro.
	 * @param con  - connection a la base de datos
	 */
	public void setConn(Connection con){
		this.conn = con;
	}


	public ArrayList<Actor> darActores() throws SQLException, Exception {
		ArrayList<Actor> actores = new ArrayList<Actor>();

		String sql = "SELECT * FROM ACTOR";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int cedula = Integer.parseInt(rs.getString("CEDULA"));
			String nombre = rs.getString("NOMBRE");
			int compa駃a = Integer.parseInt(rs.getString("ID_COMPA袸A"));
			String nacionalidad = rs.getString("NACIONALIDAD");
			actores.add(new Actor(cedula, compa駃a, nombre, nacionalidad));
		}
		return actores;
	}



	public ArrayList<Actor> buscarActorPorName(String name) throws SQLException, Exception {
		ArrayList<Actor> actores = new ArrayList<Actor>();

		String sql = "SELECT * FROM ACTOR WHERE NAME ='" + name + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int cedula = Integer.parseInt(rs.getString("CEDULA"));
			String nombre = rs.getString("NOMBRE");
			int compa駃a = Integer.parseInt(rs.getString("ID_COMPA袸A"));
			String nacionalidad = rs.getString("NACIONALIDAD");
			actores.add(new Actor(cedula, compa駃a, nombre, nacionalidad));
		}

		return actores;
	}


	public void addActor(Actor actor) throws SQLException, Exception {

		String sql = "INSERT INTO ACTOR VALUES (";
		sql += actor.getCedula() + ",'";
		sql += actor.getNombre() + "',";
		sql += actor.getIdCompania() + "',";
		sql += actor.getNacionalidad()+ ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	

	public void updateActor(Actor actor) throws SQLException, Exception {

		String sql = "UPDATE ACTOR SET ";
		sql += "NOMBRE='" + actor.getCedula() + "',";
		sql += "ID_COMPA袸A='" + actor.getIdCompania() + "',";
		sql += "NACIONALIDAD=" + actor.getNacionalidad();
		sql += " WHERE CEDULA = " + actor.getCedula();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}


	public void deleteActor(Actor actor) throws SQLException, Exception {

		String sql = "DELETE FROM ACTOR";
		sql += " WHERE id = " + actor.getCedula();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}



}
