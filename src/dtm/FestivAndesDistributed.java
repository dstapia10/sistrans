package dtm;

import java.io.IOException;import java.security.NoSuchAlgorithmException;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TopicConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import com.rabbitmq.jms.admin.RMQConnectionFactory;
import com.rabbitmq.jms.admin.RMQDestination;

import jms.HacerAbonoMDB;
import jms.NonReplyException;
import jms.RetirarCompañiaMDB2;
import tm.FestiAndesMaster;

import vos.ListaBoletasFestival;

public class FestivAndesDistributed 
{
	private final static String QUEUE_NAME = "java:global/RMQAppQueue";
	private final static String MQ_CONNECTION_NAME = "java:global/RMQClient";
	
	private static FestivAndesDistributed instance;
	
	private FestiAndesMaster tm;
	
	private QueueConnectionFactory queueFactory;
	
	private TopicConnectionFactory factory;
	
	private HacerAbonoMDB hacerAbonoMDB;
	
	private static String path;
	
	private RetirarCompañiaMDB2 retirar;


	private FestivAndesDistributed() throws NamingException, JMSException
	{
		InitialContext ctx = new InitialContext();
		factory = (RMQConnectionFactory) ctx.lookup(MQ_CONNECTION_NAME);
		hacerAbonoMDB = new HacerAbonoMDB(factory, ctx);
		
		hacerAbonoMDB.start();
		
	}
	
	public void stop() throws JMSException
	{
		hacerAbonoMDB.close();
	}
	
	/**
	 * MÃ©todo que retorna el path de la carpeta WEB-INF/ConnectionData en el deploy actual dentro del servidor.
	 * @return path de la carpeta WEB-INF/ConnectionData en el deploy actual.
	 */
	public static void setPath(String p) {
		path = p;
	}
	
	public void setUpTransactionManager(FestiAndesMaster tm)
	{
	   this.tm = tm;
	}
	
	private static FestivAndesDistributed getInst()
	{
		return instance;
	}
	
	public static FestivAndesDistributed getInstance(FestiAndesMaster tm)
	{
		if(instance == null)
		{
			try {
				instance = new FestivAndesDistributed();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		instance.setUpTransactionManager(tm);
		return instance;
	}
	
	public static FestivAndesDistributed getInstance()
	{
		if(instance == null)
		{
			FestiAndesMaster tm = new FestiAndesMaster(path);
			return getInstance(tm);
		}
		if(instance.tm != null)
		{
			return instance;
		}
		FestiAndesMaster tm = new FestiAndesMaster(path);
		return getInstance(tm);
	}	

	
	//-------------------------------------------------------------------------------------------------------------
	// ITERACIÓN 5
	//-------------------------------------------------------------------------------------------------------------
	
	public ListaBoletasFestival hacerAbonoLocal(int idCliente, ListaBoletasFestival lista) throws Exception
	{
		return tm.hacerAbonoLocal(idCliente, lista);
	}
	
	public ListaBoletasFestival hacerAbonoRemoto(int idCliente, ListaBoletasFestival lista) throws JsonGenerationException, JsonMappingException, JMSException, IOException, NonReplyException, InterruptedException, NoSuchAlgorithmException
	{
		return hacerAbonoMDB.hacerAbonoRemoto(idCliente, lista);
	}
	
	
	public String retirarCompañiaLocal(int idCompañia) throws Exception
	{
		return tm.darCompañias(idCompañia)
	}
	
	public ListaBoletasFestival retirarCompañiaRemoto(int idCompañia) throws JsonGenerationException, JsonMappingException, JMSException, IOException, NonReplyException, InterruptedException, NoSuchAlgorithmException
	{
		return retirar.hacerAbonoRemoto(idCliente, lista)
	}
}
