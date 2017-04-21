package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Compa�ia;
import vos.ConsultaCompa�ia;

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


	public ArrayList<Compa�ia> darCompa�ia() throws SQLException, Exception {
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
//			int compa�ia = Integer.parseInt(rs.getString("ID_COMPA�IA"));
//			String nacionalidad = rs.getString("NACIONALIDAD");
//			actores.add(new Actor(cedula, compa�ia, nombre, nacionalidad));
//		}
//		return actores;
		
		return null;
	}



	public ArrayList<Compa�ia> buscarCompa�iaPorName(String name) throws SQLException, Exception {
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
//			int compa�ia = Integer.parseInt(rs.getString("ID_COMPA�IA"));
//			String nacionalidad = rs.getString("NACIONALIDAD");
//			actores.add(new Actor(cedula, compa�ia, nombre, nacionalidad));
//		}
//
//		return actores;
		
		return null;
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
