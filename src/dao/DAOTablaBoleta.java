package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Boleta;
import vos.BoletaGet;
import vos.BoletasVendidas;
import vos.ListaBoletasVendidas;

public class DAOTablaBoleta {
	
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
	public DAOTablaBoleta() {
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


	public ArrayList<BoletaGet> darBoletas() throws SQLException, Exception {
		ArrayList<BoletaGet> boletas = new ArrayList<BoletaGet>();

		String sql = "SELECT f.ID as idFuncion, SUM(b.precio) as ganancia FROM ISIS2304A261720.FUNCION f, ISIS2304A261720.BOLETASVENDIDAS bv, ISIS2304A261720.BOLETA b"
+" Where f.ID=b.IDFUNCION AND b.ID=bv.IDBOLETA GROUP BY f.ID";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		
		while (rs.next()) {
			int idFuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			System.out.println(idFuncion);
			int ganancia =  Integer.parseInt(rs.getString("GANANCIA"));
			System.out.println(ganancia);
			boletas.add(new BoletaGet(idFuncion, ganancia));
			
		}
		return boletas;
		
		
	}

	
	public void addBoleta(Boleta boleta) throws SQLException, Exception {
		
		
		String sql = "INSERT INTO ISIS2304A261720.BOLETA VALUES ('";
		sql += boleta.getId() + "','";
		sql += boleta.getLetraFila() + "','";
		sql += boleta.getNumeroSilla() + "','";
	
		sql += boleta.getPrecio() + "','";
		sql += boleta.getIdFuncion() + "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	

	public void updateBoleta(Boleta boleta) throws SQLException, Exception {
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
	}
	
	
	public void venderBoleta(BoletasVendidas boleta) throws SQLException, Exception {
		String sql = "UPDATE BOLETA SET ";
		sql += "ID_USUARIO='" + boleta.getIdCliente() + "',";
		sql += " WHERE ID = " + boleta.getIdBoleta();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	
	public void venderVariasBoleta(ListaBoletasVendidas boleta) throws SQLException, Exception {
//		String sql = "UPDATE BOLETA SET ";
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
	}
	
	
	public void devolverBoleta(BoletasVendidas boleta) throws SQLException, Exception {
		String sql = "UPDATE ACTOR SET ID_USUARIO='null'";
		sql += " WHERE ID = " + boleta.getIdBoleta();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	
	
	public void deleteBoleta(Boleta boleta) throws SQLException, Exception {
		String sql = "DELETE FROM ISIS2304A261720.BOLETA";
		sql += " WHERE ID = " + boleta.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
}
