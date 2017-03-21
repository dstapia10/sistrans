package rest;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.FestiAndesMaster;
import vos.Categoria;
import vos.Funcion;
import vos.ListaFuncion;

@Path("funciones")
public class FestiAndesFuncionesServices {
	
	@Context
	private ServletContext context;
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
		
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getFunciones(Date f, Date f2, Categoria  categoria ,String  idioma, Boolean orden, String trad) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaFuncion funciones;
		try {
			funciones = tm.darFunciones(f, f2, categoria, idioma, orden);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funciones).build();
	}
	

	
	
	
	@POST
	@Path("/funcion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFuncion(Funcion funcion) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addFuncion(funcion);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcion).build();
	}
	
	@PUT
	@Path("/funcion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateFuncion(Funcion funcion) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateFuncion(funcion);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcion).build();
	}
	
    @DELETE
	@Path("/actor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFuncion(Funcion funcion) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteFuncion(funcion);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcion).build();
	}	

}
