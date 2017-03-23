package rest;

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
import vos.FuncionRealizada;
import vos.ListaFuncionesRealizadas;

@Path("funcionesRealizadas")
public class FestiAndesFuncionRealizadaServices {
	
	@Context
	private ServletContext context;
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
		
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getFuncionesRealizadas ---------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getFuncionesRealizadas() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaFuncionesRealizadas funcionesRealizadas;
		try {
			funcionesRealizadas = tm.darFuncionesRealizadas();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionesRealizadas).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getFuncionRealizadaId ----------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Path("/id/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getFuncionRealizadaId(@javax.ws.rs.PathParam("id") int id) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaFuncionesRealizadas funcionesRealizadas;
		try {
			funcionesRealizadas = tm.buscarFuncionRealizadaPorId(id);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionesRealizadas).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// addFuncionRealizada ------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@POST
	@Path("/funcionRealizada")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFuncionRealizada(FuncionRealizada funcionRealizada) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addFuncionRealizada(funcionRealizada);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionRealizada).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// deleteFuncionRealizada ---------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@DELETE
	@Path("/funcionRealizada")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFuncionRealizada(FuncionRealizada funcionRealizada) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteFuncionRealizada(funcionRealizada);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionRealizada).build();
	}
	
}
