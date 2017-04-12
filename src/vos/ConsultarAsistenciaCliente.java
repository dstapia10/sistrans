package vos;

import java.util.Date;
import org.codehaus.jackson.annotate.JsonProperty;

public class ConsultarAsistenciaCliente {
	
	@JsonProperty(value="ID_USUARIO")
	private int id_usuario;

	@JsonProperty(value="LETRAFILA")
	private String letrafila;

	@JsonProperty(value="NUMEROSILLA")
	private int numeroSilla;

	@JsonProperty(value="IDOBRA")
	private int idobra;

	@JsonProperty(value="IDFUNCION")
	private int idfuncion;
	
	@JsonProperty(value="FECHAINICIO")
	private Date fechainicio;
	
	public ConsultarAsistenciaCliente(@JsonProperty(value="ID_USUARIO")int id_usuario,
			@JsonProperty(value="LETRAFILA")String letrafila,
			@JsonProperty(value="NUMEROSILLA")int numerosilla,
			@JsonProperty(value="IDOBRA") int idobra, 
			@JsonProperty(value="IDFUNCION") int idfuncion,
			@JsonProperty(value="FECHAINICIO") Date fechainicio) 
	{
		super();
		this.id_usuario = id_usuario;
		this.letrafila = letrafila;
		this.numeroSilla = numerosilla;		
		this.idobra = idobra;
		this.idfuncion = idfuncion;
		this.fechainicio = fechainicio;
	}
	

	public int getId_Usuario() {
		return id_usuario;
	}


	public void setId_Usuario(int duration) {
		this.id_usuario = duration;
	}


	public String getLetraFila() {
		return letrafila;
	}

	
	public void setLetraFila(String id) {
		this.letrafila = id;
	}

	
	public int getNumeroSilla() {
		return numeroSilla;
	}

	
	public void setNumeroSilla(int name) {
		this.numeroSilla = name;
	}

	
	
	public int getIdObra() {
		return idobra;
	}

	
	public void setIdObra(int name) {
		this.idobra = name;
	}
	
	public int getIdFuncion() {
		return idfuncion;
	}

	
	public void setIdfuncion(int name) {
		this.idfuncion = name;
	}
	
	public Date getFechaInicio() {
		return fechainicio;
	}
	
	public void setFechaInicio(Date name) {
		this.fechainicio = name;
	}
	
}
