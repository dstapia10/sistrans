package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class ReporteFuncion {
	
	@JsonProperty(value="LOCALIDADES")
	private String localidades;
	//localidad1;localidad2;localidad3
	
	@JsonProperty(value="BOLETASVENDIDASLOCALIDADES")
	private String boletasVendidasLocalidades;
	//boltasVendidasLocalidad1;boltasVendidasLocalidad2;boltasVendidasLocalidad3	
	
	@JsonProperty(value="INGRESOSLOSCALIDADES")
	private String ingresosLocalidades;
	//ingrsosLocalidad1;ingrsosLocalidad2;ingrsosLocalidad3
	
	
	@JsonProperty(value="USUARIOS")
	private String usuarios;
	//usuarios1(cliente);usuario2(anonimo)
	
	@JsonProperty(value="BOLETASVENDIDASUSUARIOS")
	private String boletasVendidasUsuarios;
	//bolteasVendidasUsuarios1(cliente);boletasVendidasUsuario2(anonimo)
	
	@JsonProperty(value="INGRESOSUSUARIOS")
	private String ingresosUsuarios;
	//ingresoUsuarios1(cliente);ingresoUsuario2(anonimo)
	
	
	public ReporteFuncion(@JsonProperty(value="LOCALIDADES") String localidades,
			@JsonProperty(value="BOLETASVENDIDASLOCALIDADES") String boletasVendidasLocalidades,
			@JsonProperty(value="INGRESOSLOSCALIDADES") String ingresosLocalidades,
			@JsonProperty(value="USUARIOS") String usuarios,
			@JsonProperty(value="BOLETASVENDIDASUSUARIOS") String boletasVendidasUsuarios,
			@JsonProperty(value="INGRESOSUSUARIOS") String ingresosUsuarios) {
		super();
		this.localidades = localidades;
		this.boletasVendidasLocalidades = boletasVendidasLocalidades;
		this.ingresosLocalidades = ingresosLocalidades;
		this.usuarios = usuarios;
		this.boletasVendidasUsuarios = boletasVendidasUsuarios;
		this.ingresosUsuarios = ingresosUsuarios;
	}
	

	public String getLocalidades() {
		return localidades;
	}
	
	public void setLocalidades(String localidades) {
		this.localidades = localidades;
	}
	
	
	public String getBoletaVendidasLocalidades() {
		return boletasVendidasLocalidades;
	}
	
	public void setBoletaVendidasLocalidades(String boletaVendidasLocalidades) {
		this.boletasVendidasLocalidades = boletaVendidasLocalidades;
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
		return boletasVendidasUsuarios;
	}
	
	public void setBoletaVendidasUsuarios(String boletaVendidasUsuarios) {
		this.boletasVendidasUsuarios = boletaVendidasUsuarios;
	}
	
	
	public String getIngresosUsuarios() {
		return ingresosUsuarios;
	}
	
	public void setIngresosUsuarios(String ingresosUsuarios) {
		this.ingresosUsuarios = ingresosUsuarios;
	}
	
}
