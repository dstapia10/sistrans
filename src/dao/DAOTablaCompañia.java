package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import vos.Boleta;
import vos.BoletaGet;
import vos.Compa�ia;
import vos.ConsultaCompa�ia;
import vos.Funcion;
import vos.Usuario;

public class DAOTablaCompa�ia {
	
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
	public DAOTablaCompa�ia() {
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


	public ArrayList<Funcion> darFunciones(int id) throws SQLException, Exception {
		

		ArrayList<Funcion> funciones = new ArrayList<Funcion>();
		String sql = "SELECT fn.ID as IDFUNCION  "
				+ "FROM ISIS2304A261720.FUNCION fn, ISIS2304A261720.OBRA ob, ISIS2304A261720.PRODUCCION pr "
				+ "WHERE pr.ID_COMPA�IA= "+ id + " and pr.ID_OBRA=ob.ID and ob.ID=fn.IDOBRA "
				+ "ORDER BY ob.ID " ;
		
		System.out.println(sql);

						PreparedStatement prepStmt = conn.prepareStatement(sql);
						recursos.add(prepStmt);
						ResultSet rs = prepStmt.executeQuery();

						
						while (rs.next()) {
							int idCom = Integer.parseInt(rs.getString("IDFUNCION"));
							System.out.println(idCom);
							
							java.util.Date now = new java.util.Date();
							java.sql.Date sqlDate = new java.sql.Date(now.getTime());
							funciones.add( new Funcion(idCom, sqlDate , 1, 1, "ok"));
							
							System.out.println("aqui 1");
							
						}
						
						System.out.println("termina el while");
						
						return funciones;
		
	}
	
	



	public ArrayList<Compa�ia> buscarCompa�iaPorName(String name) throws SQLException, Exception {
		

//		String sql = "SELECT * FROM COMPA�IA WHERE NAME ='" + name + "'";
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		ResultSet rs = prepStmt.executeQuery();
//		
//		Compa�ia comp = null;
//
//		while (rs.next()) {
//			int id = Integer.parseInt(rs.getString("ID"));
//			String nombre = rs.getString("NOMBRE");
//			String pais = rs.getString("PAISORIGEN");
//			String pagina = rs.getString("PAGINAWEB");
//			Date fechaLlegada = rs.getDate("FECHALLEGADA");
//			Date fechaSalida = rs.getDate("FECHASALIDA");
//			int representante = Integer.parseInt(rs.getString("REPRESENTANTE"));
//
//			comp = new Compa�ia(id, nombre, pais, pagina, fechaLlegada, fechaSalida, representante);
//		}
//
//		
//		
		return null;
	}


	public void llenarTabla() throws SQLException, Exception
	{
	

		int id = 3 ;
		

		
		int anoInicial = 2017;
		int anoFinal = 2018;
		
		int representante = 1;
		
		for (int k = 0; k < 15000; k++) {
			
			Random rnd = new Random();
			
		
			
			
			java.util.Date fecha1 = (java.util.Date) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(anoInicial + "-07-17 10:20:56");
			java.sql.Date fechaLlegada = new java.sql.Date(fecha1.getTime());
			
			String nombre = getSaltString();
			String paisOrigen = getSaltString();
			String paginaWeb = "www." + getSaltString() + ".com";
			
			java.util.Date fecha2 = (java.util.Date) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(anoFinal + "-07-17 10:20:56");
			java.sql.Date fechaSalida = new java.sql.Date(fecha2.getTime());
			
			
			
			
		    Compa�ia compa�ia = new Compa�ia(id, nombre, paisOrigen, paginaWeb, fechaLlegada, fechaSalida, representante);
			addCompa�ia(compa�ia);
			
			
			id++;
			anoFinal++;
			anoInicial++;
			nombre = nombre + id;
			representante++;
			
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
	public void addCompa�ia(Compa�ia compa�ia) throws SQLException, Exception {
		String sql = "INSERT INTO ISIS2304A261720.COMPA�IA VALUES ('";
		sql += compa�ia.getId() + "','";
		sql += compa�ia.getNombre() + "','";
		sql += compa�ia.getPaisOrigen() + "','";
		sql += compa�ia.getPaginaWeb() + "',to_date('";
		sql += compa�ia.getFechaLlegada() + "',";
		sql += "'yyyy-MM-dd  hh:mi:ss'),to_date('";
		sql += compa�ia.getFechaSalida() + "',";
		sql += "'yyyy-MM-dd  hh:mi:ss'),'";
		
		sql += compa�ia.getRepresentante() + "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	

	public void updateCompa�ia(Compa�ia compa�ia) throws SQLException, Exception {
//		String sql = "UPDATE ACTOR SET ";
//		sql += "NOMBRE='" + actor.getCedula() + "',";
//		sql += "ID_COMPA�IA='" + actor.getIdCompania() + "',";
//		sql += "NACIONALIDAD=" + actor.getNacionalidad();
//		sql += " WHERE CEDULA = " + actor.getCedula();
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
	}


	public void deleteCompa�ia(Compa�ia compa�ia) throws SQLException, Exception {
//		String sql = "DELETE FROM ACTOR";
//		sql += " WHERE id = " + actor.getCedula();
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
	}
	
	public ArrayList<ConsultaCompa�ia> darConsultaCompa�ia(int nId) throws SQLException, Exception {
		System.out.println("entro 1");
		ArrayList<ConsultaCompa�ia> consultaCompa�ia = darConsultaCompa�iaFunciones(nId);
				
		consultaCompa�ia = cambiarConsultaCompa�iaGananciaPosible(consultaCompa�ia, nId);
		
		consultaCompa�ia = cambiarConsultaCompa�iaGananciaReal(consultaCompa�ia, nId);
		
		consultaCompa�ia = cambiarConsultaCompa�iaTotalBoletas(consultaCompa�ia, nId);
		
		consultaCompa�ia = cambiarConsultaCompa�iaTotalBoletasVendidas(consultaCompa�ia, nId);
		
		return consultaCompa�ia;
	}
	
	
	public void retirarCompa�ia(int id) throws SQLException, Exception
	{
		ArrayList<Funcion> func = darFunciones(id);
		
		System.out.println("Aqui 2");
		for (int i = 0; i < func.size(); i++) 
		{
			
			System.out.println(func.size());
			
			Funcion fun = func.get(i);
			
			System.out.println(fun.getId()+ "este");
			
			
			cancelarFuncion2(fun);
			
		}
		
		
		
	}
	
public void cancelarFuncion2(Funcion funcion) throws SQLException, Exception {

		
		

		
		if (sePuedeCancelar2(funcion)) {
			
			System.out.println("entra a el if en se puede cancelar");
			String sql = "UPDATE ISIS2304A261720.FUNCION SET ";
			sql += "ESTADO='cancelado' " ;
			sql += " WHERE ID = " + funcion.getId();
			
			System.out.println("SQL stmt:" + sql);
			
			
			
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			prepStmt.executeQuery();
			ArrayList<Boleta> bol = darBoletasFuncion(funcion);
			
			for (int i = 0; i < bol.size(); i++) {
				
				devolverBoleta2(bol.get(i));
				System.out.println("aqui x1-");
			}
		}
	}

public void devolverBoleta2(Boleta boleta) throws SQLException, Exception {
	
	String sql = "UPDATE BOLETA SET ID_USUARIO = NULL ";
	sql += " WHERE ID = " + boleta.getId() + " AND ID_USUARIO IS NOT NULL";
	
	
	System.out.println("SQL stmt:" + sql);
	
	PreparedStatement prepStmt = conn.prepareStatement(sql);
	System.out.println("aqui");
	recursos.add(prepStmt);
	System.out.println("aqui");
	prepStmt.executeQuery();
	System.out.println("La Funcion ha sido cancelada, puede proceder a la entidad bancaria FestivAndes para la devolucion de su dinero.");


}
	
	
	
public boolean sePuedeCancelar2(Funcion funcion)
{
	System.out.println("entra a se puede cancelar");

	return true;
	
}

public ArrayList<Boleta> darBoletasFuncion( Funcion funcion) throws SQLException
{

	ArrayList<Boleta> boletas = new ArrayList<>();
	String sql = "SELECT * FROM ISIS2304A261720.BOLETA ";
	sql += " WHERE IDFUNCION = " + funcion.getId() + " AND ID_USUARIO IS NOT NULL";
	
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
		int idUsuario = 0;
		System.out.println("aqui dentro del while");
		boletas.add(new Boleta(id, letrafila, numerosilla, precio, idfuncion, idUsuario));
	}
	System.out.println("retorna las boletas");
	return boletas;
}
	private ArrayList<ConsultaCompa�ia> darConsultaCompa�iaFunciones(int nId) throws SQLException, Exception {
		System.out.println("entro 2");
		
		ArrayList<ConsultaCompa�ia> consultaCompa�ia = new ArrayList<ConsultaCompa�ia>();
		
		String sql = "SELECT fn.ID as IDFUNCION"
				+ " FROM ISIS2304A261720.COMPA�IA cm, ISIS2304A261720.PRODUCCION pr,"
				+ " ISIS2304A261720.OBRA ob, ISIS2304A261720.FUNCION fn"
				+ " WHERE cm.ID=pr.ID_COMPA�IA and pr.ID_OBRA=ob.ID and ob.ID=fn.IDOBRA and cm.ID=";
		sql += nId;
		sql += " GROUP BY fn.ID";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		System.out.println(sql);
		
		while (rs.next()) {
			System.out.println("entro al while");
			int idFuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			//System.out.println("id funcion=" + idFuncion);
			consultaCompa�ia.add(new ConsultaCompa�ia(nId, idFuncion, 0, 0, 0, 0));
		}
		return consultaCompa�ia;
	}
	
	
	private ArrayList<ConsultaCompa�ia> cambiarConsultaCompa�iaGananciaPosible(ArrayList<ConsultaCompa�ia> listaConsulta, int nId) throws SQLException, Exception {
		
		System.out.println("entro 3");
		
		String sql = "SELECT fn.ID as IDFUNCION, SUM(bl.precio) as GANANCIAPOSIBLE"
				+ " FROM ISIS2304A261720.COMPA�IA cm, ISIS2304A261720.PRODUCCION pr,"
				+ " ISIS2304A261720.OBRA ob, ISIS2304A261720.FUNCION fn, ISIS2304A261720.BOLETA bl"
				+ " WHERE cm.ID=pr.ID_COMPA�IA and pr.ID_OBRA=ob.ID and ob.ID=fn.IDOBRA and fn.ID=bl.IDFUNCION and cm.ID=";
		sql += nId;
		sql += " GROUP BY fn.ID";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int idFuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			int gananciaPosible = Integer.parseInt(rs.getString("GANANCIAPOSIBLE"));
			
			boolean encontro = false;
			for(int i=0; i<listaConsulta.size() && !encontro; i++)
			{
				if(listaConsulta.get(i).getIdFuncion()==idFuncion){
					listaConsulta.get(i).setGananciaPosible(gananciaPosible);
					encontro=true;
				}
			}
		}
		return listaConsulta;
	}
	
	
	private ArrayList<ConsultaCompa�ia> cambiarConsultaCompa�iaGananciaReal(ArrayList<ConsultaCompa�ia> listaConsulta, int nId) throws SQLException, Exception {
		
		System.out.println("entro 4");
		
		String sql = "SELECT fn.ID as IDFUNCION, SUM(bl.precio) as GANANCIAREAL"
				+ " FROM ISIS2304A261720.COMPA�IA cm, ISIS2304A261720.PRODUCCION pr,"
				+ " ISIS2304A261720.OBRA ob, ISIS2304A261720.FUNCION fn, ISIS2304A261720.BOLETA bl"
				+ " WHERE cm.ID=pr.ID_COMPA�IA and pr.ID_OBRA=ob.ID and ob.ID=fn.IDOBRA and fn.ID=bl.IDFUNCION and bl.ID_USUARIO IS NOT NULL and cm.ID=";
		sql += nId;
		sql += " GROUP BY fn.ID";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		System.out.println(sql);

		while (rs.next()) {
			int idFuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			int gananciaReal = Integer.parseInt(rs.getString("GANANCIAREAL"));
			
			boolean encontro = false;
			for(int i=0; i<listaConsulta.size() && !encontro; i++)
			{
				if(listaConsulta.get(i).getIdFuncion()==idFuncion){
					listaConsulta.get(i).setGananciaReal(gananciaReal);
					encontro=true;
				}
			}
		}
		return listaConsulta;
	}
	
	
	private ArrayList<ConsultaCompa�ia> cambiarConsultaCompa�iaTotalBoletas(ArrayList<ConsultaCompa�ia> listaConsulta, int nId) throws SQLException, Exception {
		
		System.out.println("entro 5");
		
		String sql = "SELECT fn.ID as IDFUNCION, COUNT(*) as TOTALBOLETAS"
				+ " FROM ISIS2304A261720.COMPA�IA cm, ISIS2304A261720.PRODUCCION pr,"
				+ " ISIS2304A261720.OBRA ob, ISIS2304A261720.FUNCION fn, ISIS2304A261720.BOLETA bl"
				+ " WHERE cm.ID=pr.ID_COMPA�IA and pr.ID_OBRA=ob.ID and ob.ID=fn.IDOBRA and fn.ID=bl.IDFUNCION and cm.ID=";
		sql += nId;
		sql += " GROUP BY fn.ID";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int idFuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			int totalBoletas = Integer.parseInt(rs.getString("TOTALBOLETAS"));
			
			boolean encontro = false;
			for(int i=0; i<listaConsulta.size() && !encontro; i++)
			{
				if(listaConsulta.get(i).getIdFuncion()==idFuncion){
					listaConsulta.get(i).setTotalBoletas(totalBoletas);
					encontro=true;
				}
			}
		}
		return listaConsulta;
	}
	
	
	private ArrayList<ConsultaCompa�ia> cambiarConsultaCompa�iaTotalBoletasVendidas(ArrayList<ConsultaCompa�ia> listaConsulta, int nId) throws SQLException, Exception {
		
		System.out.println("entro 6");
		
		String sql = "SELECT fn.ID as IDFUNCION, COUNT(*) as TOTALBOLETASVENDIDAS"
				+ " FROM ISIS2304A261720.COMPA�IA cm, ISIS2304A261720.PRODUCCION pr,"
				+ " ISIS2304A261720.OBRA ob, ISIS2304A261720.FUNCION fn, ISIS2304A261720.BOLETA bl"
				+ " WHERE cm.ID=pr.ID_COMPA�IA and pr.ID_OBRA=ob.ID and ob.ID=fn.IDOBRA and fn.ID=bl.IDFUNCION and bl.ID_USUARIO IS NOT NULL and cm.ID=";
		sql += nId;
		sql += " GROUP BY fn.ID";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int idFuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			int totalBoletasVendidas = Integer.parseInt(rs.getString("TOTALBOLETASVENDIDAS"));
			
			boolean encontro = false;
			for(int i=0; i<listaConsulta.size() && !encontro; i++)
			{
				if(listaConsulta.get(i).getIdFuncion()==idFuncion){
					listaConsulta.get(i).setTotalBoletasVendidas(totalBoletasVendidas);
					encontro=true;
				}
			}
		}
		return listaConsulta;
	}

}
