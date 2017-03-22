package tm;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import dao.DAOTablaActor;
import dao.DAOTablaBoleta;
import dao.DAOTablaCategoria;
import dao.DAOTablaCiudad;
import dao.DAOTablaCompa駃a;
import dao.DAOTablaFestival;
import dao.DAOTablaFuncion;
import dao.DAOTablaObra;
import dao.DAOTablaRepresentante;
import dao.DAOTablaTeatro;
import dao.DAOTablaUsuario;
import vos.Actor;
import vos.Boleta;
import vos.Categoria;
import vos.Ciudad;
import vos.Compa駃a;
import vos.Festival;
import vos.Funcion;
import vos.ListaActores;
import vos.ListaBoletas;
import vos.ListaCategoria;
import vos.ListaCiudad;
import vos.ListaCompa駃a;
import vos.ListaFestivales;
import vos.ListaFuncion;
import vos.ListaObra;
import vos.ListaRepresentante;
import vos.ListaTeatro;
import vos.ListaUsuario;
import vos.ListaUsuario_Categoria;
import vos.Obra;
import vos.Representante;
import vos.Teatro;
import vos.Usuario;
import vos.Usuario_Categoria;

public class FestiAndesMaster {
	
	/**
	 * Atributo est谩tico que contiene el path relativo del archivo que tiene los datos de la conexi贸n
	 */
	private static final String CONNECTION_DATA_FILE_NAME_REMOTE = "/conexion.properties";

	/**
	 * Atributo est谩tico que contiene el path absoluto del archivo que tiene los datos de la conexi贸n
	 */
	private  String connectionDataPath;

	/**
	 * Atributo que guarda el usuario que se va a usar para conectarse a la base de datos.
	 */
	private String user;

	/**
	 * Atributo que guarda la clave que se va a usar para conectarse a la base de datos.
	 */
	private String password;

	/**
	 * Atributo que guarda el URL que se va a usar para conectarse a la base de datos.
	 */
	private String url;

	/**
	 * Atributo que guarda el driver que se va a usar para conectarse a la base de datos.
	 */
	private String driver;
	
	/**
	 * Conexi贸n a la base de datos
	 */
	private Connection conn;


	/**
	 * M茅todo constructor de la clase VideoAndesMaster, esta clase modela y contiene cada una de las 
	 * transacciones y la logia de negocios que estas conllevan.
	 * <b>post: </b> Se crea el objeto VideoAndesMaster, se inicializa el path absoluto de el archivo de conexi贸n y se
	 * inicializa los atributos que se usan par la conexi贸n a la base de datos.
	 * @param contextPathP - path absoluto en el servidor del contexto del deploy actual
	 */
	public FestiAndesMaster(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}

	/**
	 * M茅todo que  inicializa los atributos que se usan para la conexion a la base de datos.
	 * <b>post: </b> Se han inicializado los atributos que se usan par la conexi贸n a la base de datos.
	 */
	private void initConnectionData() {
		try {
			File arch = new File(this.connectionDataPath);
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream(arch);
			prop.load(in);
			in.close();
			this.url = prop.getProperty("url");
			this.user = prop.getProperty("usuario");
			this.password = prop.getProperty("clave");
			this.driver = prop.getProperty("driver");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * M茅todo que  retorna la conexi贸n a la base de datos
	 * @return Connection - la conexi贸n a la base de datos
	 * @throws SQLException - Cualquier error que se genere durante la conexi贸n a la base de datos
	 */
	private Connection darConexion() throws SQLException {
		System.out.println("Connecting to: " + url + " With user: " + user);
		return DriverManager.getConnection(url, user, password);
	}
	
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Actor -----------------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------
	private void inicioActor(){
	}
	
	public ListaActores darActores() throws Exception {
		
		ArrayList<Actor> actores;
		DAOTablaActor daoActor = new DAOTablaActor();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			daoActor.setConn(conn);
			actores = daoActor.darActores();

		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoActor.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaActores(actores);
	}
	
	public ListaActores buscarActorPorNombre(int nNombre) throws Exception {
		ArrayList<Actor> actores;
		DAOTablaActor daoActor = new DAOTablaActor();
		try 
		{
			this.conn = darConexion();
			daoActor.setConn(conn);
			actores = daoActor.buscarActorPorName(nNombre);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoActor.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaActores(actores);
	}
	
	public void addActor(Actor nActor) throws Exception {
		DAOTablaActor daoActor = new DAOTablaActor();
		try 
		{
			this.conn = darConexion();
			daoActor.setConn(conn);
			daoActor.addActor(nActor);
			conn.commit();

		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoActor.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateActor(Actor nActor) throws Exception {
		DAOTablaActor daoActor = new DAOTablaActor();
		try 
		{
			this.conn = darConexion();
			daoActor.setConn(conn);
			daoActor.updateActor(nActor);

		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoActor.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteActor(Actor nActor) throws Exception {
		DAOTablaActor daoActor = new DAOTablaActor();
		try 
		{
			this.conn = darConexion();
			daoActor.setConn(conn);
			daoActor.deleteActor(nActor);

		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoActor.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Obra -----------------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------
	private void inicioObra(){
	}
	
	public ListaObra darObras() throws Exception {
		ArrayList<Obra> obras;
		DAOTablaObra daoObra = new DAOTablaObra();
		try 
		{
			this.conn = darConexion();
			daoObra.setConn(conn);
			obras = daoObra.darObras();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoObra.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaObra(obras);
	}
	
	public ListaObra buscarObraPorNombre(String nNombre) throws Exception {
		ArrayList<Obra> obras;
		DAOTablaObra daoObra = new DAOTablaObra();
		try 
		{
			this.conn = darConexion();
			daoObra.setConn(conn);
			obras = daoObra.buscarObraPorName(nNombre);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoObra.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaObra(obras);
	}
	
	public ListaObra buscarObraPorId(int nId) throws Exception {
		ArrayList<Obra> obras;
		DAOTablaObra daoObra = new DAOTablaObra();
		try 
		{
			this.conn = darConexion();
			daoObra.setConn(conn);
			obras = daoObra.buscarObraPorId(nId);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoObra.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaObra(obras);
	}
	
	public void addObra(Obra nObra) throws Exception {
		DAOTablaObra daoObra = new DAOTablaObra();
		try 
		{
			this.conn = darConexion();
			daoObra.setConn(conn);
			daoObra.addObra(nObra);
			conn.commit();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoObra.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateObra(Obra nObra) throws Exception {
		DAOTablaObra daoObra = new DAOTablaObra();
		try 
		{
			this.conn = darConexion();
			daoObra.setConn(conn);
			daoObra.updateObra(nObra);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoObra.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteObra(Obra nObra) throws Exception {
		DAOTablaObra daoObra = new DAOTablaObra();
		try 
		{
			this.conn = darConexion();
			daoObra.setConn(conn);
			daoObra.deleteObra(nObra);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoObra.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	
	

	
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Funcion ---------------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------
	private void inicioFuncion(){
	}
	
	public ListaFuncion darFunciones(Date f, Date f2, Categoria  categoria ,String  idioma, Boolean orden) throws Exception {
		ArrayList<Funcion> funciones;
		DAOTablaFuncion daoFuncion = new DAOTablaFuncion();
		try 
		{
			this.conn = darConexion();
			daoFuncion.setConn(conn);
			funciones = daoFuncion.darFuncion( f,  f2, categoria, idioma, orden);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoFuncion.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaFuncion(funciones);
	}
	
	

	
//	public ListaFuncion buscarFuncnionPorCategoria(String nCategoria) throws Exception {
//		ArrayList<Funcion> funciones;
//		DAOTablaFuncion daoFuncion = new DAOTablaFuncion();
//		try 
//		{
//			this.conn = darConexion();
//			daoFuncion.setConn(conn);
//			funciones = daoFuncion.buscarFuncionPorCategoria(nCategoria);
//		} 
//		catch (SQLException e) {
//			System.err.println("SQLException:" + e.getMessage());
//			e.printStackTrace();
//			throw e;
//		} 
//		catch (Exception e) {
//			System.err.println("GeneralException:" + e.getMessage());
//			e.printStackTrace();
//			throw e;
//		} 
//		finally {
//			try {
//				daoFuncion.cerrarRecursos();
//				if(this.conn!=null) this.conn.close();
//			} 
//			catch (SQLException exception) {
//				System.err.println("SQLException closing resources:" + exception.getMessage());
//				exception.printStackTrace();
//				throw exception;
//			}
//		}
//		return new ListaFuncion(funciones);
//	}
//	
//	public ListaFuncion buscarFuncionPorTeatro(String nTeatro) throws Exception {
//		ArrayList<Funcion> funciones;
//		DAOTablaFuncion daoFuncion = new DAOTablaFuncion();
//		try 
//		{
//			this.conn = darConexion();
//			daoFuncion.setConn(conn);
//			funciones = daoFuncion.buscarFuncionPorTeatro(nTeatro);
//		} 
//		catch (SQLException e) {
//			System.err.println("SQLException:" + e.getMessage());
//			e.printStackTrace();
//			throw e;
//		} 
//		catch (Exception e) {
//			System.err.println("GeneralException:" + e.getMessage());
//			e.printStackTrace();
//			throw e;
//		} 
//		finally {
//			try {
//				daoFuncion.cerrarRecursos();
//				if(this.conn!=null) this.conn.close();
//			} 
//			catch (SQLException exception) {
//				System.err.println("SQLException closing resources:" + exception.getMessage());
//				exception.printStackTrace();
//				throw exception;
//			}
//		}
//		return new ListaFuncion(funciones);
//	}
//	
//	public ListaFuncion buscarFuncionPorId(int nId) throws Exception {
//		ArrayList<Funcion> funciones;
//		DAOTablaFuncion daoFuncion = new DAOTablaFuncion();
//		try 
//		{
//			this.conn = darConexion();
//			daoFuncion.setConn(conn);
//			funciones = daoFuncion.buscarFuncionPorId(nId);
//		} 
//		catch (SQLException e) {
//			System.err.println("SQLException:" + e.getMessage());
//			e.printStackTrace();
//			throw e;
//		} 
//		catch (Exception e) {
//			System.err.println("GeneralException:" + e.getMessage());
//			e.printStackTrace();
//			throw e;
//		} 
//		finally {
//			try {
//				daoFuncion.cerrarRecursos();
//				if(this.conn!=null) this.conn.close();
//			} 
//			catch (SQLException exception) {
//				System.err.println("SQLException closing resources:" + exception.getMessage());
//				exception.printStackTrace();
//				throw exception;
//			}
//		}
//		return new ListaFuncion(funciones);
//	}
//	
	
	public void addFuncion(Funcion nFuncion) throws Exception {
		DAOTablaFuncion daoFuncion = new DAOTablaFuncion();
		try 
		{
			this.conn = darConexion();
			daoFuncion.setConn(conn);
			daoFuncion.addFuncion(nFuncion);
			conn.commit();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoFuncion.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateFuncion(Funcion nFuncion) throws Exception {
		DAOTablaFuncion daoFuncion = new DAOTablaFuncion();
		try 
		{
			this.conn = darConexion();
			daoFuncion.setConn(conn);
			daoFuncion.updateFuncion(nFuncion);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoFuncion.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteFuncion(Funcion nFuncion) throws Exception {
		DAOTablaFuncion daoFuncion = new DAOTablaFuncion();
		try 
		{
			this.conn = darConexion();
			daoFuncion.setConn(conn);
			daoFuncion.deleteFuncion(nFuncion);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoFuncion.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Teatro ----------------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------
	private void inicioTeatro(){
	}
	
	public ListaTeatro darTeatros() throws Exception {
		ArrayList<Teatro> teatros;
		DAOTablaTeatro daoTeatro = new DAOTablaTeatro();
		try 
		{
			this.conn = darConexion();
			daoTeatro.setConn(conn);
			teatros = daoTeatro.darTeatro();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoTeatro.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaTeatro(teatros);
	}
	
	public ListaTeatro buscarTeatroPorNombre(String nNombre) throws Exception {
		ArrayList<Teatro> teatros;
		DAOTablaTeatro daoTeatro = new DAOTablaTeatro();
		try 
		{
			this.conn = darConexion();
			daoTeatro.setConn(conn);
			teatros = daoTeatro.buscarTeatroPorName(nNombre);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoTeatro.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaTeatro(teatros);
	}
	
	public void addTeatro(Teatro nTeatro) throws Exception {
		DAOTablaTeatro daoTeatro = new DAOTablaTeatro();
		try 
		{
			this.conn = darConexion();
			daoTeatro.setConn(conn);
			daoTeatro.addTeatro(nTeatro);
			conn.commit();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoTeatro.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateTeatro(Teatro nTeatro) throws Exception {
		DAOTablaTeatro daoTeatro = new DAOTablaTeatro();
		try 
		{
			this.conn = darConexion();
			daoTeatro.setConn(conn);
			daoTeatro.updateTeatro(nTeatro);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoTeatro.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteTeatro(Teatro nTeatro) throws Exception {
		DAOTablaTeatro daoTeatro = new DAOTablaTeatro();
		try 
		{
			this.conn = darConexion();
			daoTeatro.setConn(conn);
			daoTeatro.deleteTeatro(nTeatro);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoTeatro.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Ciudad ----------------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------
	private void inicioCiudad(){
	}
	
	public ListaCiudad darCiudades() throws Exception {
		ArrayList<Ciudad> ciudades;
		DAOTablaCiudad daoCiudad = new DAOTablaCiudad();
		try 
		{
			this.conn = darConexion();
			daoCiudad.setConn(conn);
			ciudades = daoCiudad.darCiudades();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoCiudad.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaCiudad(ciudades);
	}
	
	public ListaCiudad buscarCiudadPorNombre(String nNombre) throws Exception {
		ArrayList<Ciudad> Ciudades;
		DAOTablaCiudad daoCiudad = new DAOTablaCiudad();
		try 
		{
			this.conn = darConexion();
			daoCiudad.setConn(conn);
			Ciudades = daoCiudad.buscarCiudadPorName(nNombre);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoCiudad.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaCiudad(Ciudades);
	}
	
	public void addCiudad(Ciudad nCiudad) throws Exception {
		DAOTablaCiudad daoCiudad = new DAOTablaCiudad();
		try 
		{
			this.conn = darConexion();
			daoCiudad.setConn(conn);
			daoCiudad.addCiudad(nCiudad);
			conn.commit();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoCiudad.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateCiudad(Ciudad nCiudad) throws Exception {
		DAOTablaCiudad daoCiudad = new DAOTablaCiudad();
		try 
		{
			this.conn = darConexion();
			daoCiudad.setConn(conn);
			daoCiudad.updateCiudad(nCiudad);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoCiudad.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteCiudad(Ciudad nCiudad) throws Exception {
		DAOTablaCiudad daoCiudad = new DAOTablaCiudad();
		try 
		{
			this.conn = darConexion();
			daoCiudad.setConn(conn);
			daoCiudad.deleteCiudad(nCiudad);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoCiudad.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Categoria -------------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------
	private void inicioCategoria(){
	}
	
	public ListaCategoria darCategorias() throws Exception {
		ArrayList<Categoria> categorias;
		DAOTablaCategoria daoCategoria = new DAOTablaCategoria();
		try 
		{
			this.conn = darConexion();
			daoCategoria.setConn(conn);
			categorias = daoCategoria.darCategorias();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoCategoria.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaCategoria(categorias);
	}
	
	public ListaCategoria buscarCategoriaPorNombre(String nNombre) throws Exception {
		ArrayList<Categoria> categoria;
		DAOTablaCategoria daoCategoria = new DAOTablaCategoria();
		try 
		{
			this.conn = darConexion();
			daoCategoria.setConn(conn);
			categoria = daoCategoria.buscarCategoriaPorName(nNombre);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoCategoria.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaCategoria(categoria);
	}
	
	public void addCategoria(Categoria nCategoria) throws Exception {
		DAOTablaCategoria daoCategoria = new DAOTablaCategoria();
		try 
		{
			this.conn = darConexion();
			daoCategoria.setConn(conn);
			daoCategoria.addCategoria(nCategoria);
			conn.commit();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoCategoria.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateCategoria(Categoria nCategoria) throws Exception {
		DAOTablaCategoria daoCiudad = new DAOTablaCategoria();
		try 
		{
			this.conn = darConexion();
			daoCiudad.setConn(conn);
			daoCiudad.updateCategoria(nCategoria);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoCiudad.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteCategoria(Categoria nCategoria) throws Exception {
		DAOTablaCategoria daoCategoria = new DAOTablaCategoria();
		try 
		{
			this.conn = darConexion();
			daoCategoria.setConn(conn);
			daoCategoria.deleteCategoria(nCategoria);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoCategoria.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Compa駃a --------------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------
	private void inicioCompa駃a(){
	}
	
	public ListaCompa駃a darCompa駃as() throws Exception {
		ArrayList<Compa駃a> compa駃as;
		DAOTablaCompa駃a daoCompa駃a = new DAOTablaCompa駃a();
		try 
		{
			this.conn = darConexion();
			daoCompa駃a.setConn(conn);
			compa駃as = daoCompa駃a.darCompa駃as();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoCompa駃a.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaCompa駃a(compa駃as);
	}
	
	public ListaCompa駃a buscarCompa駃aPorNombre(String nNombre) throws Exception {
		ArrayList<Compa駃a> compa駃as;
		DAOTablaCompa駃a daoCompa駃a = new DAOTablaCompa駃a();
		try 
		{
			this.conn = darConexion();
			daoCompa駃a.setConn(conn);
			compa駃as = daoCompa駃a.buscarCompa駃aPorName(nNombre);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoCompa駃a.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaCompa駃a(compa駃as);
	}
	
	public void addCompa駃a(Compa駃a nCompa駃a) throws Exception {
		DAOTablaCompa駃a daoCompa駃a = new DAOTablaCompa駃a();
		try 
		{
			this.conn = darConexion();
			daoCompa駃a.setConn(conn);
			daoCompa駃a.addCompa駃a(nCompa駃a);
			conn.commit();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoCompa駃a.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateCompa駃a(Compa駃a nCompa駃a) throws Exception {
		DAOTablaCompa駃a daoCompa駃a = new DAOTablaCompa駃a();
		try 
		{
			this.conn = darConexion();
			daoCompa駃a.setConn(conn);
			daoCompa駃a.updateCompa駃a(nCompa駃a);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoCompa駃a.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteCompa駃a(Compa駃a nCompa駃a) throws Exception {
		DAOTablaCompa駃a daoCompa駃a = new DAOTablaCompa駃a();
		try 
		{
			this.conn = darConexion();
			daoCompa駃a.setConn(conn);
			daoCompa駃a.deleteCompa駃a(nCompa駃a);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoCompa駃a.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Boleta ----------------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------
	private void inicioBoleta(){
	}
	
	public ListaBoletas darBoletas() throws Exception {
		ArrayList<Boleta> boleta;
		DAOTablaBoleta daoBoleta = new DAOTablaBoleta();
		try 
		{
			this.conn = darConexion();
			daoBoleta.setConn(conn);
			boleta = daoBoleta.darBoletas();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoBoleta.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaBoletas(boleta);
	}
		
	public void addBoleta(Boleta nBoleta) throws Exception {
		DAOTablaBoleta daoBoleta = new DAOTablaBoleta();
		try 
		{
			this.conn = darConexion();
			daoBoleta.setConn(conn);
			daoBoleta.addBoleta(nBoleta);
			conn.commit();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoBoleta.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateBoleta(Boleta nBoleta) throws Exception {
		DAOTablaBoleta daoBoleta = new DAOTablaBoleta();
		try 
		{
			this.conn = darConexion();
			daoBoleta.setConn(conn);
			daoBoleta.updateBoleta(nBoleta);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoBoleta.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteBoleta(Boleta nBoleta) throws Exception {
		DAOTablaBoleta daoBolet = new DAOTablaBoleta();
		try 
		{
			this.conn = darConexion();
			daoBolet.setConn(conn);
			daoBolet.deleteBoleta(nBoleta);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoBolet.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Usuario ---------------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------
	private void inicioUsuario(){
	}
	
	public ListaUsuario darUsuarios() throws Exception {
		ArrayList<Usuario> usuarios;
		DAOTablaUsuario daoUsuario = new DAOTablaUsuario();
		try 
		{
			this.conn = darConexion();
			daoUsuario.setConn(conn);
			usuarios = daoUsuario.darUsuarios();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoUsuario.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaUsuario(usuarios);
	}
		
	public void addUsuario(Usuario nUsuario) throws Exception {
		DAOTablaUsuario daoUsuario = new DAOTablaUsuario();
		try 
		{
			this.conn = darConexion();
			daoUsuario.setConn(conn);
			daoUsuario.addUsuario(nUsuario);
			conn.commit();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoUsuario.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateUsuario(Usuario nUsuario) throws Exception {
		DAOTablaUsuario daoUsuario = new DAOTablaUsuario();
		try 
		{
			this.conn = darConexion();
			daoUsuario.setConn(conn);
			daoUsuario.updateUsuario(nUsuario);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoUsuario.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteUsuario(Usuario nUsuario) throws Exception {
		DAOTablaUsuario daoUsuario = new DAOTablaUsuario();
		try 
		{
			this.conn = darConexion();
			daoUsuario.setConn(conn);
			daoUsuario.deleteUsuario(nUsuario);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoUsuario.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Festival --------------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------
	private void inicioFestival(){
	}
	
	public ListaFestivales darFestivales() throws Exception {
		ArrayList<Festival> ferias;
		DAOTablaFestival daoTeatro = new DAOTablaFestival();
		try 
		{
			this.conn = darConexion();
			daoTeatro.setConn(conn);
			ferias = daoTeatro.darFestivales();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoTeatro.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaFestivales(ferias);
	}
	
	public ListaFestivales buscarFestivalPorNombre(String nNombre) throws Exception {
		ArrayList<Festival> festival;
		DAOTablaFestival daoFestival = new DAOTablaFestival();
		try 
		{
			this.conn = darConexion();
			daoFestival.setConn(conn);
			festival = daoFestival.buscarFestivalPorName(nNombre);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoFestival.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaFestivales(festival);
	}
	
	public void addFestival(Festival nFestival) throws Exception {
		DAOTablaFestival daoTeatro = new DAOTablaFestival();
		try 
		{
			this.conn = darConexion();
			daoTeatro.setConn(conn);
			daoTeatro.addFestival(nFestival);
			conn.commit();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoTeatro.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateFestival(Festival nFestival) throws Exception {
		DAOTablaFestival daoFestival = new DAOTablaFestival();
		try 
		{
			this.conn = darConexion();
			daoFestival.setConn(conn);
			daoFestival.updateFestival(nFestival);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoFestival.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteFestival(Festival nFestival) throws Exception {
		DAOTablaFestival daoFestival = new DAOTablaFestival();
		try 
		{
			this.conn = darConexion();
			daoFestival.setConn(conn);
			daoFestival.deleteFestival(nFestival);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoFestival.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Representante -----------------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------
	private void inicioRepresentante(){
	}
	
	public ListaRepresentante darRepresentante() throws Exception {		
		ArrayList<Representante> representantes;
		DAOTablaRepresentante daoActor = new DAOTablaRepresentante();
		try 
		{
			this.conn = darConexion();
			daoActor.setConn(conn);
			representantes = daoActor.darRepresentante();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoActor.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaRepresentante(representantes);
	}
	
	public ListaRepresentante buscarRepresentantePorNombre(String nNombre) throws Exception {
		ArrayList<Representante> representante;
		DAOTablaRepresentante daoRepresentante = new DAOTablaRepresentante();
		try 
		{
			this.conn = darConexion();
			daoRepresentante.setConn(conn);
			representante = daoRepresentante.buscarRepresentantePorName(nNombre);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoRepresentante.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaRepresentante(representante);
	}
	
	public ListaRepresentante buscarRepresentantePorCedula(int nCedula) throws Exception {
		ArrayList<Representante> representante;
		DAOTablaRepresentante daoRepresentante = new DAOTablaRepresentante();
		try 
		{
			this.conn = darConexion();
			daoRepresentante.setConn(conn);
			representante = daoRepresentante.buscarRepresentantePorCedula(nCedula);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoRepresentante.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaRepresentante(representante);
	}
	
	public void addRepresentante(Representante nRepresentante) throws Exception {
		DAOTablaRepresentante daoRepresentante = new DAOTablaRepresentante();
		try 
		{
			this.conn = darConexion();
			daoRepresentante.setConn(conn);
			daoRepresentante.addRepresentante(nRepresentante);
			conn.commit();

		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoRepresentante.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateRepresentante(Representante nRepresentante) throws Exception {
		DAOTablaRepresentante daoRepresentante = new DAOTablaRepresentante();
		try 
		{
			this.conn = darConexion();
			daoRepresentante.setConn(conn);
			daoRepresentante.updateRepresentante(nRepresentante);

		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoRepresentante.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteRepresentante(Representante nRepresentante) throws Exception {
		DAOTablaRepresentante daoRepresentante = new DAOTablaRepresentante();
		try 
		{
			this.conn = darConexion();
			daoRepresentante.setConn(conn);
			daoRepresentante.deleteRepresentante(nRepresentante);

		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoRepresentante.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Usuario_Categoria --------------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------
	private void inicioUsuarioCategoria(){
	}
	
	public ListaUsuario_Categoria darUsuarioCategoria() throws Exception {
		ArrayList<Usuario_Categoria> usuarioCategorias;
		DAOTablaUsuario_Categoria daoUsuarioCategoria = new DAOTablaUsuario_Categoria();
		try 
		{
			this.conn = darConexion();
			daoUsuarioCategoria.setConn(conn);
			usuarioCategorias = daoUsuarioCategoria.darUsuario_Categoria();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoUsuarioCategoria.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaUsuario_Categoria(usuarioCategorias);
	}
	
	public ListaUsuario_Categoria buscarUsuarioCategoriaPorCedula(int nCedula) throws Exception {
		ArrayList<Usuario_Categoria> usuarioCategorias;
		DAOTablaUsuario_Categoria daoUsuarioCategoria = new DAOTablaUsuario_Categoria();
		try 
		{
			this.conn = darConexion();
			daoUsuarioCategoria.setConn(conn);
			usuarioCategorias = daoUsuarioCategoria.buscarUsuarioCategoriaPorCedula(nCedula);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoUsuarioCategoria.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaUsuario_Categoria(usuarioCategorias);
	}
	
	public void addUsuarioCategoria(Usuario_Categoria nUsuarioCategoria) throws Exception {
		DAOTablaUsuario_Categoria daoUsuarioCategoria = new DAOTablaUsuario_Categoria();
		try 
		{
			this.conn = darConexion();
			daoUsuarioCategoria.setConn(conn);
			daoUsuarioCategoria.addUsuario_Categoria(nUsuarioCategoria);
			conn.commit();
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoUsuarioCategoria.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateUsuarioCategoria(Usuario_Categoria nUsuarioCategoria) throws Exception {
		DAOTablaUsuario_Categoria daoUsuarioCategoria = new DAOTablaUsuario_Categoria();
		try 
		{
			this.conn = darConexion();
			daoUsuarioCategoria.setConn(conn);
			daoUsuarioCategoria.updateUsuario_Categoria(nUsuarioCategoria);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoUsuarioCategoria.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} 
			catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteUsuarioCategoria(Usuario_Categoria nUsuarioCategoria) throws Exception {
		DAOTablaUsuario_Categoria daoUsuarioCategoria = new DAOTablaUsuario_Categoria();
		try 
		{
			this.conn = darConexion();
			daoUsuarioCategoria.setConn(conn);
			daoUsuarioCategoria.deleteUsuario_Categoria(nUsuarioCategoria);
		} 
		catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally {
			try {
				daoUsuarioCategoria.cerrarRecursos();
				if(this.conn!=null) this.conn.close();
			} catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
}
