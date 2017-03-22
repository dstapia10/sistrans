package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Categoria;

public class DAOTablaCategoria {
	
	/**
	 * Arraylits de recursos que se usan para la ejecuci√≥n de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexi√≥n a la base de datos
	 */
	private Connection conn;

	/**
	 * M√©todo constructor que crea DAOVideo
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOTablaCategoria() {
		recursos = new ArrayList<Object>();
	}

	/**
	 * M√©todo que cierra todos los recursos que estan enel arreglo de recursos
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
	 * M√©todo que inicializa la connection del DAO a la base de datos con la conexi√≥n que entra como par√°metro.
	 * @param con  - connection a la base de datos
	 */
	public void setConn(Connection con){
		this.conn = con;
	}


	public ArrayList<Categoria> darCategorias() throws SQLException, Exception {
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();

		String sql = "SELECT * FROM ISIS2304A261720.CATEGORIA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			
			String nombre = rs.getString("NOMBRE");
			
			categorias.add(new Categoria(nombre));
		}
		return categorias;
		
		
	}



	public ArrayList<Categoria> buscarCategoriaPorName(String name) throws SQLException, Exception {
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
//			int compaÒia = Integer.parseInt(rs.getString("ID_COMPA—IA"));
//			String nacionalidad = rs.getString("NACIONALIDAD");
//			actores.add(new Actor(cedula, compaÒia, nombre, nacionalidad));
//		}
//
//		return actores;
		
		return null;
	}


	public void addCategoria(Categoria categoria) throws SQLException, Exception {
		String sql = "INSERT INTO ISIS2304A261720.CATEGORIA VALUES ('";
		
		sql += categoria.getNombre()+ "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	

	public void updateCategoria(Categoria categoria) throws SQLException, Exception {
//		String sql = "UPDATE ACTOR SET ";
//		sql += "NOMBRE='" + actor.getCedula() + "',";
//		sql += "ID_COMPA—IA='" + actor.getIdCompania() + "',";
//		sql += "NACIONALIDAD=" + actor.getNacionalidad();
//		sql += " WHERE CEDULA = " + actor.getCedula();
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
	}


	public void deleteCategoria(Categoria categoria) throws SQLException, Exception {
		String sql = "DELETE FROM ISIS2304A261720.CATEGORIA";
		sql += " WHERE NOMBRE = " + "'"+categoria.getNombre()+"'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	
}
