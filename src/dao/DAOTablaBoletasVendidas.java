package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.BoletasVendidas;

public class DAOTablaBoletasVendidas {
	
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
	public DAOTablaBoletasVendidas() {
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


	public ArrayList<BoletasVendidas> darBoletasVendidas() throws SQLException, Exception {
		ArrayList<BoletasVendidas> boletasVendidas = new ArrayList<BoletasVendidas>();

		String sql = "SELECT * FROM ISIS2304A261720.BOLETASVENDIDAS";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int idCliente = Integer.parseInt(rs.getString("IDCLIENTE"));
			int idBoleta = Integer.parseInt(rs.getString("IDBOLETA"));
			boletasVendidas.add(new BoletasVendidas(idCliente, idBoleta));
		}
		System.out.println("saliendo de metodo darBoletasVendidas");
		return boletasVendidas;
	}



	public ArrayList<BoletasVendidas> buscarBoletasVendidasPorIdCliente(int idCliente) throws SQLException, Exception {
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
	
	public ArrayList<BoletasVendidas> buscarBoletasVendidasPorIdBoleta(int idBoleta) throws SQLException, Exception {
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


	public void addBoletasVendidas(BoletasVendidas boletas) throws SQLException, Exception {


		if(buscarSiYaEstaVendida(boletas.getIdBoleta()) != true )
		{
		String sql = "INSERT INTO ISIS2304A261720.BOLETASVENDIDAS VALUES ('";
		sql += boletas.getIdCliente() + "','";
		
		sql += boletas.getIdBoleta()+ "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
		}
		
		else
		{
			throw new Exception("Boleta no disponible");
		}

	}
	

	private Boolean buscarSiYaEstaVendida(int id) throws Exception {

		ArrayList<BoletasVendidas> bo = darBoletasVendidas();
		Boolean rpta = false;
		for (int i = 0; i < bo.size() && !rpta; i++) 
		{
			if (bo.get(i).getIdBoleta() == id)
			{
				rpta = true;
			}
		}
		

		return rpta;
		
	}

	public void updateBoletasVendidas(BoletasVendidas boletasVendidas) throws SQLException, Exception {

//		String sql = "UPDATE BOLETASVENDIDAS SET ";
//		sql += "NOMBRE='" + bol.getNombre() ;
//		
//		sql += "' WHERE ID= " + ciudad.getId();
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
	}


	public void deleteBoletasVendidas(BoletasVendidas boletasVendidas) throws SQLException, Exception {

		String sql = "DELETE FROM ISIS2304A261720.BOLETASVENDIDAS";
		sql += " WHERE IDCLIENTE = " +boletasVendidas.getIdCliente();
		sql += " WHERE IDBOLETA = " + boletasVendidas.getIdBoleta();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
}
