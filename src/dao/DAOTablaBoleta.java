package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import vos.Actor;
import vos.Boleta;
import vos.BoletaGet;
import vos.BoletasVendidas;
import vos.Funcion;
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
		
		List<BoletasVendidas> boletasVendidas = boleta.getBoletasVendidas();
		BoletasVendidas[] arrBoletas = (BoletasVendidas[]) boletasVendidas.toArray();
		for (int i = 0; i < arrBoletas.length; i++) {
			
			
			String sql = "UPDATE BOLETA SET ";
			sql += "ID_USUARIO='" + arrBoletas[i].getIdCliente();
			
			sql += " WHERE ID = " + arrBoletas[i].getIdBoleta();
			
			System.out.println("SQL stmt:" + sql);
			
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			prepStmt.executeQuery();
		}
	}
	


		

	
	
	public void devolverBoleta(Boleta boleta) throws SQLException, Exception {
		
		Funcion fun = obtenerFuncion(boleta.getIdFuncion());
		
		Date currentDate = (Date) new java.util.Date();
		if (daysBetween(fun.getFechaInicio(), currentDate ) >= 5) 
		{
			
			
			String sql = "UPDATE BOLETA SET ID_USUARIO='null'";
			sql += " WHERE ID = " + boleta.getId();
			
			System.out.println("SQL stmt:" + sql);
			
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			prepStmt.executeQuery();
			System.out.println("La reserva de la boleta ha sido cancelada, puede proceder a la entidad bancaria FestivAndes para la devolucion de su dinero.");
		}
		
		else 
		{
			throw new Exception("es imposible cancelar esta reserva");
		}
	}
	
	
	public int daysBetween(Date d1, Date d2)
	{
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));

	}
	
	public Funcion obtenerFuncion(int idFuncion) throws SQLException
	{
		
		String sql = "SELECT * FROM FUNCION WHERE ID =" + idFuncion; 
		
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

			int id = Integer.parseInt(rs.getString("ID"));
			Date fechaInicio = rs.getDate("FECHAINICIO");
			int idTeatro = Integer.parseInt(rs.getString("IDTEATRO"));
			int idObra = Integer.parseInt(rs.getString("IDOBRA"));
			
			
			
			
			Funcion Funcion = new Funcion(id, fechaInicio, idTeatro, idObra);
		
		return Funcion;
	}
	
	
	
	public void deleteBoleta(Boleta boleta) throws SQLException, Exception {
		String sql = "DELETE FROM ISIS2304A261720.BOLETA";
		sql += " WHERE ID = " + boleta.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	
	private Boolean buscarSiYaEstanEnMismaFila(List<BoletasVendidas> boletasVendidas) throws Exception {
		
		ArrayList<Boleta> boletasARevisar = new ArrayList<Boleta>();		
		ArrayList<Boleta> bo = darBoletasTodaInfo();		
		Boolean rpta = false;
		
		
		for (int i = 0; i < bo.size(); i++) 
		{
			for (int j = 0; j < boletasVendidas.size(); j++) 
			{
				if (bo.get(i).getId() == boletasVendidas.get(j).getIdBoleta())
				{
					boletasARevisar.add(bo.get(i));
				}
			}
		}
		
		
		if(boletasARevisar.isEmpty()==false)
		{
			rpta = true;
			String letraFilaIni=boletasARevisar.get(0).getLetraFila();
			for (int i = 0; i < boletasARevisar.size() && rpta; i++) 
			{
				if (!boletasARevisar.get(i).getLetraFila().equals(letraFilaIni))
				{
					rpta = false;
				}
			}
		}
			
		
		return rpta;
		
	}
	
	
	private Boolean buscarSiYaEstaVendida(int id) throws Exception {

		ArrayList<Boleta> bo = darBoletasTodaInfo();
		Boolean rpta = false;
		for (int i = 0; i < bo.size() && !rpta; i++) 
		{
			if (bo.get(i).getId() == id)
			{
				rpta = true;
			}
		}
		

		return rpta;
		
	}
	
	
	private ArrayList<Boleta> darBoletasTodaInfo() throws SQLException, Exception {
		ArrayList<Boleta> boletas = new ArrayList<Boleta>();

		String sql = "SELECT * FROM ISIS2304A261720.BOLETA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			String letrafila = rs.getString("LETRAFILA");
			int numeroSilla = Integer.parseInt(rs.getString("NUMEROSILLA"));
			int precio = Integer.parseInt(rs.getString("PRECIO"));
			int idfuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			int idUsuario = Integer.parseInt(rs.getString("ID_USUARIO"));
			
			boletas.add(new Boleta(id,letrafila,numeroSilla,precio,idfuncion,idUsuario));
		}
		return boletas;
	}

	
	
	
}
