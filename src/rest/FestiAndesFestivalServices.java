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
import vos.Festival;
import vos.ListaConsultaBoletasFuncion;
import vos.ListaConsultarAsistenciaCliente;
import vos.ListaFestivales;
import vos.ListaUsuario;

@Path("festival")
public class FestiAndesFestivalServices {
	
	@Context
	private ServletContext context;
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
		
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getFestivales ------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getFestivales() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaFestivales festivales;
		try {
			festivales = tm.darFestivales();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(festivales).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getFestivalName ----------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Path("/name/{name}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getFestivalName(@javax.ws.rs.PathParam("name") String name) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaFestivales festivales;
		try {
			
			festivales = tm.buscarFestivalPorNombre(name);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(festivales).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// addFestival --------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@POST
	@Path("/festival")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFestival(Festival festival) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addFestival(festival);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(festival).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// updateFestival -----------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@PUT
	@Path("/festival")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateFestival(Festival festival) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateFestival(festival);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(festival).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// addFunciondeleteFuncion --------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
    @DELETE
	@Path("/festival")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFuncion(Festival festival) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteFestival(festival);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(festival).build();
	}
    
    // --------------------------------------------------------------------------------------------------------------------------------------
	// ConsultarAsistenciaCliente -----------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
    @GET
	@Path("/consAsist/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getConsultarAsistenciaCliente(@javax.ws.rs.PathParam("id") String id) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaConsultarAsistenciaCliente cac;
		try {
			
			cac = tm.darConsultarAsistenciaCliente(Integer.parseInt(id));
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(cac).build();
	}
    
    // --------------------------------------------------------------------------------------------------------------------------------------
   	// ConsultarAsistencia9 -----------------------------------------------------------------------------------------------------------
   	// --------------------------------------------------------------------------------------------------------------------------------------
    @GET
   	@Path("/consAsist9/{id}/{ini}/{fin}/{ordenamiento}/{agrupar}")
   	@Produces({ MediaType.APPLICATION_JSON })
   	public Response getConsultarAsistencia9(@javax.ws.rs.PathParam("id") String id, @javax.ws.rs.PathParam("ini") String ini, 
   			@javax.ws.rs.PathParam("fin") String fin, @javax.ws.rs.PathParam("ordenamiento") String orden , @javax.ws.rs.PathParam("agrupar") String agrupar) {
   		FestiAndesMaster tm = new FestiAndesMaster(getPath());
   		ListaUsuario ca9;
   		try {
   			
   			ca9 = tm.darConsultarAsistencia9(id, ini, fin, orden, agrupar);
   		} 
   		catch (Exception e) {
   			return Response.status(500).entity(doErrorMessage(e)).build();
   		}
   		return Response.status(200).entity(ca9).build();
   	}
    
    // --------------------------------------------------------------------------------------------------------------------------------------
   	// ConsultarAsistencia10 -----------------------------------------------------------------------------------------------------------
   	// --------------------------------------------------------------------------------------------------------------------------------------
    @GET
   	@Path("/consAsist10/{id}/{ini}/{fin}/{ordenamiento}/{agrupar}")
   	@Produces({ MediaType.APPLICATION_JSON })
   	public Response getConsultarAsistencia10(@javax.ws.rs.PathParam("id") String id,
   			@javax.ws.rs.PathParam("ini") String ini, @javax.ws.rs.PathParam("fin") String fin,
   			@javax.ws.rs.PathParam("ordenamiento") String orden, @javax.ws.rs.PathParam("agrupar") String agrupar) {
   		FestiAndesMaster tm = new FestiAndesMaster(getPath());
   		ListaUsuario ca10;
   		try {
   			
   			ca10 = tm.darConsultarAsistencia10(id, ini, fin, orden, agrupar);
   		} 
   		catch (Exception e) {
   			return Response.status(500).entity(doErrorMessage(e)).build();
   		}
   		return Response.status(200).entity(ca10).build();
   	}
 	
    
    // --------------------------------------------------------------------------------------------------------------------------------------
   	// ConsultaBoletasFuncion -----------------------------------------------------------------------------------------------------------
   	// --------------------------------------------------------------------------------------------------------------------------------------
    @GET
   	@Path("/consBolFun/{letraFila}/{ini}/{fin}")
   	@Produces({ MediaType.APPLICATION_JSON })
   	public Response getConsultaBoletasFuncion(@javax.ws.rs.PathParam("letraFila") String letraFila, @javax.ws.rs.PathParam("ini") String ini, @javax.ws.rs.PathParam("fin") String fin) {
   		FestiAndesMaster tm = new FestiAndesMaster(getPath());
   		ListaConsultaBoletasFuncion cbf;
   		try {
   			
   			
   			
   			cbf = tm.darConsultaBoletasFuncion(letraFila, ini, fin);
   		} 
   		catch (Exception e) {
   			return Response.status(500).entity(doErrorMessage(e)).build();
   		}
   		return Response.status(200).entity(cbf).build();
   	}
 	
    
    // --------------------------------------------------------------------------------------------------------------------------------------
   	// ConsultaBuenosClientes -----------------------------------------------------------------------------------------------------------
   	// --------------------------------------------------------------------------------------------------------------------------------------
    @GET
   	@Path("/consBuenCliente/{nBoletas}")
   	@Produces({ MediaType.APPLICATION_JSON })
   	public Response getConsultaBoletasFuncion(@javax.ws.rs.PathParam("nBoletas") String nBoletas) {
   		FestiAndesMaster tm = new FestiAndesMaster(getPath());
   		ListaUsuario cbc;
   		try {
   			cbc = tm.darConsultarBuenosClientes(Integer.parseInt(nBoletas));
   		} 
   		catch (Exception e) {
   			return Response.status(500).entity(doErrorMessage(e)).build();
   		}
   		return Response.status(200).entity(cbc).build();
   	}
	
}
