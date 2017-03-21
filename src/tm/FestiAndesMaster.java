package tm;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import dao.DAOTablaActor;
import dao.DAOTablaBoleta;
import dao.DAOTablaCategoria;
import dao.DAOTablaCiudad;
import dao.DAOTablaCompa駃a;
import dao.DAOTablaFuncion;
import dao.DAOTablaObra;
import dao.DAOTablaTeatro;
import vos.Actor;
import vos.Boleta;
import vos.Categoria;
import vos.Ciudad;
import vos.Compa駃a;
import vos.Funcion;
import vos.ListaActores;
import vos.ListaBoletas;
import vos.ListaCategoria;
import vos.ListaCiudad;
import vos.ListaCompa駃a;
import vos.ListaFuncion;
import vos.ListaObra;
import vos.ListaTeatro;
import vos.Obra;
import vos.Teatro;

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
	
	public ListaFuncion darFunciones() throws Exception {
		ArrayList<Funcion> funciones;
		DAOTablaFuncion daoFuncion = new DAOTablaFuncion();
		try 
		{
			this.conn = darConexion();
			daoFuncion.setConn(conn);
			funciones = daoFuncion.darFuncion();
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
	
	public ListaFuncion buscarFuncnionPorNombre(String nNombre) throws Exception {
		ArrayList<Funcion> funciones;
		DAOTablaFuncion daoFuncion = new DAOTablaFuncion();
		try 
		{
			this.conn = darConexion();
			daoFuncion.setConn(conn);
			funciones = daoFuncion.buscarFuncionPorName(nNombre);
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
		
//	public void addCompa駃a(Compa駃a nCompa駃a) throws Exception {
//		DAOTablaCompa駃a daoCompa駃a = new DAOTablaCompa駃a();
//		try 
//		{
//			this.conn = darConexion();
//			daoCompa駃a.setConn(conn);
//			daoCompa駃a.addCompa駃a(nCompa駃a);
//			conn.commit();
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
//				daoCompa駃a.cerrarRecursos();
//				if(this.conn!=null) this.conn.close();
//			} 
//			catch (SQLException exception) {
//				System.err.println("SQLException closing resources:" + exception.getMessage());
//				exception.printStackTrace();
//				throw exception;
//			}
//		}
//	}
//	
//	public void updateCompa駃a(Compa駃a nCompa駃a) throws Exception {
//		DAOTablaCompa駃a daoCompa駃a = new DAOTablaCompa駃a();
//		try 
//		{
//			this.conn = darConexion();
//			daoCompa駃a.setConn(conn);
//			daoCompa駃a.updateCompa駃a(nCompa駃a);
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
//				daoCompa駃a.cerrarRecursos();
//				if(this.conn!=null) this.conn.close();
//			} 
//			catch (SQLException exception) {
//				System.err.println("SQLException closing resources:" + exception.getMessage());
//				exception.printStackTrace();
//				throw exception;
//			}
//		}
//	}
//	
//	public void deleteCompa駃a(Compa駃a nCompa駃a) throws Exception {
//		DAOTablaCompa駃a daoCompa駃a = new DAOTablaCompa駃a();
//		try 
//		{
//			this.conn = darConexion();
//			daoCompa駃a.setConn(conn);
//			daoCompa駃a.deleteCompa駃a(nCompa駃a);
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
//				daoCompa駃a.cerrarRecursos();
//				if(this.conn!=null) this.conn.close();
//			} catch (SQLException exception) 
//			{
//				System.err.println("SQLException closing resources:" + exception.getMessage());
//				exception.printStackTrace();
//				throw exception;
//			}
//		}
//	}
		
}
