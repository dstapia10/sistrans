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
import vos.Actor;
import vos.ListaActores;
import vos.ListaRepresentante;
import vos.Representante;

@Path("representante")
public class FestiAndesRepresentanteServices {
	
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
	public Response getRepresentantes() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaRepresentante representantes;
		try {
			representantes = tm.darRepresentante();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(representantes).build();
	}
	
	@GET
	@Path("/cedula/{cedula}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getRepresentanteCedula(@javax.ws.rs.PathParam("cedula") int cedula) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaRepresentante representante;
		try {			
			representante = tm.buscarRepresentantePorCedula(cedula);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(representante).build();
	}
	
	@GET
	@Path("/nombre/{nombre}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getRepresentanteNombre(@javax.ws.rs.PathParam("nombre") String nombre) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaRepresentante representante;
		try {			
			representante = tm.buscarRepresentantePorNombre(nombre);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(representante).build();
	}
	
	@POST
	@Path("/representante")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addRepresentante(Representante representante) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateRepresentante(representante);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(representante).build();
	}
	
	@PUT
	@Path("/representante")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRepresentante(Representante representante) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addRepresentante(representante);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(representante).build();
	}
	
    @DELETE
	@Path("/representante")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRepresentante(Representante representante) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteRepresentante(representante);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(representante).build();
	}

}
