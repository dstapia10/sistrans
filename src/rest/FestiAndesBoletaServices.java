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
import vos.Boleta;
import vos.ListaBoletas;

@Path("boleta")
public class FestiAndesBoletaServices {
	
	@Context
	private ServletContext context;
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
		
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getBoletas ---------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Path("/administrador")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getBoletasAdministrador() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaBoletas boletas;
		try {
			boletas = tm.darBoletas();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boletas).build();
	}
	
	@GET
	@Path("/cliente")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getBoletasCliente() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaBoletas boletas;
		try {
			boletas = tm.darBoletas();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boletas).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// addBoleta ----------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@POST
	@Path("/administrador/boleta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBoletaAdministrador(Boleta boleta) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateBoleta(boleta);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boleta).build();
	}
	
	@POST
	@Path("/cliente/boleta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBoletaCliente(Boleta boleta) {
		return Response.status(500).entity("No puede agregar la infomacion").build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// updateBoleta -------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@PUT
	@Path("/administrador/boleta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBoletaAdministrador(Boleta boleta) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addBoleta(boleta);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boleta).build();
	}
	
	@PUT
	@Path("/cliente/boleta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBoletaCliente(Boleta boleta) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addBoleta(boleta);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boleta).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// deleteBoleta -------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
    @DELETE
	@Path("/administrador/boleta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteBoletaAdministrador(Boleta boleta) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteBoleta(boleta);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boleta).build();
	}
    
    @DELETE
   	@Path("/cliente/boleta")
   	@Consumes(MediaType.APPLICATION_JSON)
   	@Produces(MediaType.APPLICATION_JSON)
   	public Response deleteBoletaCliente(Boleta boleta) {
    	return Response.status(500).entity("No puede borrar la infomacion").build();
   	}

}
