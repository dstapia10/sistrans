package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class NotaDebito {

	@JsonProperty(value="id_cliente")
	 private int id_cliente;
	@JsonProperty(value="numero_boleta")
	 private int numero_boleta;
	@JsonProperty(value="fecha")
	 private String fecha;
	@JsonProperty(value="valor")
	private int valor;
	
	public NotaDebito(@JsonProperty(value="id_cliente")int id, @JsonProperty(value="numero_boleta")int bnum,@JsonProperty(value="fecha")String fecha, @JsonProperty(value="valor")int  valor){
		super();
		this.id_cliente = id;
		this.numero_boleta = bnum;
		this.fecha = fecha;			
		this.valor = valor;

	}

}
