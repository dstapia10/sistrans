package rest;

import java.sql.Date;

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
import vos.Categoria;
import vos.Funcion;
import vos.ListaFuncion;
import vos.ParametrosGetFunciones;
import vos.ReporteFuncion;

@Path("funciones")
public class FestiAndesFuncionesServices {
	
	@Context
	private ServletContext context;
	
	private String getPath() {
		System.out.println("entra a getPath");
		return context.getRealPath("WEB-INF/ConnectionData");
	}
		
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getFunciones -------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Path("/funcion")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getFunciones(ParametrosGetFunciones param) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaFuncion funciones;
		try {
			funciones = tm.darFunciones(param);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funciones).build();
	}
	
	@GET
	@Path("/funcionn/{date1}7{date2}/{categoria}/{idioma}/{orden}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getFunciones(@javax.ws.rs.PathParam("date1") Date d1,
			@javax.ws.rs.PathParam("date2") Date d2, 
			@javax.ws.rs.PathParam("categoria") String c,
			@javax.ws.rs.PathParam("idioma") String i,
			@javax.ws.rs.PathParam("orden") Boolean o) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaFuncion funciones;
		try {
			ParametrosGetFunciones param = new ParametrosGetFunciones(d1, d2, c, i, o);
			funciones = tm.darFunciones(param);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funciones).build();
	}

	

	
//	@GET
//	@Path("/categoria/{categoria}")
//	@Produces({ MediaType.APPLICATION_JSON })
//	public Response getFuncionCategoria(@javax.ws.rs.PathParam("categoria") String categoria) {
//		FestiAndesMaster tm = new FestiAndesMaster(getPath());
//		ListaFuncion funciones;
//		try {
//			if (categoria == null || categoria.length() == 0) throw new Exception("Categoria no valido");
//			funciones = tm.buscarFuncnionPorCategoria(categoria);
//		} 
//		catch (Exception e) {
//			return Response.status(500).entity(doErrorMessage(e)).build();
//		}
//		return Response.status(200).entity(funciones).build();
//	}
//	
//	@GET
//	@Path("/teatro/{teatro}")
//	@Produces({ MediaType.APPLICATION_JSON })
//	public Response getFuncionTeatro(@javax.ws.rs.PathParam("teatro") String teatro) {
//		FestiAndesMaster tm = new FestiAndesMaster(getPath());
//		ListaFuncion funciones;
//		try {
//			if (teatro == null || teatro.length() == 0) throw new Exception("Nombre del teatro no valido");
//			funciones = tm.buscarFuncionPorTeatro(teatro);
//		} 
//		catch (Exception e) {
//			return Response.status(500).entity(doErrorMessage(e)).build();
//		}
//		return Response.status(200).entity(funciones).build();
//	}
//	
//	@GET
//	@Path("/id/{id}")
//	@Produces({ MediaType.APPLICATION_JSON })
//	public Response getFuncionId(@javax.ws.rs.PathParam("id") int id) {
//		FestiAndesMaster tm = new FestiAndesMaster(getPath());
//		ListaFuncion funciones;
//		try {
//			funciones = tm.buscarFuncionPorId(id);
//		} 
//		catch (Exception e) {
//			return Response.status(500).entity(doErrorMessage(e)).build();
//		}
//		return Response.status(200).entity(funciones).build();
//	}
	
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// addFuncion ---------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@POST
	@Path("/admin/funcion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFuncionAdmin(Funcion funcion) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addFuncion(funcion);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcion).build();
	}
	
	@POST
	@Path("/cliente/funcion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFuncionCliente(Funcion funcion) {
		return Response.status(500).entity("No puede editar la infomacion").build();
	}
	
	@POST
	@Path("/anonimo/funcion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFuncionAnonimo(Funcion funcion) {
		return Response.status(500).entity("No puede editar la infomacion").build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// updateFuncion ------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@PUT
	@Path("/funcion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateFuncion(Funcion funcion) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateFuncion(funcion);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcion).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// deleteFuncion ------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
    @DELETE
	@Path("/funcion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFuncion(Funcion funcion) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteFuncion(funcion);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcion).build();
	}	
    
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getReporteFuncionId ------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
    @GET
	@Path("/reporte/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getReporteFuncionId(@javax.ws.rs.PathParam("id") int id) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ReporteFuncion reporteFuncion;
		try {
			reporteFuncion = tm.darReporteFuncion(id);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(reporteFuncion).build();
	}
    
}
