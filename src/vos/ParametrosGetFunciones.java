package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class ParametrosGetFunciones {
	
	@JsonProperty(value="ID")
	private int date1;

	@JsonProperty(value="FECHA")
	private Date categoria;
	
	@JsonProperty(value="TEATRO")
	private String idioma;
	
	@JsonProperty(value="OBRA")
	private String ordenado;
	
	public ParametrosGetFunciones(@JsonProperty(value="ID") int date1,
			@JsonProperty(value="FECHA") Date categoria,
			@JsonProperty(value="TEATRO") String idioma,
			@JsonProperty(value="OBRA") String ordenado) {
		super();
		this.date1 = date1;
		
		this.categoria = categoria;
		this.idioma = idioma;		
		this.ordenado = ordenado;
	}
	
	
	public int getDate1() {
		return date1;
	}


	public void setDate1(int date1) {
		this.date1 = date1;
	}
	
	
	
	public Date getCategoria() {
		return categoria;
	}


	public void setCategoria(Date categoria) {
		this.categoria = categoria;
	}
	
	
	public String getIdioma() {
		return idioma;
	}


	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public String getOrdenado() {
		return ordenado;
	}


	public void setOrdenado(String ordenado) {
		this.ordenado = ordenado;
	}
	
}
