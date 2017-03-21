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
import vos.Ciudad;
import vos.ListaCiudad;

@Path("ciudades")
public class FestiAndesCiudadServices {
	
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
	public Response getCiudades() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaCiudad ciudades;
		try {
			ciudades = tm.darCiudades();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(ciudades).build();
	}
	
	@GET
	@Path("/ciudades/{name}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCiudadName(@javax.ws.rs.PathParam("name") String name) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaCiudad ciudades;
		try {
			if (name == null || name.length() == 0) throw new Exception("Nombre del actor no valido");
			ciudades = tm.buscarCiudadPorNombre(name);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(ciudades).build();
	}
	
	@POST
	@Path("/ciudad")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCiudad(Ciudad ciudad) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addCiudad(ciudad);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(ciudad).build();
	}
	
	@PUT
	@Path("/ciudad")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCiudad(Ciudad ciudad) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateCiudad(ciudad);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(ciudad).build();
	}
	
    @DELETE
	@Path("/ciudad")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCiudad(Ciudad ciudad) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteCiudad(ciudad);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(ciudad).build();
	}

}
