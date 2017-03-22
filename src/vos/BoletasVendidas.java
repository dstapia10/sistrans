package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class BoletasVendidas 
{

	@JsonProperty(value="IDCLIENTE")
	private int idCliente;


	@JsonProperty(value="IDBOLETA")
	private int idBoleta;


	

	
	public BoletasVendidas(@JsonProperty(value="IDCLIENTE")int idCliente,@JsonProperty(value="IDBOLETA")int idBoleta)
			
	{
		super();
		this.idCliente = idCliente;
		this.idBoleta = idBoleta;
		
	}
	

	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int duration) {
		this.idCliente = duration;
	}


	public int getIdBoleta() {
		return idBoleta;
	}

	
	public void setIdBoleta(int id) {
		this.idBoleta = id;
	}

	
	
}
