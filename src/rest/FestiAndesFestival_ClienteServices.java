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
import vos.Festival_Cliente;
import vos.ListaFestivales_Clientes;

@Path("festivalCliente")
public class FestiAndesFestival_ClienteServices {
	
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
	public Response getFestivalesClientes() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaFestivales_Clientes festivalesClientes;
		try {
			festivalesClientes = tm.darFestivalClientes();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(festivalesClientes).build();
	}
	
	@GET
	@Path("/cedula/{cedula}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getfestivalClienteCedula(@javax.ws.rs.PathParam("cedula") int cedula) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaFestivales_Clientes festivalesClientes;
		try {
			festivalesClientes = tm.buscarFestivalClientePorCedula(cedula);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(festivalesClientes).build();
	}
	
	@GET
	@Path("/idFestival/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getfestivalClienteIdFestival(@javax.ws.rs.PathParam("id") int id) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaFestivales_Clientes festivalesClientes;
		try {
			festivalesClientes = tm.buscarFestivalClientePorIdFestival(id);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(festivalesClientes).build();
	}
	
	@POST
	@Path("/festivalCliente")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addfestivalCliente(Festival_Cliente festivalCliente) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addFestivalCliente(festivalCliente);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(festivalCliente).build();
	}
	
	@PUT
	@Path("/festivalCliente")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCiudad(Festival_Cliente festivalCliente) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateFestivalCliente(festivalCliente);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(festivalCliente).build();
	}
	
    @DELETE
	@Path("/festivalCliente")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCiudad(Festival_Cliente festivalCliente) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteFestivalCliente(festivalCliente);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(festivalCliente).build();
	}
        
}
