/**-------------------------------------------------------------------
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 *
 * Materia: Sistemas Transaccionales
 * Ejercicio: VideoAndes
 * -------------------------------------------------------------------
 */
package dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

import vos.*;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los requerimientos de la aplicación
 * @author Juan
 */
public class DAOTablaFestival {


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
	public DAOTablaFestival() {
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


	public ArrayList<Festival> darFestivales() throws SQLException, Exception {
		ArrayList<Festival> festivales = new ArrayList<Festival>();

		String sql = "SELECT * ISIS2304A261720.FESTIVAL";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			int idCiudad = Integer.parseInt(rs.getString("ID_CIUDAD"));
			Date fechaInicio = rs.getDate("FECHAINICIO");
			Date fechaFinal = rs.getDate("FECHAINICIO");
			festivales.add(new Festival(id, idCiudad, fechaInicio, fechaFinal));
		}
		return festivales;
	}


	
	public ArrayList<Festival> buscarFestivalPorName(String name) throws SQLException, Exception {
		ArrayList<Festival> festivales = new ArrayList<Festival>();

		String sql = "SELECT * ISIS2304A261720.FESTIVAL ='" + name + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			int idCiudad = Integer.parseInt(rs.getString("ID_CIUDAD"));
			Date fechaInicio = rs.getDate("FECHAINICIO");
			Date fechaFinal = rs.getDate("FECHAINICIO");
			festivales.add(new Festival(id, idCiudad, fechaInicio, fechaFinal));
		}

		return festivales;
	}

	
	public void addFestival(Festival festival) throws SQLException, Exception {

		String sql = "INSERT INTO ISIS2304A261720.FESTIVAL VALUES (";
		sql += festival.getId() + ",'";
		sql += festival.getIdCiudad() + "',";
		sql += festival.getFechaInicio() + "',";
		sql += festival.getFechaFinal() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}


	public void updateFestival(Festival festival) throws SQLException, Exception {

		String sql = "UPDATE ISIS2304A261720.FESTIVAL SET ";
		sql += "ID_CIUDAD='" + festival.getIdCiudad() + "',";
		sql += "FECHAINICIO='" + festival.getFechaInicio() + "',";
		sql += "FECHAFINAL=" + festival.getFechaFinal();
		sql += " WHERE id = " + festival.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	
	public void deleteFestival(Festival festival) throws SQLException, Exception 
	{

		String sql = "DELETE FROM ISIS2304A261720.FESTIVAL";
		sql += " WHERE id = " + festival.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	
	public ArrayList<ConsultarAsistenciaCliente> darConsultarAsistenciaCliente(int idCliente) throws SQLException, Exception {
		ArrayList<ConsultarAsistenciaCliente> cac = new ArrayList<ConsultarAsistenciaCliente>();

		String sql = "SELECT bl.ID_USUARIO, bl.LETRAFILA, bl.NUMEROSILLA, ob.ID as IDObra, fu.ID as IDFuncion, fu.FECHAINICIO "
				+ " FROM ISIS2304A261720.FUNCION fu, ISIS2304A261720.OBRA ob, ISIS2304A261720.BOLETA bl"
				+ " WHERE fu.IDOBRA=ob.ID and fu.ID=bl.IDFUNCION and bl.ID_USUARIO=";
		sql+=idCliente;

		System.out.println(sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {			
			int id_usuario=Integer.parseInt(rs.getString("ID_USUARIO"));			
			String letrafila=rs.getString("LETRAFILA");						
			int numeroSilla=Integer.parseInt(rs.getString("NUMEROSILLA"));
			int idobra=Integer.parseInt(rs.getString("IDObra"));
			int idfuncion=Integer.parseInt(rs.getString("IDFuncion"));			
			Date fechainicio=rs.getDate("FECHAINICIO");

			cac.add(new ConsultarAsistenciaCliente(id_usuario, letrafila, 
					numeroSilla, idobra, idfuncion, fechainicio));
		}
		return cac;
	}
	
	public ArrayList<Usuario> darConsultarAsistencia9(String id, String ini, String fin, String orden, String agrupar) throws SQLException, Exception {
		ArrayList<Usuario> ca9 = new ArrayList<Usuario>();

		String sql = "SELECT us.CEDULA, us.APELLIDO, us.NOMBRE, us.EDAD, us.ROL "
				+ "FROM ISIS2304A261720.USUARIO us,ISIS2304A261720.BOLETA bl,ISIS2304A261720.FUNCION fn, ISIS2304A261720.OBRA ob, ISIS2304A261720.PRODUCCION pr "
				+ "WHERE us.CEDULA=bl.ID_USUARIO and bl.IDFUNCION=fn.ID and fn.IDOBRA=ob.ID and ob.ID=pr.ID_OBRA and pr.ID_COMPA�IA=";
		sql += id;
		sql += " and fn.FECHAINICIO BETWEEN '";
		sql += ini;
		sql += "' and '";
		sql += fin;
		
		 if (agrupar != null)
			{
				
					sql += "' GROUP BY us.CEDULA, us.APELLIDO, us.NOMBRE, us.EDAD, us.ROL";
				
			}
		
		if (orden != null) 
		{
			if (orden.equals("cedula"))
			{
				sql += " ORDER BY us.CEDULA";
			}
			if (orden.equals("apellido"))
			{
				sql += " ORDER BY us.APELLIDO";
			}
			if (orden.equals("nombre"))
			{
				sql += " ORDER BY us.NOMBRE";
			}
			if (orden.equals("edad"))
			{
				sql += " ORDER BY  us.EDAD";
			}
			if (orden.equals("rol"))
			{
				sql += " ORDER BY  us.ROL";
			}
			
			
		}
		

		System.out.println(sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int cedula = Integer.parseInt(rs.getString("CEDULA"));
			String nombre = rs.getString("NOMBRE");
			String apellido = rs.getString("APELLIDO");
			int edad = Integer.parseInt(rs.getString("EDAD"));
			String rol = rs.getString("ROL");
			ca9.add(new Usuario(cedula, nombre, apellido, edad, rol));
		}
		return ca9;
	}
	
	public ArrayList<Usuario> darConsultarAsistencia10(String id, String ini, String fin, String orden, String agrupar) throws SQLException, Exception {
		ArrayList<Usuario> ca10 = new ArrayList<Usuario>();

		String sql = "SELECT a.CEDULA, a.APELLIDO, a.NOMBRE, a.EDAD, a.ROL "
				+ "FROM (SELECT * FROM ISIS2304A261720.USUARIO us)a "
				+ "LEFT OUTER JOIN "
				+ "(SELECT us.CEDULA, us.APELLIDO, us.NOMBRE, us.EDAD, us.ROL "
				+ "FROM ISIS2304A261720.USUARIO us,ISIS2304A261720.BOLETA bl,ISIS2304A261720.FUNCION fn, ISIS2304A261720.OBRA ob, ISIS2304A261720.PRODUCCION pr "
				+ "WHERE us.CEDULA=bl.ID_USUARIO and bl.IDFUNCION=fn.ID and fn.IDOBRA=ob.ID and ob.ID=pr.ID_OBRA and pr.ID_COMPA�IA=";
		sql += id;
		sql += " and fn.FECHAINICIO BETWEEN '";
		sql += ini;
		sql += "' and '";
		sql += fin;
		
		sql+= "' )b on a.CEDULA = b.CEDULA WHERE b.CEDULA is NULL";
		if (agrupar != null)
		{
			
				sql += " GROUP BY a.CEDULA, a.APELLIDO, a.NOMBRE, a.EDAD, a.ROL";
			
		}
	
	if (orden != null) 
	{
		if (orden.equals("cedula"))
		{
			sql += " ORDER BY a.CEDULA";
		}
		if (orden.equals("apellido"))
		{
			sql += " ORDER BY a.APELLIDO";
		}
		if (orden.equals("nombre"))
		{
			sql += " ORDER BY a.NOMBRE";
		}
		if (orden.equals("edad"))
		{
			sql += " ORDER BY  a.EDAD";
		}
		if (orden.equals("rol"))
		{
			sql += " ORDER BY  a.ROL";
		}
		
		
	
		System.out.println(sql);
	}

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int cedula = Integer.parseInt(rs.getString("CEDULA"));
			String nombre = rs.getString("NOMBRE");
			String apellido = rs.getString("APELLIDO");
			int edad = Integer.parseInt(rs.getString("EDAD"));
			String rol = rs.getString("ROL");
			
			ca10.add(new Usuario(cedula, nombre, apellido, edad, rol));
		}
	
		return ca10;
	}
	
	
	public ArrayList<ConsultaBoletasFuncion> darConsultaBoletasFuncion(String letraFila, String ini, String fin) throws SQLException, Exception {
		
		
		ArrayList<ConsultaBoletasFuncion> consultaBoletasFuncion = consultaBoletasFuncion1(ini, fin);
				
		consultaBoletasFuncion = consultaBoletasFuncion2(consultaBoletasFuncion, letraFila, ini, fin);
		
		consultaBoletasFuncion = consultaBoletasFuncion3(consultaBoletasFuncion, letraFila, ini, fin);
		
		consultaBoletasFuncion = consultaBoletasFuncion4(consultaBoletasFuncion);
				
		return consultaBoletasFuncion;
	}
	
	
	private ArrayList<ConsultaBoletasFuncion> consultaBoletasFuncion1(String ini, String fin) throws SQLException, Exception {
		
		
		ArrayList<ConsultaBoletasFuncion> consultaBoletasFuncion = new ArrayList<ConsultaBoletasFuncion>();
		
		String sql = "SELECT fn.ID as IDFUNCION, ob.NOMBRE as NOMBREOBRA, fn.FECHAINICIO, tr.NOMBRE as NOMBRETEATRO, fn.ESTADO "
				+ "FROM ISIS2304A261720.FUNCION fn, ISIS2304A261720.OBRA ob, ISIS2304A261720.TEATRO tr "
				+ "WHERE fn.IDOBRA=ob.ID and fn.IDTEATRO=tr.ID and fn.FECHAINICIO>='";
		sql += ini;
		sql += "' and fn.FECHAINICIO<'";
		sql += fin;
		sql += "'GROUP BY fn.ID, ob.NOMBRE, fn.FECHAINICIO, tr.NOMBRE, fn.ESTADO";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		System.out.println(sql);
		
		while (rs.next()) {
			
			
			int idFuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			String nombreobra = rs.getString("NOMBREOBRA");
			Date fechainicio=rs.getDate("FECHAINICIO");
			String nombreteatro = rs.getString("NOMBRETEATRO");
			String estado = rs.getString("ESTADO");
			
			consultaBoletasFuncion.add(new ConsultaBoletasFuncion(idFuncion, nombreobra, fechainicio, nombreteatro, estado, 0, 0, 0));
		}
		return consultaBoletasFuncion;
	}
	
	
	private ArrayList<ConsultaBoletasFuncion> consultaBoletasFuncion2(ArrayList<ConsultaBoletasFuncion> listaConsulta, String letraFila, String ini, String fin) throws SQLException, Exception {
		
		
		
		String sql = "SELECT fn.ID as IDFUNCION, COUNT(*) as BOLETASDISPONIBLESLOCALIDAD "
				+ "FROM ISIS2304A261720.BOLETA bl, ISIS2304A261720.FUNCION fn, ISIS2304A261720.OBRA ob, ISIS2304A261720.TEATRO tr "
				+ "WHERE bl.IDFUNCION=fn.ID and fn.IDOBRA=ob.ID and fn.IDTEATRO=tr.ID and fn.FECHAINICIO>='";
		sql += ini;
		sql += "' and fn.FECHAINICIO<'";
		sql += fin;
		sql += "' and bl.LETRAFILA='";
		sql += letraFila;
		sql += "' GROUP BY fn.ID";
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int idFuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			int boletasdisponibleslocalidad = Integer.parseInt(rs.getString("BOLETASDISPONIBLESLOCALIDAD"));
			
			boolean encontro = false;
			for(int i=0; i<listaConsulta.size() && !encontro; i++)
			{
				if(listaConsulta.get(i).getIDFUNCION()==idFuncion){
					listaConsulta.get(i).setBOLETASDISPONIBLESLOCALIDAD(boletasdisponibleslocalidad);
					encontro=true;
				}
			}
		}
		return listaConsulta;
	}
	
	
	private ArrayList<ConsultaBoletasFuncion> consultaBoletasFuncion3(ArrayList<ConsultaBoletasFuncion> listaConsulta, String letraFila, String ini, String fin) throws SQLException, Exception {
		
	
		String sql = "SELECT fn.ID as IDFUNCION, COUNT(*) as BOLETASVENDIDASLOCALIDAD "
				+ "FROM ISIS2304A261720.BOLETA bl, ISIS2304A261720.FUNCION fn, ISIS2304A261720.OBRA ob, ISIS2304A261720.TEATRO tr "
				+ "WHERE bl.IDFUNCION=fn.ID and fn.IDOBRA=ob.ID and fn.IDTEATRO=tr.ID and bl.ID_USUARIO IS NOT NULL and "
				+ " fn.FECHAINICIO>='";
		sql += ini;
		sql += "' and fn.FECHAINICIO<'";
		sql += fin;
		sql += "' and bl.LETRAFILA='";
		sql += letraFila;
		sql += "' GROUP BY fn.ID";
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int idFuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			int boletasvendidaslocalidad = Integer.parseInt(rs.getString("BOLETASVENDIDASLOCALIDAD"));
			
			boolean encontro = false;
			for(int i=0; i<listaConsulta.size() && !encontro; i++)
			{
				if(listaConsulta.get(i).getIDFUNCION()==idFuncion){
					listaConsulta.get(i).setBOLETASVENDIDASLOCALIDAD(boletasvendidaslocalidad);
					encontro=true;
				}
			}
		}
		return listaConsulta;
	}
	
	
	private ArrayList<ConsultaBoletasFuncion> consultaBoletasFuncion4(ArrayList<ConsultaBoletasFuncion> listaConsulta) throws SQLException, Exception {
		
		
		for(int i=0; i<listaConsulta.size(); i++)
		{
			if(listaConsulta.get(i).getBOLETASDISPONIBLESLOCALIDAD()!=0){
				int boletasnovendidaslocalidad = listaConsulta.get(i).getBOLETASDISPONIBLESLOCALIDAD()-listaConsulta.get(i).getBOLETASVENDIDASLOCALIDAD();
				listaConsulta.get(i).setBOLETASNOVENDIDASLOCALIDAD(boletasnovendidaslocalidad);
			}
		}
		
		return listaConsulta;		
	}
	
	
	
	public ArrayList<Usuario> darConsultarBuenosClientes(int nBoletas) throws SQLException, Exception {
		ArrayList<Usuario> cbc = new ArrayList<Usuario>();

		String sql = "SELECT a.CEDULA, a.APELLIDO, a.NOMBRE, a.EDAD, a.ROL "
				+ "FROM (SELECT us.CEDULA, us.APELLIDO, us.NOMBRE, us.EDAD, us.ROL, COUNT(*) as BOLETASCOMPRADASTOTAL "
				+ "FROM ISIS2304A261720.USUARIO us,ISIS2304A261720.BOLETA bl,ISIS2304A261720.FUNCION fn, ISIS2304A261720.OBRA ob "
				+ "WHERE us.CEDULA=bl.ID_USUARIO and bl.IDFUNCION=fn.ID and fn.IDOBRA=ob.ID "
				+ "GROUP BY us.CEDULA, us.APELLIDO, us.NOMBRE, us.EDAD, us.ROL)a "
				+ "INNER JOIN "
				+ "(SELECT us.CEDULA, us.APELLIDO, us.NOMBRE, us.EDAD, us.ROL, COUNT(*) as BOLETASCOMPRADASLOCALIDAD "
				+ "FROM ISIS2304A261720.USUARIO us,ISIS2304A261720.BOLETA bl,ISIS2304A261720.FUNCION fn, ISIS2304A261720.OBRA ob "
				+ "WHERE us.CEDULA=bl.ID_USUARIO and bl.IDFUNCION=fn.ID and fn.IDOBRA=ob.ID and "
				+ "(bl.LETRAFILA='a' or bl.LETRAFILA='b' or bl.LETRAFILA='c' or bl.LETRAFILA='d' or bl.LETRAFILA='e') "
				+ "GROUP BY us.CEDULA, us.APELLIDO, us.NOMBRE, us.EDAD, us.ROL)b "
				+ "ON a.CEDULA=b.CEDULA "
				+ "WHERE (a.BOLETASCOMPRADASTOTAL-b.BOLETASCOMPRADASLOCALIDAD)=0 and b.BOLETASCOMPRADASLOCALIDAD>=";
		sql += nBoletas;
				
		
		System.out.println(sql);
		System.out.println("aqui");

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int cedula = Integer.parseInt(rs.getString("CEDULA"));
			String nombre = rs.getString("NOMBRE");
			String apellido = rs.getString("APELLIDO");
			int edad = Integer.parseInt(rs.getString("EDAD"));
			String rol = rs.getString("ROL");
			
			cbc.add(new Usuario(cedula, nombre, apellido, edad, rol));
		}
		System.out.println("aqui 3");
		return cbc;
	}
	
}
