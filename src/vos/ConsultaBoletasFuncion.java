package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class ConsultaBoletasFuncion {
	
	@JsonProperty(value="IDFUNCION")
	private int idfuncion;

	@JsonProperty(value="NOMBREOBRA")
	private String nombreobra;

	@JsonProperty(value="FECHAINICIO")
	private Date fechainicio;

	@JsonProperty(value="NOMBRETEATRO")
	private String nombreteatro;

	@JsonProperty(value="ESTADO")
	private String estado;
	
	@JsonProperty(value="TOTALBOLETASDISPONIBLES")
	private int totalboletasdisponibles;
	
	@JsonProperty(value="TOTALBOLETASVENDIDAS")
	private int totalboletasvendidas;
	
	@JsonProperty(value="TOTALBOLETASNOVENDIDAS")
	private int totalboletasnovendidas;
	
	public ConsultaBoletasFuncion(@JsonProperty(value="IDFUNCION")int idfuncion,
		@JsonProperty(value="NOMBREOBRA")String nombreobra,
		@JsonProperty(value="FECHAINICIO")Date fechainicio,
		@JsonProperty(value="NOMBRETEATRO")String nombreteatro,
		@JsonProperty(value="ESTADO")String estado,
		@JsonProperty(value="TOTALBOLETASDISPONIBLES")int totalboletasdisponibles,	
		@JsonProperty(value="TOTALBOLETASVENDIDAS")int totalboletasvendidas,	
		@JsonProperty(value="TOTALBOLETASNOVENDIDAS")int totalboletasnovendidas) 
	{
		super();
		this.idfuncion = idfuncion;
		this.nombreobra = nombreobra;
		this.fechainicio = fechainicio;		
		this.nombreteatro = nombreteatro;
		this.estado = estado;
		this.totalboletasdisponibles = totalboletasdisponibles;
		this.totalboletasvendidas = totalboletasvendidas;
		this.totalboletasnovendidas = totalboletasnovendidas;
	}
	
	
	
	public int getIDFUNCION() {
		return idfuncion;
	}
	
	public void setIDFUNCION(int duration) {
		this.idfuncion = duration;
	}
	
	
	
	public String getNOMBREOBRA() {
		return nombreobra;
	}
		
	public void setNOMBREOBRA(String id) {
		this.nombreobra = id;
	}
	
	
	
	public Date getFECHAINICIO() {
		return fechainicio;
	}
		
	public void setFECHAINICIO(Date name) {
		this.fechainicio = name;
	}
	
	
	
	public String getNOMBRETEATRO() {
		return nombreteatro;
	}
		
	public void setNOMBRETEATRO(String name) {
		this.nombreteatro = name;
	}
	
	
	
	public String getESTADO() {
		return estado;
	}
		
	public void setESTADO(String name) {
		this.estado = name;
	}
	
	
	
	public int getTOTALBOLETASDISPONIBLES() {
		return totalboletasdisponibles;
	}
	
	public void setTOTALBOLETASDISPONIBLES(int name) {
		this.totalboletasdisponibles = name;
	}
	
	
	
	public int getTOTALBOLETASVENDIDAS() {
		return totalboletasvendidas;
	}
		
	public void setTOTALBOLETASVENDIDAS(int name) {
		this.totalboletasvendidas = name;
	}
	
	
	
	public int getTOTALBOLETASNOVENDIDAS() {
		return totalboletasnovendidas;
	}
		
	public void setTOTALBOLETASNOVENDIDAS(int name) {
		this.totalboletasnovendidas = name;
	}
	
}
