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
import vos.Abono;
import vos.ListaAbono;

@Path("abonos")
public class FestiAndesAbonoServices {
	
	@Context
	private ServletContext context;
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
		
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getAbono -----------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getActores() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaAbono abono;
		try {
			abono = tm.darAbonos();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(abono).build();
	}
		
	// --------------------------------------------------------------------------------------------------------------------------------------
	// addAbono -----------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@POST
	@Path("/abono")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addActor(Abono abono) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addAbono(abono);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(abono).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// updateAbono --------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@PUT
	@Path("/abono")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateActor(Abono abono) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateAbono(abono);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(abono).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// deleteFuncion ------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@DELETE
	@Path("/abono")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFuncion(Abono abono) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteAbono(abono);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(abono).build();
	}
	
}
