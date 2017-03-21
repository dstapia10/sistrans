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
	
	
	public ArrayList<Funcion> darFuncion(Date  fecha1, Date fecha2, Categoria categoria, String idioma, Boolean ordenado) throws SQLException, Exception {
	
		ArrayList<Funcion> funciones = new ArrayList<Funcion>();
		String sql = " SELECT * FROM FUNCION f, OBRA b ";
		String sqlParaWhere = "WHERE f.ID_OBRA = b.ID";
		if (categoria !=null)
		{
			sql+= ", CATEGORIA c, OBRA_CATEGORIA oc ";
			sqlParaWhere+= " AND c.NOMBRE = oc.ID_CATEGORIA AND b.ID = oc.ID_OBRA";
			
	
		}
		
		if (fecha1 != null && fecha2 != null)
		{
			sqlParaWhere+= " AND F.FECHAINICIO BETWEEN '" + fecha1 + "' AND '" + fecha2 + "' "; 
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

		String sql = "INSERT INTO FUNCION VALUES ('";
		sql += funcion.getId()+ "','";
		sql += (funcion.getFechaInicio()).toLocaleString()+ "','";
		sql += funcion.getIdTeatro() + "','";
		sql += funcion.getIdObra()+ "','";
		sql += funcion.getTraduccion() + "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	
	public void updateFuncion(Funcion funcion) throws SQLException, Exception {

		String sql = "UPDATE FUNCION SET ";
		sql += "FECHA_INICIO='" + funcion.getFechaInicio() + "',";
		sql += "IDTEATRO='" +funcion.getIdTeatro()+ "',";
		sql += "IDOBRA='" + funcion.getIdObra();
		sql += "' WHERE ID = " + funcion.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}


	public void deleteFuncion(Funcion funcion) throws SQLException, Exception {

		String sql = "DELETE FROM FUNCION";
		sql += " WHERE ID = " + funcion.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
}
