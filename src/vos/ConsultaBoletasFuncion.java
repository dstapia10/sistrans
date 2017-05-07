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
	
	@JsonProperty(value="BOLETASDISPONIBLESLOCALIDAD")
	private int boletasdisponibleslocalidad;
	
	@JsonProperty(value="BOLETASVENDIDASLOCALIDAD")
	private int boletasvendidaslocalidad;
	
	@JsonProperty(value="BOLETASNOVENDIDASLOCALIDAD")
	private int boletasnovendidaslocalidad;
	
	public ConsultaBoletasFuncion(@JsonProperty(value="IDFUNCION")int idfuncion,
		@JsonProperty(value="NOMBREOBRA")String nombreobra,
		@JsonProperty(value="FECHAINICIO")Date fechainicio,
		@JsonProperty(value="NOMBRETEATRO")String nombreteatro,
		@JsonProperty(value="ESTADO")String estado,
		@JsonProperty(value="BOLETASDISPONIBLESLOCALIDAD")int boletasdisponibleslocalidad,	
		@JsonProperty(value="BOLETASVENDIDASLOCALIDAD")int totalboletasvendidaslocalidad,	
		@JsonProperty(value="BOLETASNOVENDIDASLOCALIDAD")int totalboletasnovendidaslocalidad) 
	{
		super();
		this.idfuncion = idfuncion;
		this.nombreobra = nombreobra;
		this.fechainicio = fechainicio;		
		this.nombreteatro = nombreteatro;
		this.estado = estado;
		this.boletasdisponibleslocalidad = boletasdisponibleslocalidad;
		this.boletasvendidaslocalidad = totalboletasvendidaslocalidad;
		this.boletasnovendidaslocalidad = totalboletasnovendidaslocalidad;
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
	
	
	
	public int getBOLETASDISPONIBLESLOCALIDAD() {
		return boletasdisponibleslocalidad;
	}
	
	public void setBOLETASDISPONIBLESLOCALIDAD(int name) {
		this.boletasdisponibleslocalidad = name;
	}
	
	
	
	public int getBOLETASVENDIDASLOCALIDAD() {
		return boletasvendidaslocalidad;
	}
		
	public void setBOLETASVENDIDASLOCALIDAD(int name) {
		this.boletasvendidaslocalidad = name;
	}
	
	
	
	public int getTOTALBOLETASNOVENDIDASLOCALIDAD() {
		return boletasnovendidaslocalidad;
	}
		
	public void setBOLETASNOVENDIDASLOCALIDAD(int name) {
		this.boletasnovendidaslocalidad = name;
	}
	
}
