package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class ParametrosGetFunciones {
	
	@JsonProperty(value="DATE1")
	private Date date1;
	
	@JsonProperty(value="DATE2")
	private Date date2;

	@JsonProperty(value="Categoria")
	private String categoria;
	
	@JsonProperty(value="IDIOMA")
	private String idioma;
	
	@JsonProperty(value="OREDNADO")
	private Boolean ordenado;
	
	public ParametrosGetFunciones(@JsonProperty(value="DATE1") Date date1,
			@JsonProperty(value="DATE2") Date date2,
			@JsonProperty(value="Categoria") String categoria,
			@JsonProperty(value="IDIOMA") String idioma,
			@JsonProperty(value="OREDNADO") Boolean ordenado) {
		super();
		this.date1 = date1;
		this.date2 = date2;
		this.categoria = categoria;
		this.idioma = idioma;		
		this.ordenado = ordenado;
	}
	
	
	public Date getDate1() {
		return date1;
	}


	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	
	
	public Date getDate2() {
		return date2;
	}


	public void setDate2(Date date1) {
		this.date1 = date1;
	}
	
	
	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	public String getIdioma() {
		return idioma;
	}


	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public Boolean getOrdenado() {
		return ordenado;
	}


	public void setOrdenado(Boolean ordenado) {
		this.ordenado = ordenado;
	}
	
}
