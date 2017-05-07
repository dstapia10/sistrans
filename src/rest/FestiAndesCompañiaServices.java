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
import vos.Compa�ia;
import vos.ListaCompa�ia;
import vos.ListaConsultaCompa�ia;

@Path("compa�ia")
public class FestiAndesCompa�iaServices {
	
	@Context
	private ServletContext context;
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
		
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getCompa�ia --------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCompa�ia() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaCompa�ia compa�ia;
		try {
			compa�ia = tm.darCompa�ias();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(compa�ia).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getCompa�iaName ----------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Path("/name/{name}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCompa�iaName(@javax.ws.rs.PathParam("name") String name) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaCompa�ia compa�ias;
		try {
			if (name == null || name.length() == 0) throw new Exception("Nombre del actor no valido");
			compa�ias = tm.buscarCompa�iaPorNombre(name);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(compa�ias).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// addCompa�ia --------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@POST
	@Path("/admin/compa�ia")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCompa�iaAdmin(Compa�ia compa�ia) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addCompa�ia(compa�ia);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(compa�ia).build();
	}
	
	@POST
	@Path("/cliente/compa�ia")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCompa�iaCliente(Compa�ia compa�ia) {
		return Response.status(500).entity("No puede editar la infomacion").build();
	}
	
	@POST
	@Path("/anonimo/compa�ia")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCompa�iaAnonimo(Compa�ia compa�ia) {
		return Response.status(500).entity("No puede editar la infomacion").build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// updateCompa�ia -----------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@PUT
	@Path("/compa�ia")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCompa�ia(Compa�ia compa�ia) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateCompa�ia(compa�ia);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(compa�ia).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// deleteCompa�ia -----------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
    @DELETE
	@Path("/compa�ia")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCompa�ia(Compa�ia compa�ia) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteCompa�ia(compa�ia);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(compa�ia).build();
	}
	
    // --------------------------------------------------------------------------------------------------------------------------------------
 	// ConsultaCompa�ia ---------------------------------------------------------------------------------------------------------------------
 	// --------------------------------------------------------------------------------------------------------------------------------------
    @GET
	@Path("/consComp/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getConsultaCompa�ia(@javax.ws.rs.PathParam("id") String id) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaConsultaCompa�ia consulta;
		try {
			if (id == null || id.length() == 0) throw new Exception("id no valido");
			consulta = tm.darConsultaCompa�ia(Integer.parseInt(id));
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(consulta).build();
	}
    
    // --------------------------------------------------------------------------------------------------------------------------------------
 	// llenarTablas ------------------------------------------------------------------------------------------------------------------------
 	// --------------------------------------------------------------------------------------------------------------------------------------
 	@GET
 	@Path("/llenar")
 	public Response llenarTabla() {
 		FestiAndesMaster tm = new FestiAndesMaster(getPath());
 		try {
 			tm.llenarTablaCompa�ia();
 		} 
 		catch (Exception e) {
 			return Response.status(500).entity(doErrorMessage(e)).build();
 		}
 		return Response.status(200).build();
 	}
    
}
