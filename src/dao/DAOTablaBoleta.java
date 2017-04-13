package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import vos.Abono;
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

		String sql = "SELECT f.ID as idFuncion, SUM(b.precio) as ganancia FROM ISIS2304A261720.FUNCION f, ISIS2304A261720.BOLETA b"
+" Where f.ID=b.IDFUNCION GROUP BY f.ID";

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
	


	
	
	public void venderBoleta(BoletasVendidas boleta) throws SQLException, Exception {
		
		System.out.println("aqui 1");
		if(buscarSiYaEstaVendida(boleta.getIdBoleta()) != false)
		{
			System.out.println(" entra al if");
			String sql = "UPDATE BOLETA SET ";
			sql += " ID_USUARIO = " + boleta.getIdCliente();
			sql += " WHERE ID = " + boleta.getIdBoleta();

			System.out.println("sql");
			System.out.println("SQL stmt:" + sql);

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			prepStmt.executeQuery();
		}	
		else
		{
			throw new Exception("La boleta que se desea comprar ya ha sido tomada, seleccione otra.");
		}
		
	}
	
	
	public void venderVariasBoleta(ListaBoletasVendidas boleta) throws SQLException, Exception {
		
		List<BoletasVendidas> boletasVendidas = boleta.getBoletasVendidas();
		BoletasVendidas[] arrBoletas = (BoletasVendidas[]) boletasVendidas.toArray();
		
		if(buscarSiEstanEnMismaFila(boletasVendidas))
		{
			for (int i = 0; i < arrBoletas.length; i++) {
				
				if(!buscarSiYaEstaVendida(arrBoletas[i].getIdBoleta()))
				{
					String sql = "UPDATE BOLETA SET ";
					sql += "ID_USUARIO='" + arrBoletas[i].getIdCliente();
					
					sql += " WHERE ID = " + arrBoletas[i].getIdBoleta();
					
					System.out.println("SQL stmt:" + sql);
					
					PreparedStatement prepStmt = conn.prepareStatement(sql);
					recursos.add(prepStmt);
					prepStmt.executeQuery();
				}
			}
		}
	}
	
	
	public void devolverBoleta(Boleta boleta) throws SQLException, Exception {
		
		Funcion fun = obtenerFuncion(boleta.getIdFuncion());
		
		System.out.println(boleta.getId());
		System.out.println("llega aqui 3");
		
		java.util.Date currentDate = new java.util.Date();

	     
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

		java.util.Date newDate = new java.sql.Date(fun.getFechaInicio().getTime());
		System.out.println(newDate);
	     
		if (daysBetween(currentDate, newDate ) >= 5) 
		{
			System.out.println("llega aqui 5");
			
			String sql = "UPDATE BOLETA SET ID_USUARIO = NULL";
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
	
public void devolverBoleta2(Boleta boleta) throws SQLException, Exception {
			
			String sql = "UPDATE ISIS2304A261720.BOLETA SET ID_USUARIO = NULL";
			sql += " WHERE ID = " + boleta.getId();
			
			System.out.println("SQL stmt:" + sql);
			
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			
			recursos.add(prepStmt);
			prepStmt.executeQuery();
			System.out.println("La Funcion ha sido cancelada, puede proceder a la entidad bancaria FestivAndes para la devolucion de su dinero.");
		
		
	}
	
	
	public int daysBetween(java.util.Date d1, java.util.Date d2)
	{
		
		System.out.println("llega aqui 4");
		int res = (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
		System.out.println(res);
        return res;

        
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
	
	
	public void deleteBoleta(Boleta boleta) throws SQLException, Exception {
		String sql = "DELETE FROM ISIS2304A261720.BOLETA";
		sql += " WHERE ID = " + boleta.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	
	public void venderAbono(Abono abono) throws SQLException, Exception {
		
		String [] listaBoletas = abono.getIdBoletas();
				
		for (int i = 0; i < listaBoletas.length; i++) {
			
			if(buscarSiYaEstaVendida(Integer.parseInt(listaBoletas[i])))
			{
<<<<<<< HEAD
				Boleta bol = buscarBoleta(listaBoletas[i]);
				System.out.println(bol.getIdFuncion());
				Funcion fun = obtenerFuncion(bol.getIdFuncion());
				System.out.println(fun.getId());
				java.util.Date currentDate = new java.util.Date();

			     
				SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

				java.util.Date newDate = new java.sql.Date(fun.getFechaInicio().getTime());
=======
				String sql = "UPDATE ISIS2304A261720.BOLETA SET PRECIO=PRECIO*0.8,";
				sql += " ID_USUARIO='" + abono.getIdCliente() + "',";
				sql += " ABONO='" + abono.getIdBoletas() + "'";
				
				sql += " WHERE ID=" + listaBoletas[i];
				
				System.out.println("SQL stmt:" + sql);
>>>>>>> origin/master
				
				if (daysBetween(currentDate, newDate) >= 21) 
				{
					
					String sql = "UPDATE BOLETA SET";
					sql += " ID_USUARIO=" + abono.getIdCliente() ;
					sql += ", ABONO=" + abono.getIdAbono() ;
					
					sql += " WHERE ID=" + listaBoletas[i];
					
					System.out.println("SQL stmt:" + sql);
					
					PreparedStatement prepStmt = conn.prepareStatement(sql);
					recursos.add(prepStmt);
					prepStmt.executeQuery();
				}
				else
				{
					throw new Exception("imposible realizar el abono");
				}
			}
			else 
			{
				throw new Exception("una de las boletas que desea comprar ya ha sido reservada,"
						+ "id de la boleta:" + listaBoletas[i]);
			}
		}
	}
	
	
	private Boleta buscarBoleta(String string) throws SQLException 
	{
		Boleta bol = null;
		String sql = "SELECT * FROM BOLETA WHERE ID = " + Integer.parseInt(string);
		

		
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next())
		{
	
			int id = Integer.parseInt(rs.getString("ID"));
			String letraFila = rs.getString("LETRAFILA");
			int numeroSilla = Integer.parseInt(rs.getString("NUMEROSILLA"));
			int precio = Integer.parseInt(rs.getString("PRECIO"));
			int idFuncion = Integer.parseInt(rs.getString("IDFUNCION"));		
			System.out.println(idFuncion);
			
			
			
			bol = new Boleta(id, letraFila, numeroSilla, precio, idFuncion, 0);
		}
		
		return bol;
	}

	public void devolverAbono(Abono abono) throws SQLException, Exception {
		
		String sql = "UPDATE ISIS2304A261720.BOLETA SET PRECIO=PRECIO*1.25";
		sql += " ID_USUARIO='null',";
		sql += " ABONO='null'";
		
		sql += " WHERE ID_ABONO=" + abono.getIdAbono();
		
		System.out.println("SQL stmt:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
		
	}
	
	
	private Boolean buscarSiEstanEnMismaFila(List<BoletasVendidas> boletasVendidas) throws Exception {
		
		boolean resp=true;
		String filaIni=darFilaBoleta(boletasVendidas.get(0).getIdBoleta());
		
		for(int i=1; i<boletasVendidas.size() && resp; i++)
		{
			String fila2 = darFilaBoleta(boletasVendidas.get(i).getIdBoleta());
			
			if(!filaIni.equals(fila2))resp=false;
		}
				
		return resp;
	}
	
	
	private String darFilaBoleta(int nId) throws Exception {
		
		String sql = "SELECT * FROM BOLETA WHERE ID = " + nId;
		
		String fila="";
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next())
		{
			fila = rs.getString("LETRAFILA");
		}
				
		return fila;
	}
	
	
	private Boolean buscarSiYaEstaVendida(int id) throws Exception {

		String sql = "SELECT * FROM BOLETA WHERE ID = " + id;
		
		Boleta boleta = null;
		
		System.out.println("buscar si ya esta vendida");
		System.out.println(sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next())
		{
			
			
			String letrafila = rs.getString("LETRAFILA");
			System.out.println(letrafila);
			int numeroSilla = Integer.parseInt(rs.getString("NUMEROSILLA"));
			System.out.println(numeroSilla);
			int precio = Integer.parseInt(rs.getString("PRECIO"));
			System.out.println(precio);
			int idfuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			System.out.println(idfuncion);
			int idUsuario = 0;
			try {
				idUsuario = Integer.parseInt(rs.getString("ID_USUARIO"));
				System.out.println(idUsuario);
				
			} catch (Exception e) {
				return true;
			}
			
			boleta = new Boleta(id, letrafila, numeroSilla, precio, idfuncion, idUsuario);
		}
		
		System.out.println("retorna");
		return false;
		
	}
		
	
}
