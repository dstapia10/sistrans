package dao;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.codehaus.jackson.annotate.JsonProperty;

import vos.Compañia;
import vos.Usuario;

public class DAOTablaUsuario {
	
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
	public DAOTablaUsuario() {
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
		
	public ArrayList<Usuario> darUsuarios() throws SQLException, Exception {
		ArrayList<Usuario> usuario = new ArrayList<Usuario>();

		String sql = "SELECT * FROM ISIS2304A261720.USUARIO";

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
		String sql = "INSERT INTO  ISIS2304A261720.USUARIO VALUES ('";
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
		String sql = "UPDATE  ISIS2304A261720.USUARIO SET ";
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
	
	public ArrayList<Usuario> asistenciaDeUsuarios( Date  fechaInicio, Date fechaFinal, String nombreCompania) throws Exception
	{
		
		DAOTablaCompañia daoComp = new DAOTablaCompañia();
		
		//Compañia comp = daoComp.buscarCompañiaPorName(nombreCompania);
		
		
		
		ArrayList<Usuario> usuario = new ArrayList<Usuario>();

		String sql = "SELECT * FROM ISIS2304A261720.USUARIO";

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
	
	public void llenarTabla() throws SQLException, Exception
	{
		Random rand = new Random();

		int cedula = rand.nextInt(99999999) + 10000000 ;
		
		
		int edad = 16;
		
		for (int i = 0; i < 15000; i++) {
			
			

			String nombre = getSaltString();
			String apellido = "Barbakahn";
			
			Usuario user = new Usuario(cedula, nombre, apellido, edad, 	"cliente");
			addUsuario(user);
			cedula++;
			
		 
			nombre = nombre + i;
			
			edad++;
			
		}
		
	}
	
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

		
	public void deleteUsuario(Usuario usuario) throws SQLException, Exception {
		String sql = "ISIS2304A261720.DELETE FROM USUARIO";
		sql += " WHERE CEDULA = " + usuario.getCedula();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
}
