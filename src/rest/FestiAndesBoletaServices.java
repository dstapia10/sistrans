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
		 
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getBoletas() {
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
		
	@POST
	@Path("/boleta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBoleta(Boleta boleta) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateBoleta(boleta);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boleta).build();
	}
	
	@PUT
	@Path("/boleta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBoleta(Boleta boleta) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addBoleta(boleta);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boleta).build();
	}
	
    @DELETE
	@Path("/boleta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteBoleta(Boleta boleta) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteBoleta(boleta);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boleta).build();
	}

}
