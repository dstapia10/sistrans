package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Actor;
import vos.Funcion;
import vos.Teatro;
import vos.TeatroGet;

public class DAOTablaTeatro {
	
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
	public DAOTablaTeatro() {
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


	public ArrayList<TeatroGet> darTeatro() throws SQLException, Exception {
		ArrayList<TeatroGet> teatros = new ArrayList<TeatroGet>();
		String sql = "SELECT t.ID as IDTEATRO, ci.NOMBRE as CIUDAD, t.CAPACIDAD as CAPACIDAD, t.NOMBRE as TEATRO, "
				+ "t.DIRECCION as DIRECCION, f.FECHAINICIO AS FECHA,"
				+ " o.NOMBRE as OBRA, f.TRADUCCION AS TRADUCCION, b.LETRAFILA AS LETRAFILA, b.NUMEROSILLA AS NUMEROSILLA,b.PRECIO AS PRECIO"
				+ " FROM ISIS2304A261720.TEATRO t, ISIS2304A261720.FUNCION f, ISIS2304A261720.BOLETA  b, ISIS2304A261720.CIUDAD ci ,"
				+ " ISIS2304A261720.OBRA o WHERE f.IDTEATRO = t.ID AND b.IDFUNCION = f.ID AND ci.ID = t.IDCIUDAD AND f.IDOBRA = o.ID";
				
		
		
		
		System.out.println("SQL stmt:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int idTeatro = Integer.parseInt(rs.getString("IDTEATRO"));
			String ciudad =  rs.getString("CIUDAD");
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD"));
			String teatro =  rs.getString("TEATRO");
			String direccion =  rs.getString("DIRECCION");
			
			String obra =  rs.getString("OBRA");
			String traduccion =  rs.getString("TRADUCCION");
			String letrafila =  rs.getString("LETRAFILA");
			int numeroSilla = Integer.parseInt(rs.getString("NUMEROSILLA"));
			int precio = Integer.parseInt(rs.getString("PRECIO"));
			
			teatros.add(new TeatroGet(idTeatro, ciudad, capacidad, teatro, direccion, obra , traduccion, letrafila, numeroSilla, precio));
		}
		
		return teatros;
	
		
		
	}



	public ArrayList<TeatroGet> buscarTeatroPorName(String name) throws SQLException, Exception {
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
//			int compa�ia = Integer.parseInt(rs.getString("ID_COMPA�IA"));
//			String nacionalidad = rs.getString("NACIONALIDAD");
//			actores.add(new Actor(cedula, compa�ia, nombre, nacionalidad));
//		}
//
//		return actores;
		
		return null;
	}


	public void addTeatro(Teatro teatro) throws SQLException, Exception {

		String sql = "INSERT INTO ISIS2304A261720.TEATRO VALUES ('";
		sql += teatro.getId() + "','";
		sql += teatro.getIdCiudad() + "','";
		sql += teatro.getCapacidad() + "','";
		sql += teatro.getNombre() + "','";
		sql += teatro.getDireccion() + "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	

	public void updateTeatro(Teatro teatro) throws SQLException, Exception {

		String sql = "UPDATE ISIS2304A261720.TEATRO SET ";
		sql += "IDCIUDAD='" +  teatro.getIdCiudad() + "',";
		sql += "CAPACIDAD='" + teatro.getCapacidad() + "',";
		sql += "NOMBRE='" + teatro.getNombre()+ "',";
		sql += "DIRECCION='" + teatro.getDireccion();
		sql += "' WHERE ID = " + teatro.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}


	public void deleteTeatro(Teatro teatro) throws SQLException, Exception {

		String sql = "DELETE FROM ISIS2304A261720.TEATRO";
		sql += " WHERE id = " + teatro.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
}
