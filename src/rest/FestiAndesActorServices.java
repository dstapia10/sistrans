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

@Path("actor")
public class FestiAndesActorServices {
	
	@Context
	private ServletContext context;
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
		
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getActores ---------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Path("/administrador")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getActoresAdministrador() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaActores actores;
		try {
			actores = tm.darActores();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(actores).build();
	}
	
	@GET
	@Path("/cliente")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getActoresCliente() {		
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaActores actores;
		try {
			actores = tm.darActores();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(actores).build();		
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getActorName -------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Path("/administrador/actor/{cedula}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getActorNameAdministrador(@javax.ws.rs.PathParam("cedula") int cedula) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaActores actores;
		try {
			
			actores = tm.buscarActorPorNombre(cedula);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(actores).build();
	}
	
	@GET
	@Path("/cliente/actor/{cedula}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getActorNameCliente(@javax.ws.rs.PathParam("cedula") int cedula) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaActores actores;
		try {
			
			actores = tm.buscarActorPorNombre(cedula);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(actores).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// addActor -----------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@POST
	@Path("/administrador/actor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addActorAdministrador(Actor actor) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateActor(actor);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(actor).build();
	}
	
	@POST
	@Path("/cliente/actor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addActorCliente(Actor actor) {
		return Response.status(500).entity("No puede agregar la infomacion").build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// updateActor -----------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@PUT
	@Path("/administrador/actor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateActorAdministrador(Actor actor) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addActor(actor);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(actor).build();
	}
	
	@PUT
	@Path("/cliente/actor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateActorCliente(Actor actor) {
		return Response.status(500).entity("No puede editar la infomacion").build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// addActor -----------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
    @DELETE
	@Path("/administrador/actor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFuncionAdministrador(Actor actor) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteActor(actor);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(actor).build();
	}
    
    @DELETE
	@Path("/ciente/actor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFuncionCliente(Actor actor) {
    	return Response.status(500).entity("No puede borrar la infomacion").build();
	}
	
}
