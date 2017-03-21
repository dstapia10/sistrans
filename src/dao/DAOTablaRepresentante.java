<<<<<<< HEAD
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
=======
package dao;

import java.sql.Connection;
>>>>>>> origin/master
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

<<<<<<< HEAD
import vos.*;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los requerimientos de la aplicación
 * @author Juan
 */
public class DAOTablaRepresentante {


=======
import vos.Actor;
import vos.Representante;

public class DAOTablaRepresentante {
	
>>>>>>> origin/master
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
	public DAOTablaRepresentante() {
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


<<<<<<< HEAD
	public ArrayList<Representante> darActores() throws SQLException, Exception {
		ArrayList<Representante> actores = new ArrayList<Representante>();
=======
	public ArrayList<Representante> darRepresentante() throws SQLException, Exception {
		ArrayList<Representante> representantes = new ArrayList<Representante>();
>>>>>>> origin/master

		String sql = "SELECT * FROM REPRESENTANTE";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int cedula = Integer.parseInt(rs.getString("CEDULA"));
			String nombre = rs.getString("NOMBRE");
<<<<<<< HEAD
			
			actores.add(new Representante(cedula, nombre));
		}
		return actores;
	}




	public void addRepresentante(Representante representante) throws SQLException, Exception {

		String sql = "INSERT INTO REPRESENTANTE VALUES ('";
		sql += representante.getCedula() + "','";
		
		sql += representante.getNombre()+ "')";
=======
			representantes.add(new Representante(cedula, nombre));
		}
		return representantes;
	}
	
		
	public ArrayList<Representante> buscarRepresentantePorName(String name) throws SQLException, Exception {
		ArrayList<Representante> representantes = new ArrayList<Representante>();

		String sql = "SELECT * FROM REPRESENTANTE WHERE NOMBRE ='" + name + "'";
>>>>>>> origin/master

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
<<<<<<< HEAD
		prepStmt.executeQuery();

	}
	

	public void updateRepresentante(Representante representante) throws SQLException, Exception {

		String sql = "UPDATE REPRESENTANTE SET ";
		sql += "NOMBRE='" + representante.getNombre() + "'";

		sql += " WHERE CEDULA = " + representante.getCedula();
=======
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int cedula = Integer.parseInt(rs.getString("CEDULA"));
			String nombre = rs.getString("NOMBRE");
			representantes.add(new Representante(cedula, nombre));
		}

		return representantes;
	}
	
	
	public ArrayList<Representante> buscarRepresentantePorCedula(int nCedula) throws SQLException, Exception {
		ArrayList<Representante> representantes = new ArrayList<Representante>();

		String sql = "SELECT * FROM REPRESENTANTE WHERE CEDULA ='" + nCedula + "'";
>>>>>>> origin/master

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
<<<<<<< HEAD
		prepStmt.executeQuery();
	}


	public void deleteRepresentante(Representante representante) throws SQLException, Exception {

		String sql = "DELETE FROM REPRESENTANTE";
		sql += " WHERE CEDULA = " + representante.getCedula();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}



=======
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int cedula = Integer.parseInt(rs.getString("CEDULA"));
			String nombre = rs.getString("NOMBRE");
			representantes.add(new Representante(cedula, nombre));
		}

		return representantes;
	}


//	public void addRepresentante(Representante representante) throws SQLException, Exception {
//
//		String sql = "INSERT INTO REPRESENTANTE VALUES ('";
//		sql += representante.getCedula() + "','";
//		sql += representante.getNombre()+ "')";
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
//
//	}
//	
//
//	public void updateActor(Actor actor) throws SQLException, Exception {
//
//		String sql = "UPDATE ACTOR SET ";
//		sql += "NOMBRE='" + actor.getNombre() + "',";
//		sql += "ID_COMPA�IA='" + actor.getIdCompania() + "',";
//		sql += "NACIONALIDAD='" + actor.getNacionalidad()+ "'";
//		sql += " WHERE CEDULA = " + actor.getCedula();
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
//	}
//
//
//	public void deleteActor(Actor actor) throws SQLException, Exception {
//
//		String sql = "DELETE FROM ACTOR";
//		sql += " WHERE CEDULA = " + actor.getCedula();
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
//	}
	
>>>>>>> origin/master
}
