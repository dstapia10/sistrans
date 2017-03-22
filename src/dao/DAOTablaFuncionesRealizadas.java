package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Actor;
import vos.FuncionRealizada;

public class DAOTablaFuncionesRealizadas {
	
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
	public DAOTablaFuncionesRealizadas() {
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


	public ArrayList<FuncionRealizada> darFuncionesRealizadas() throws SQLException, Exception {
		ArrayList<FuncionRealizada> funcionesRealizadas = new ArrayList<FuncionRealizada>();

		String sql = "SELECT * FROM FUNCIONREALIZADA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int idFuncionRealizada = Integer.parseInt(rs.getString("CEDULA"));
			funcionesRealizadas.add(new FuncionRealizada(idFuncionRealizada));
		}
		return funcionesRealizadas;
	}



	public ArrayList<FuncionRealizada> buscarFuncionRealizadaPorId(int id) throws SQLException, Exception {
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
//			int compa�ia = Integer.parseInt(rs.getString("ID_COMPA�IA"));
//			String nacionalidad = rs.getString("NACIONALIDAD");
//			actores.add(new Actor(cedula, compa�ia, nombre, nacionalidad));
//		}
//
//		return actores;
		
		return null;
	}


	public void addFuncionRealizada(FuncionRealizada FuncionRealizada) throws SQLException, Exception {
		String sql = "INSERT INTO FUNCIONREALIZADA VALUES ('";
		sql += FuncionRealizada.getIdFuncion()+ "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteFuncionRealizada(FuncionRealizada funcionRealizada) throws SQLException, Exception {

		String sql = "DELETE FROM FUNCIONREALIZADA";
		sql += " WHERE ID_FUNCION = " + funcionRealizada.getIdFuncion();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
}
