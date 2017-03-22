package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class ReporteFuncion {
	
	@JsonProperty(value="LOCALIDADES")
	private String localidades;
	//1;zoom;3
	
	@JsonProperty(value="BOLETASVENDIDASLOCALIDADES")
	private String boletaVendidasLocalidades;
		
	@JsonProperty(value="INGRESOLOSCALIDADES")
	private String ingresosLocalidades;
	
	@JsonProperty(value="USUARIOS")
	private String usuarios;
	
	@JsonProperty(value="BOLETASVENDIDASUSUARIOS")
	private String boletaVendidasUsuarios;
	
	@JsonProperty(value="INGRESOLOSUSUARIOS")
	private String ingresosUsuarios;
	
	
	public ReporteFuncion(@JsonProperty(value="LOCALIDADES") String localidades, 
			@JsonProperty(value="BOLETASVENDIDASLOCALIDADES") String boletaVendidasLocalidades,
			@JsonProperty(value="INGRESOLOSCALIDADES") String ingresosLocalidades,			
			@JsonProperty(value="USUARIOS") String usuarios,
			@JsonProperty(value="BOLETASVENDIDASUSUARIOS") String boletaVendidasUsuarios,			
			@JsonProperty(value="INGRESOLOSUSUARIOS") String ingresosUsuarios) 
	{
		super();
		this.localidades = localidades;
		this.boletaVendidasLocalidades = boletaVendidasLocalidades;
		this.ingresosLocalidades = ingresosLocalidades;
		this.usuarios = usuarios;
		this.boletaVendidasUsuarios = boletaVendidasUsuarios;
		this.ingresosUsuarios = ingresosUsuarios;
	}
	

	public String getLocalidades() {
		return localidades;
	}
	
	public void setLocalidades(String localidades) {
		this.localidades = localidades;
	}
	
	
	public String getBoletaVendidasLocalidades() {
		return boletaVendidasLocalidades;
	}
	
	public void setBoletaVendidasLocalidades(String boletaVendidasLocalidades) {
		this.boletaVendidasLocalidades = boletaVendidasLocalidades;
	}
		
	
	public String getIngresosLocalidades() {
		return ingresosLocalidades;
	}
	
	public void setIngresosLocalidades(String ingresosLocalidades) {
		this.ingresosLocalidades = ingresosLocalidades;
	}
	
	
	public String getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(String usuarios) {
		this.usuarios = usuarios;
	}
	
	
	public String getBoletaVendidasUsuarios() {
		return boletaVendidasUsuarios;
	}
	
	public void setBoletaVendidasUsuarios(String boletaVendidasUsuarios) {
		this.boletaVendidasUsuarios = boletaVendidasUsuarios;
	}
	
	
	public String getIngresosUsuarios() {
		return ingresosUsuarios;
	}
	
	public void setIngresosUsuarios(String ingresosUsuarios) {
		this.ingresosUsuarios = ingresosUsuarios;
	}
	
}
