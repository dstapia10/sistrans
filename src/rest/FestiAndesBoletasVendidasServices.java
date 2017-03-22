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
import vos.BoletasVendidas;
import vos.ListaBoletasVendidas;

@Path("boletasVendidas")
public class FestiAndesBoletasVendidasServices {
	
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
	public Response getBoletasVendidasClientes() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaBoletasVendidas boletasVendidas;
		try {
			boletasVendidas = tm.darBoletasVendidas();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boletasVendidas).build();
	}
	
	@GET
	@Path("/idBoleta/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getBoletasVendidasIdBoleta(@javax.ws.rs.PathParam("id") int id) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaBoletasVendidas boletasVendidas;
		try {
			boletasVendidas = tm.buscarBoletasVendidasPorIdBoleta(id);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boletasVendidas).build();
	}
	
	@GET
	@Path("/idCliente/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getBoletasVendidasIdCliente(@javax.ws.rs.PathParam("id") int id) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaBoletasVendidas boletasVendidas;
		try {
			boletasVendidas = tm.buscarBoletasVendidasPorIdCliente(id);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boletasVendidas).build();
	}
	
	@POST
	@Path("/boletaVendida")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBoletaVendida(BoletasVendidas boletaVendida) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addBoletaVendida(boletaVendida);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boletaVendida).build();
	}
		
	@PUT
	@Path("/boletaVendida")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBoletaVendida(BoletasVendidas boletaVendida) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateBoletaVendida(boletaVendida);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boletaVendida).build();
	}
	
    @DELETE
	@Path("/boletaVendida")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteBoletaVendida(BoletasVendidas boletaVendida) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteBoletaVendida(boletaVendida);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boletaVendida).build();
	}
	
}
