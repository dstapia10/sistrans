package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class ConsultaCompa�ia {
	
	@JsonProperty(value="IDCOMPA�IA")
	private int idCompa�ia;

	@JsonProperty(value="IDFUNCION")
	private int idFuncion;

	@JsonProperty(value="GANANCIAPOSIBLE")
	private int gananciaPosible;

	@JsonProperty(value="GANANCIAREAL")
	private int gananciaReal;

	@JsonProperty(value="TOTALBOLETAS")
	private int totalBoletas;
	
	@JsonProperty(value="TOTALBOLETASVENDIDAS")
	private int totalBoletasVendidas;
	
	public ConsultaCompa�ia(@JsonProperty(value="IDCOMPA�IA")int idCompa�ia,
			@JsonProperty(value="IDFUNCION")int idFuncion,
			@JsonProperty(value="GANANCIAPOSIBLE")int gananciaPosible,
			@JsonProperty(value="GANANCIAREAL") int gananciaReal, 
			@JsonProperty(value="TOTALBOLETAS") int totalBoletas,
			@JsonProperty(value="TOTALBOLETASVENDIDAS") int totalBoletasVendidas) 
	{
		super();
		this.idCompa�ia = idCompa�ia;
		this.idFuncion = idFuncion;
		this.gananciaPosible = gananciaPosible;		
		this.gananciaReal = gananciaReal;
		this.totalBoletas = totalBoletas;
		this.totalBoletasVendidas = totalBoletasVendidas;
	}
	

	public int getIdCompa�ia() {
		return idCompa�ia;
	}
	
	public void setIdCompa�ia(int duration) {
		this.idCompa�ia = duration;
	}
	
	
	public int getIdFuncion() {
		return idFuncion;
	}
	
	public void setIdFuncion(int id) {
		this.idFuncion = id;
	}

	
	public int getGananciaPosiblea() {
		return gananciaPosible;
	}
		
	public void setGananciaPosible(int name) {
		this.gananciaPosible = name;
	}
	
		
	public int getGananciaReal() {
		return gananciaReal;
	}
		
	public void setGananciaReal(int name) {
		this.gananciaReal = name;
	}
	
	
	public int getTotalBoletas() {
		return totalBoletas;
	}
	
	public void setTotalBoletas(int name) {
		this.totalBoletas = name;
	}
	
	
	public int getTotalBoletasVendidas() {
		return totalBoletasVendidas;
	}
	
	public void setTotalBoletasVendidas(int name) {
		this.totalBoletasVendidas = name;
	}
	
}
