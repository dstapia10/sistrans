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
import vos.ListaObra;
import vos.Obra;
import vos.ReporteObra;

@Path("obras")
public class FestiAndesObraServices {
	
	@Context
	private ServletContext context;
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
		
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getObras -----------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getObras() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaObra obras;
		try {
			obras = tm.darObras();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(obras).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getObrasName -------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Path("/obras/{name}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getObrasName(@javax.ws.rs.PathParam("name") String name) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaObra obras;
		try {
			if (name == null || name.length() == 0) throw new Exception("Nombre de la obra no valido");
			obras = tm.buscarObraPorNombre(name);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(obras).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getObrasId ---------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Path("/obras/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getObrasId(@javax.ws.rs.PathParam("id") int id) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaObra obras;
		try {
			obras = tm.buscarObraPorId(id);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(obras).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// addObra ------------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@POST
	@Path("/admin/obra")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addObraAdmin(Obra obra) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addObra(obra);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(obra).build();
	}
	
	@POST
	@Path("/cliente/obra")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addObraCliente(Obra obra) {
		return Response.status(500).entity("No puede editar la infomacion").build();
	}
	
	@POST
	@Path("/anonimo/obra")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addObraAnonimo(Obra obra) {
		return Response.status(500).entity("No puede editar la infomacion").build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// updateObra ---------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@PUT
	@Path("/obra")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateObra(Obra obra) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateObra(obra);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(obra).build();
	}
	 
	// --------------------------------------------------------------------------------------------------------------------------------------
	// deleteObra ---------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@DELETE
	@Path("/obra")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteObra(Obra obra) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteObra(obra);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(obra).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getReporteObraId ---------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Path("/reporte/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getReporteObraId(@javax.ws.rs.PathParam("id") int id) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ReporteObra reporteObra;
		try {
			reporteObra = tm.darReporteObra(id);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(reporteObra).build();
	}

}
