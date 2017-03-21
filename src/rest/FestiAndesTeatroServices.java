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
import vos.ListaTeatro;
import vos.Teatro;

@Path("teatros")
public class FestiAndesTeatroServices {
	
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
	public Response getTeatros() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaTeatro teatros;
		try {
			teatros = tm.darTeatros();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(teatros).build();
	}
	
	@GET
	@Path("/name/{name}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTeatroName(@javax.ws.rs.PathParam("name") String name) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaTeatro teatros;
		try {
			if (name == null || name.length() == 0) throw new Exception("Nombre del teatro no valido");
			teatros = tm.buscarTeatroPorNombre(name);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(teatros).build();
	}
	
	@POST
	@Path("/teatro")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addTeatro(Teatro teatro) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addTeatro(teatro);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(teatro).build();
	}
	
	@PUT
	@Path("/teatro")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateTeatro(Teatro teatro) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateTeatro(teatro);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(teatro).build();
	}
	
    @DELETE
	@Path("/teatro")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteTeatro(Teatro teatro) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteTeatro(teatro);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(teatro).build();
	}	

}
