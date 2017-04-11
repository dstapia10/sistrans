package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import vos.Actor;
import vos.Boleta;
import vos.Categoria;
import vos.Funcion;
import vos.ParametrosGetFunciones;
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
	
	
	public ArrayList<ParametrosGetFunciones> darFuncion() throws SQLException, Exception {
	System.out.println("entra a darFuncion");
		ArrayList<ParametrosGetFunciones> funciones = new ArrayList<ParametrosGetFunciones>();
		String sql = " SELECT f.ID as ID, f.FECHAINICIO as FECHA, t.NOMBRE as TEATRO, b.NOMBRE as OBRA"
				+ " FROM ISIS2304A261720.FUNCION f, FROM ISIS2304A261720.OBRA b, FROM ISIS2304A261720.TEATRO t ";
		String sqlParaWhere = "WHERE f.IDOBRA = b.ID AND AND f.IDTEATRO = t.ID";
		
		sql+= sqlParaWhere;
		
		
		System.out.println("SQL stmt:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			Date fechaInicio = rs.getDate("FECHA");
			String idTeatro = rs.getString("TEATRO");
			String idObra = rs.getString("OBRA");
			funciones.add(new ParametrosGetFunciones(id, fechaInicio, idTeatro, idObra));
		}
		
		return funciones;
	}
	
	
	public void addFuncion(Funcion funcion) throws SQLException, Exception {

		String sql = "INSERT INTO ISIS2304A261720.FUNCION VALUES ('";
		sql += funcion.getId()+ "',to_date('";
		sql += funcion.getFechaInicio() + "',";
		sql += "'yyyy-MM-dd  hh:mi:ss'),'";
		sql += funcion.getIdTeatro() + "','";
		sql += funcion.getIdObra()+ "','";
		sql += funcion.getTraduccion() + "')";
		

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	
	public void updateFuncion(Funcion funcion) throws SQLException, Exception {

		String sql = "UPDATE ISIS2304A261720.FUNCION SET ";
		sql += "FECHAINICIO= to_date('" + funcion.getFechaInicio() + "','yyyy-MM-dd hh:mi:ss'),";
		sql += "IDTEATRO='" +funcion.getIdTeatro()+ "',";
		sql += "IDOBRA='" + funcion.getIdObra();
		sql += "' WHERE ID = " + funcion.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public Funcion obtenerFuncion(int idFuncion) throws SQLException
	{
		Funcion funcion = null;
		String sql = "SELECT * FROM FUNCION WHERE ID=" + idFuncion; 
		
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next())
		{
			
		System.out.println("llega aqui");
			int id = Integer.parseInt(rs.getString("ID"));
			Date fechaInicio = rs.getDate("FECHAINICIO");
			int idTeatro = Integer.parseInt(rs.getString("IDTEATRO"));
			int idObra = Integer.parseInt(rs.getString("IDOBRA"));
			String estado = rs.getString("ESTADO");
			
			
			
			
			funcion = new Funcion(id, fechaInicio, idTeatro, idObra, estado);
		}
		System.out.println("llega aqui 2");
		return funcion;
	}
	
	public void cancelarFuncion(Funcion funcion) throws SQLException, Exception {

		
		Funcion fun = obtenerFuncion(funcion.getId());
		System.out.println("entra a cancelar funcion");

		
		if (sePuedeCancelar(fun)) {
			
			System.out.println("entra a el if en se puede cancelar");
			String sql = "UPDATE ISIS2304A261720.FUNCION SET ";
			sql += "ESTADO='cancelado' " ;
			sql += " WHERE ID = " + fun.getId();
			
			System.out.println("SQL stmt:" + sql);
			
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			prepStmt.executeQuery();
			ArrayList<Boleta> bol = darBoletasFuncion(fun);
			
			for (int i = 0; i < bol.size(); i++) {
				
				devolverBoleta2(bol.get(i));
				System.out.println("aqui x1-");
			}
		}
	}
	
	public void devolverBoleta2(Boleta boleta) throws SQLException, Exception {
		
		String sql = "UPDATE ISIS2304A261720.BOLETA SET ID_USUARIO = NULL";
		sql += " WHERE ID = " + boleta.getId();
		
		System.out.println("SQL stmt:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		
		recursos.add(prepStmt);
		prepStmt.executeQuery();
		System.out.println("La Funcion ha sido cancelada, puede proceder a la entidad bancaria FestivAndes para la devolucion de su dinero.");
	
	
}
	
	public ArrayList<Boleta> darBoletasFuncion( Funcion funcion) throws SQLException
	{

		ArrayList<Boleta> boletas = new ArrayList<>();
		String sql = "SELECT * FROM ISIS2304A261720.BOLETA ";
		sql += " WHERE IDFUNCION = " + funcion.getId();
		
		System.out.println("SQL stmt:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		System.out.println("aqui en boletas");
		while (rs.next()) {
			System.out.println("entra al while");
			int id = Integer.parseInt(rs.getString("ID"));
			System.out.println(id);
			String letrafila = rs.getString ("LETRAFILA");
			System.out.println(letrafila);
			int numerosilla = Integer.parseInt(rs.getString("NUMEROSILLA"));
			System.out.println(numerosilla);
			int idfuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			System.out.println(idfuncion);
			int precio = Integer.parseInt(rs.getString("PRECIO"));
			System.out.println(precio);
			int idUsuario = Integer.parseInt(rs.getString("ID_USUARIO"));
			System.out.println(idUsuario);
			System.out.println("aqui dentro del while");
			boletas.add(new Boleta(id, letrafila, numerosilla, precio, idfuncion, idUsuario));
		}
		System.out.println("retorna las boletas");
		return boletas;
	}
	public boolean sePuedeCancelar(Funcion funcion)
	{
		System.out.println("entra a se puede cancelar");

		java.util.Date utilDate = new java.sql.Date(funcion.getFechaInicio().getTime());
		System.out.println("aqui");
		java.util.Date date = new java.util.Date();
		System.out.println(" aqui 2");
		if (date.compareTo(utilDate) < 0) {
			System.out.println("verdadero");
			 return true;
		}
		else
			System.out.println(" falso");
		return false;
		
		
	}


	public void deleteFuncion(Funcion funcion) throws SQLException, Exception {

		String sql = "DELETE FROM ISIS2304A261720.FUNCION";
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
