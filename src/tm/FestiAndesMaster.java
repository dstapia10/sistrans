package tm;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import dao.DAOTablaActor;
import dao.DAOTablaFerias;
import vos.Actor;
import vos.ListaActores;
import vos.ListaObra;
import vos.Obra;

public class FestiAndesMaster {
	
	/**
	 * Atributo estático que contiene el path relativo del archivo que tiene los datos de la conexión
	 */
	private static final String CONNECTION_DATA_FILE_NAME_REMOTE = "/conexion.properties";

	/**
	 * Atributo estático que contiene el path absoluto del archivo que tiene los datos de la conexión
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
	 * Conexión a la base de datos
	 */
	private Connection conn;


	/**
	 * Método constructor de la clase VideoAndesMaster, esta clase modela y contiene cada una de las 
	 * transacciones y la logia de negocios que estas conllevan.
	 * <b>post: </b> Se crea el objeto VideoAndesMaster, se inicializa el path absoluto de el archivo de conexión y se
	 * inicializa los atributos que se usan par la conexión a la base de datos.
	 * @param contextPathP - path absoluto en el servidor del contexto del deploy actual
	 */
	public FestiAndesMaster(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}

	/**
	 * Método que  inicializa los atributos que se usan para la conexion a la base de datos.
	 * <b>post: </b> Se han inicializado los atributos que se usan par la conexión a la base de datos.
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
	 * Método que  retorna la conexión a la base de datos
	 * @return Connection - la conexión a la base de datos
	 * @throws SQLException - Cualquier error que se genere durante la conexión a la base de datos
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
			//////Transacción
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
	
	public ListaActores buscarActorPorNombre(String nNombre) throws Exception {
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
	
	
	
	
	
	// por hacer -------------------------------------------------------------------------------------------------------------------
	public ListaObra darObras() throws Exception {
		return null;
	}
	
	// por hacer -------------------------------------------------------------------------------------------------------------------
	public ListaObra buscarObraPorNombre(String nNombre) throws Exception {
		return null;
	}
	
	// por hacer -------------------------------------------------------------------------------------------------------------------
	public Obra addObra(Obra nObra) throws Exception {
		return null;
	}
	

}
