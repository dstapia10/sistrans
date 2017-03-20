package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Compañia 
{

	@JsonProperty(value="ID")
	private int id;


	@JsonProperty(value="NOMBRE")
	private String nombre;


	@JsonProperty(value="PAISORIGEN")
	private String paisOrigen;

	@JsonProperty(value="PAGINAWEB")
	private String paginaWeb;

	@JsonProperty(value="FECHALLEGADA")
	private Date fechaLlegada;

	@JsonProperty(value="FECHASALIDA")
	private Date fechaSalida;
	
	@JsonProperty(value="REPRESENTANTE")
	private int representante;

	
	public Compañia(@JsonProperty(value="ID")int id,@JsonProperty(value="NOMBRE")String nombre,
			@JsonProperty(value="PAISORIGEN")String paisOrigen,@JsonProperty(value="PAGINAWEB") String paginaWeb,
			@JsonProperty(value="FECHALLEGADA") Date fechaLlegada, @JsonProperty(value="FECHASALIDA") Date fechaSalida,
			@JsonProperty(value="REPRESENTANTE") int representante) 
	{
		super();
		this.id = id;
		this.nombre = nombre;
		this.paisOrigen = paisOrigen;
		this.paginaWeb = paginaWeb;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.representante = representante;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int duration) {
		this.id = duration;
	}


	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String id) {
		this.nombre = id;
	}

	
	public String getPaisOrigen() {
		return paisOrigen;
	}

	
	public void setPaisOrigen(String name) {
		this.paisOrigen = name;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	
	public void setPaginaWeb(String name) {
		this.paginaWeb = name;
	}
	
	
	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	
	public void setFechaLlegada(Date name) {
		this.fechaLlegada = name;
	}
	
	public Date getFechaSalida() {
		return fechaSalida;
	}

	
	public void setFechaSalida(Date name) {
		this.fechaSalida = name;
	}
	
	public int getRepresentante() {
		return representante;
	}

	
	public void setRepresentante(int name) {
		this.representante = name;
	}
	
}
