package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import vos.Actor;
import vos.Categoria;
import vos.Funcion;
import vos.ReporteFuncion;

public class DAOTablaFuncion {
	
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
	public DAOTablaFuncion() {
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
	
	
	public ArrayList<Funcion> darFuncion(java.util.Date  f, java.util.Date f2, Categoria categoria, String idioma, Boolean ordenado) throws SQLException, Exception {
	
		ArrayList<Funcion> funciones = new ArrayList<Funcion>();
		String sql = " SELECT * FROM ISIS2304A261720.FUNCIONES f, OBRA b ";
		String sqlParaWhere = "WHERE f.ID_OBRA = b.ID";
		if (categoria !=null)
		{
			sql+= ", CATEGORIA c, OBRA_CATEGORIA oc ";
			sqlParaWhere+= " AND c.NOMBRE = oc.ID_CATEGORIA AND b.ID = oc.ID_OBRA";
			
	
		}
		
		if (f != null && f2 != null)
		{
			sqlParaWhere+= " AND F.FECHAINICIO BETWEEN '" + f + "' AND '" + f2 + "' "; 
		}
		
		if (idioma != null)
		{
			sqlParaWhere+= " AND b.IDIOMA ='" + idioma + "' ";
		}
		
		if (ordenado)
		{
			sqlParaWhere+= " ORDER BY ASC";
		}
		sql+= sqlParaWhere;
		
		System.out.println("SQL stmt:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			Date fechaInicio = rs.getDate("FECHAINICIO");
			int idTeatro = Integer.parseInt(rs.getString("IDTEATRO"));
			int idObra = Integer.parseInt(rs.getString("IDOBRA"));
			funciones.add(new Funcion(id, fechaInicio, idTeatro, idObra));
		}
		
		return funciones;
	}
		
	
	
	
	
	
	
	
	
	
	public void addFuncion(Funcion funcion) throws SQLException, Exception {

//		String sql = "INSERT INTO ISIS2304A261720.FUNCIONES VALUES ('";
//		sql += funcion.getId()+ "',to_date('";
//		sql += funcion.getFechaInicio() + "',";
//		sql += "'yyyy-MM-dd  hh:mi:ss'),'";
//		sql += funcion.getIdTeatro() + "','";
//		sql += funcion.getIdObra()+ "','";
//		sql += funcion.getTraduccion() + "')";
		
		String sql = "SELECT * FROM  ISIS2304A261720.FUNCIONES";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	
	public void updateFuncion(Funcion funcion) throws SQLException, Exception {

		String sql = "UPDATE ISIS2304A261720.FUNCIONES SET ";
		sql += "FECHAINICIO= to_date('" + funcion.getFechaInicio() + "','yyyy-MM-dd hh:mi:ss'),";
		sql += "IDTEATRO='" +funcion.getIdTeatro()+ "',";
		sql += "IDOBRA='" + funcion.getIdObra();
		sql += "' WHERE ID = " + funcion.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}


	public void deleteFuncion(Funcion funcion) throws SQLException, Exception {

		String sql = "DELETE FROM ISIS2304A261720.FUNCIONES";
		sql += " WHERE ID = " + funcion.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public ReporteFuncion darReporteFuncionPorId(int id) throws SQLException, Exception {
//		String sql = "DELETE FROM FUNCION";
//		sql += " WHERE ID = " + funcion.getId();
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
		return null;
	}
}
