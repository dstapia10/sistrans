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
	public Response getFunciones(Date f, Date f2, Categoria  categoria ,String  idioma, Boolean orden) {
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
	

	
//	@GET
//	@Path("/categoria/{categoria}")
//	@Produces({ MediaType.APPLICATION_JSON })
//	public Response getFuncionCategoria(@javax.ws.rs.PathParam("categoria") String categoria) {
//		FestiAndesMaster tm = new FestiAndesMaster(getPath());
//		ListaFuncion funciones;
//		try {
//			if (categoria == null || categoria.length() == 0) throw new Exception("Categoria no valido");
//			funciones = tm.buscarFuncnionPorCategoria(categoria);
//		} 
//		catch (Exception e) {
//			return Response.status(500).entity(doErrorMessage(e)).build();
//		}
//		return Response.status(200).entity(funciones).build();
//	}
//	
//	@GET
//	@Path("/teatro/{teatro}")
//	@Produces({ MediaType.APPLICATION_JSON })
//	public Response getFuncionTeatro(@javax.ws.rs.PathParam("teatro") String teatro) {
//		FestiAndesMaster tm = new FestiAndesMaster(getPath());
//		ListaFuncion funciones;
//		try {
//			if (teatro == null || teatro.length() == 0) throw new Exception("Nombre del teatro no valido");
//			funciones = tm.buscarFuncionPorTeatro(teatro);
//		} 
//		catch (Exception e) {
//			return Response.status(500).entity(doErrorMessage(e)).build();
//		}
//		return Response.status(200).entity(funciones).build();
//	}
//	
//	@GET
//	@Path("/id/{id}")
//	@Produces({ MediaType.APPLICATION_JSON })
//	public Response getFuncionId(@javax.ws.rs.PathParam("id") int id) {
//		FestiAndesMaster tm = new FestiAndesMaster(getPath());
//		ListaFuncion funciones;
//		try {
//			funciones = tm.buscarFuncionPorId(id);
//		} 
//		catch (Exception e) {
//			return Response.status(500).entity(doErrorMessage(e)).build();
//		}
//		return Response.status(200).entity(funciones).build();
//	}
	
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
	@Path("/funcion")
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
