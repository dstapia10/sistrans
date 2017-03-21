package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

import vos.Usuario;

public class DAOTablaUsuario {
	
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
	public DAOTablaUsuario() {
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
		
	public ArrayList<Usuario> darUsuarios() throws SQLException, Exception {
		ArrayList<Usuario> usuario = new ArrayList<Usuario>();

		String sql = "SELECT * FROM USUARIO";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int cedula = Integer.parseInt(rs.getString("CEDULA"));
			String nombre = rs.getString("NOMBRE");
			String apellido = rs.getString("APELLIDO");
			int edad = Integer.parseInt(rs.getString("EDAD"));
			String rol = rs.getString("ROL");
			usuario.add(new Usuario(cedula, nombre, apellido, edad, rol));
		}
		return usuario;
	}

	public void addUsuario(Usuario usuario) throws SQLException, Exception {
		String sql = "INSERT INTO USUARIO VALUES ('";
		sql += usuario.getCedula() + "','";
		sql += usuario.getNombre() + "','";
		sql += usuario.getApellido() + "','";
		sql += usuario.getEdad() + "','";
		sql += usuario.getRol()+ "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
		
	public void updateUsuario(Usuario usuario) throws SQLException, Exception {
		String sql = "UPDATE USUARIO SET ";
		sql += "NOMBRE='" + usuario.getNombre() + "',";
		sql += "APELLIDO='" + usuario.getApellido() + "',";
		sql += "EDAD='" + usuario.getEdad() + "',";
		sql += "ROL='" + usuario.getRol()+ "'";
		sql += " WHERE CEDULA = " + usuario.getCedula();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
		
	public void deleteUsuario(Usuario usuario) throws SQLException, Exception {
		String sql = "DELETE FROM USUARIO";
		sql += " WHERE CEDULA = " + usuario.getCedula();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
}
