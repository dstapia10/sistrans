package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vos.BoletaFestival;
import vos.ListaBoletasFestival;

public class DAOAbono {
	/**
	 * Arraylits de recursos que se usan para la ejecución de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexión a la base de datos
	 */
	private Connection conn;

	/**
	 * M�todo constructor que crea DAOVideo <b>post: </b> Crea la instancia
	 * del DAO e inicializa el Arraylist de recursos
	 */
	public DAOAbono() {
		recursos = new ArrayList<Object>();
	}

	/**
	 * M�todo que cierra todos los recursos que estan enel arreglo de recursos
	 * <b>post: </b> Todos los recurso del arreglo de recursos han sido cerrados
	 */
	public void cerrarRecursos() {
		for (Object ob : recursos) {
			if (ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}

	/**
	 * 4271130 Método que inicializa la connection del DAO a la base de datos
	 * con la conexión que entra como parámetro.
	 * 
	 * @param con
	 *            - connection a la base de datos
	 */
	public void setConn(Connection con) {
		this.conn = con;
	}
	
	
	public ArrayList<BoletaFestival> hacerAbono(int idCliente, ListaBoletasFestival lista) throws SQLException, Exception
	{
		
		ArrayList<BoletaFestival> videos = new ArrayList<BoletaFestival>();

		for (int i = 0; i < lista.getBoletasFestivales().size(); i++) {
			BoletaFestival l= lista.getBoletasFestivales().get(i);
			
			if (l.getApp() == 2) {
				
				
				String sql = "UPDATE BOLETA_FESTIVANDES SET ID_USUARIO =  "+ idCliente +" , ABONO= " + l.getAbono() +"WHERE IDBOLETA= " + l.getIdBoleta() + " AND DISPONIBILIDAD=0 AND IDLOCALIDAD = "+ l.getIdLocalidad()+" AND IDFUNCION = "+ l.getIdFuncion();
				
				PreparedStatement prepStmt = conn.prepareStatement(sql);
				recursos.add(prepStmt);
				prepStmt.executeQuery();
			}
		}
		

				
		String sql = "SELECT * FROM BOLETA_FESTIVANDES WHERE ABONO = " + lista.getBoletasFestivales().get(0).getAbono();

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {			
			int idBoleta = Integer.parseInt(rs.getString("idBoleta"));
			int abono = Integer.parseInt(rs.getString("abono"));
			int idLocalidad = Integer.parseInt(rs.getString("idLocalidad"));
			int idFuncion = Integer.parseInt(rs.getString("idFuncion"));
			videos.add(new BoletaFestival(2, idBoleta, abono, idLocalidad, idFuncion));
		}
		return videos;
	}
}
