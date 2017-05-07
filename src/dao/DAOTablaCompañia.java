package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import vos.Compaņia;
import vos.ConsultaCompaņia;
import vos.Usuario;

public class DAOTablaCompaņia {
	
	/**
	 * Arraylits de recursos que se usan para la ejecuciÃŗn de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexiÃŗn a la base de datos
	 */
	private Connection conn;

	/**
	 * MÃŠtodo constructor que crea DAOVideo
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOTablaCompaņia() {
		recursos = new ArrayList<Object>();
	}

	/**
	 * MÃŠtodo que cierra todos los recursos que estan enel arreglo de recursos
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
	 * MÃŠtodo que inicializa la connection del DAO a la base de datos con la conexiÃŗn que entra como parÃĄmetro.
	 * @param con  - connection a la base de datos
	 */
	public void setConn(Connection con){
		this.conn = con;
	}


	public ArrayList<Compaņia> darCompaņia() throws SQLException, Exception {
//		ArrayList<Actor> actores = new ArrayList<Actor>();
//
//		String sql = "SELECT * FROM ACTOR";
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		ResultSet rs = prepStmt.executeQuery();
//
//		while (rs.next()) {
//			int cedula = Integer.parseInt(rs.getString("CEDULA"));
//			String nombre = rs.getString("NOMBRE");
//			int compaņia = Integer.parseInt(rs.getString("ID_COMPAŅIA"));
//			String nacionalidad = rs.getString("NACIONALIDAD");
//			actores.add(new Actor(cedula, compaņia, nombre, nacionalidad));
//		}
//		return actores;
		
		return null;
	}



	public ArrayList<Compaņia> buscarCompaņiaPorName(String name) throws SQLException, Exception {
		

//		String sql = "SELECT * FROM COMPAŅIA WHERE NAME ='" + name + "'";
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		ResultSet rs = prepStmt.executeQuery();
//		
//		Compaņia comp = null;
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
//			comp = new Compaņia(id, nombre, pais, pagina, fechaLlegada, fechaSalida, representante);
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
			
			
			
			
		    Compaņia compaņia = new Compaņia(id, nombre, paisOrigen, paginaWeb, fechaLlegada, fechaSalida, representante);
			addCompaņia(compaņia);
			
			
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
	public void addCompaņia(Compaņia compaņia) throws SQLException, Exception {
		String sql = "INSERT INTO ISIS2304A261720.COMPAŅIA VALUES ('";
		sql += compaņia.getId() + "','";
		sql += compaņia.getNombre() + "','";
		sql += compaņia.getPaisOrigen() + "','";
		sql += compaņia.getPaginaWeb() + "',to_date('";
		sql += compaņia.getFechaLlegada() + "',";
		sql += "'yyyy-MM-dd  hh:mi:ss'),to_date('";
		sql += compaņia.getFechaSalida() + "',";
		sql += "'yyyy-MM-dd  hh:mi:ss'),'";
		
		sql += compaņia.getRepresentante() + "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	

	public void updateCompaņia(Compaņia compaņia) throws SQLException, Exception {
//		String sql = "UPDATE ACTOR SET ";
//		sql += "NOMBRE='" + actor.getCedula() + "',";
//		sql += "ID_COMPAŅIA='" + actor.getIdCompania() + "',";
//		sql += "NACIONALIDAD=" + actor.getNacionalidad();
//		sql += " WHERE CEDULA = " + actor.getCedula();
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
	}


	public void deleteCompaņia(Compaņia compaņia) throws SQLException, Exception {
//		String sql = "DELETE FROM ACTOR";
//		sql += " WHERE id = " + actor.getCedula();
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
	}
	
	public ArrayList<ConsultaCompaņia> darConsultaCompaņia(int nId) throws SQLException, Exception {
		System.out.println("entro 1");
		ArrayList<ConsultaCompaņia> consultaCompaņia = darConsultaCompaņiaFunciones(nId);
				
		consultaCompaņia = cambiarConsultaCompaņiaGananciaPosible(consultaCompaņia, nId);
		
		consultaCompaņia = cambiarConsultaCompaņiaGananciaReal(consultaCompaņia, nId);
		
		consultaCompaņia = cambiarConsultaCompaņiaTotalBoletas(consultaCompaņia, nId);
		
		consultaCompaņia = cambiarConsultaCompaņiaTotalBoletasVendidas(consultaCompaņia, nId);
		
		return consultaCompaņia;
	}
	
	
	private ArrayList<ConsultaCompaņia> darConsultaCompaņiaFunciones(int nId) throws SQLException, Exception {
		System.out.println("entro 2");
		
		ArrayList<ConsultaCompaņia> consultaCompaņia = new ArrayList<ConsultaCompaņia>();
		
		String sql = "SELECT fn.ID as IDFUNCION"
				+ " FROM ISIS2304A261720.COMPAŅIA cm, ISIS2304A261720.PRODUCCION pr,"
				+ " ISIS2304A261720.OBRA ob, ISIS2304A261720.FUNCION fn"
				+ " WHERE cm.ID=pr.ID_COMPAŅIA and pr.ID_OBRA=ob.ID and ob.ID=fn.IDOBRA and cm.ID=";
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
			consultaCompaņia.add(new ConsultaCompaņia(nId, idFuncion, 0, 0, 0, 0));
		}
		return consultaCompaņia;
	}
	
	
	private ArrayList<ConsultaCompaņia> cambiarConsultaCompaņiaGananciaPosible(ArrayList<ConsultaCompaņia> listaConsulta, int nId) throws SQLException, Exception {
		
		System.out.println("entro 3");
		
		String sql = "SELECT fn.ID as IDFUNCION, SUM(bl.precio) as GANANCIAPOSIBLE"
				+ " FROM ISIS2304A261720.COMPAŅIA cm, ISIS2304A261720.PRODUCCION pr,"
				+ " ISIS2304A261720.OBRA ob, ISIS2304A261720.FUNCION fn, ISIS2304A261720.BOLETA bl"
				+ " WHERE cm.ID=pr.ID_COMPAŅIA and pr.ID_OBRA=ob.ID and ob.ID=fn.IDOBRA and fn.ID=bl.IDFUNCION and cm.ID=";
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
	
	
	private ArrayList<ConsultaCompaņia> cambiarConsultaCompaņiaGananciaReal(ArrayList<ConsultaCompaņia> listaConsulta, int nId) throws SQLException, Exception {
		
		System.out.println("entro 4");
		
		String sql = "SELECT fn.ID as IDFUNCION, SUM(bl.precio) as GANANCIAREAL"
				+ " FROM ISIS2304A261720.COMPAŅIA cm, ISIS2304A261720.PRODUCCION pr,"
				+ " ISIS2304A261720.OBRA ob, ISIS2304A261720.FUNCION fn, ISIS2304A261720.BOLETA bl"
				+ " WHERE cm.ID=pr.ID_COMPAŅIA and pr.ID_OBRA=ob.ID and ob.ID=fn.IDOBRA and fn.ID=bl.IDFUNCION and bl.ID_USUARIO IS NOT NULL and cm.ID=";
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
	
	
	private ArrayList<ConsultaCompaņia> cambiarConsultaCompaņiaTotalBoletas(ArrayList<ConsultaCompaņia> listaConsulta, int nId) throws SQLException, Exception {
		
		System.out.println("entro 5");
		
		String sql = "SELECT fn.ID as IDFUNCION, COUNT(*) as TOTALBOLETAS"
				+ " FROM ISIS2304A261720.COMPAŅIA cm, ISIS2304A261720.PRODUCCION pr,"
				+ " ISIS2304A261720.OBRA ob, ISIS2304A261720.FUNCION fn, ISIS2304A261720.BOLETA bl"
				+ " WHERE cm.ID=pr.ID_COMPAŅIA and pr.ID_OBRA=ob.ID and ob.ID=fn.IDOBRA and fn.ID=bl.IDFUNCION and cm.ID=";
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
	
	
	private ArrayList<ConsultaCompaņia> cambiarConsultaCompaņiaTotalBoletasVendidas(ArrayList<ConsultaCompaņia> listaConsulta, int nId) throws SQLException, Exception {
		
		System.out.println("entro 6");
		
		String sql = "SELECT fn.ID as IDFUNCION, COUNT(*) as TOTALBOLETASVENDIDAS"
				+ " FROM ISIS2304A261720.COMPAŅIA cm, ISIS2304A261720.PRODUCCION pr,"
				+ " ISIS2304A261720.OBRA ob, ISIS2304A261720.FUNCION fn, ISIS2304A261720.BOLETA bl"
				+ " WHERE cm.ID=pr.ID_COMPAŅIA and pr.ID_OBRA=ob.ID and ob.ID=fn.IDOBRA and fn.ID=bl.IDFUNCION and bl.ID_USUARIO IS NOT NULL and cm.ID=";
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
