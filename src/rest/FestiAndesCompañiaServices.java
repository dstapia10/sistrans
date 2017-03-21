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
import vos.Compañia;
import vos.ListaCompañia;

@Path("compañia")
public class FestiAndesCompañiaServices {
	
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
	public Response getCompañia() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaCompañia compañia;
		try {
			compañia = tm.darCompañias();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(compañia).build();
	}
	
	@GET
	@Path("/name/{name}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCompañiaName(@javax.ws.rs.PathParam("name") String name) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaCompañia compañias;
		try {
			if (name == null || name.length() == 0) throw new Exception("Nombre del actor no valido");
			compañias = tm.buscarCompañiaPorNombre(name);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(compañias).build();
	}
	
	@POST
	@Path("/compañia")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCompañia(Compañia compañia) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addCompañia(compañia);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(compañia).build();
	}
	
	@PUT
	@Path("/compañia")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCompañia(Compañia compañia) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateCompañia(compañia);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(compañia).build();
	}
	
    @DELETE
	@Path("/compañia")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFuncion(Compañia compañia) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteCompañia(compañia);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(compañia).build();
	}
	
}
