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
		 
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getActores() {
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
	@Path("/actor/{cedula}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getActorName(@javax.ws.rs.PathParam("cedula") int cedula) {
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
	
	@POST
	@Path("/actor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addActor(Actor actor) {
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
	@Path("/actor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateActor(Actor actor) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateActor(actor);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(actor).build();
	}
	
    @DELETE
	@Path("/actor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFuncion(Actor actor) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteActor(actor);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(actor).build();
	}
	
}
