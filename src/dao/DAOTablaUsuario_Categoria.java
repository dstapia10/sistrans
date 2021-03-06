package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Boleta;
import vos.Usuario_Categoria;

public class DAOTablaUsuario_Categoria {
	
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
	public DAOTablaUsuario_Categoria() {
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


	public ArrayList<Usuario_Categoria> darUsuario_Categoria() throws SQLException, Exception {
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
//			int compa�ia = Integer.parseInt(rs.getString("ID_COMPA�IA"));
//			String nacionalidad = rs.getString("NACIONALIDAD");
//			actores.add(new Actor(cedula, compa�ia, nombre, nacionalidad));
//		}
//		return actores;
		
		return null;
	}

	
	public void addUsuario_Categoria(Usuario_Categoria usuca) throws SQLException, Exception {
		String sql = "INSERT INTO ISIS2304A261720.USUARIO_CATEGORIA VALUES ('";
		sql += usuca.getIdUsuario() + "','";
		sql += usuca.getIdCategoria() + "')";


		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	

	public void updateUsuario_Categoria(Usuario_Categoria usuca) throws SQLException, Exception {
		String sql = "UPDATE ISIS2304A261720.USUARIO_CATEGORIA SET ";
		sql += "ID_CATEGORIA='" + usuca.getIdCategoria() + "'";

		sql += " WHERE ID_USUARIO = " + usuca.getIdUsuario();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}


	public void deleteUsuario_Categoria(Usuario_Categoria usuca) throws SQLException, Exception {
		String sql = "DELETE FROM ISIS2304A261720.USUARIO_CATEGORIA";
		sql += " WHERE ID_USUARIO = " + usuca.getIdUsuario() ;
		sql += " AND ID_CATEGORIA = " + "'" + usuca.getIdCategoria() + "'";
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public ArrayList<Usuario_Categoria> buscarUsuarioCategoriaPorCedula(int nCedula) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
