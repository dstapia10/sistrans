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
import vos.Boleta;
import vos.BoletasVendidas;
import vos.ListaBoletas;
import vos.ListaBoletasVendidas;

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
		
	// --------------------------------------------------------------------------------------------------------------------------------------
	// addBoleta ----------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@POST
	@Path("/admin/boleta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBoletaAdmin(Boleta boleta) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addBoleta(boleta);
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
	
	@POST
	@Path("/anonimo/boleta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBoletaAnonimo(Boleta boleta) {
		return Response.status(500).entity("No puede agregar la infomacion").build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// updateBoleta -------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@PUT
	@Path("/admin/boleta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBoletaAdmin(Boleta boleta) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.devolverBoleta(boleta);
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
		try{
			tm.devolverBoleta(boleta);
		}
		catch(Exception e)
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boleta).build();
	}
	
	@PUT
	@Path("/anonimo/boleta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBoletaAnonimo(Boleta boleta) {
		return Response.status(500).entity("No puede editar la infomacion").build();
	}
	
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// otrosServciosBoletaVendida ------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@PUT
	@Path("/boleta/vender")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response venderBoleta(BoletasVendidas boletaVendida) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.venderBoleta(boletaVendida);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boletaVendida).build();
	}
	
	@PUT
	@Path("/boleta/venderVarias")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response venderVariasBoleta(ListaBoletasVendidas boletasVendidas) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.venderVariasBoleta(boletasVendidas);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boletasVendidas).build();
	}
	
	@PUT
	@Path("/boleta/devolver")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response devolverBoleta(Boleta boletasVendidas) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.devolverBoleta(boletasVendidas);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boletasVendidas).build();
	}
		
	@PUT
	@Path("/abono/vender")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response venderAbono(Abono abono) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.venderAbono(abono);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(abono).build();
	}
	
	@PUT
	@Path("/abono/devolver")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response devolverAbono(Abono abono) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.devolverAbono(abono);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(abono).build();
	}
	
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// deleteBoleta -------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
    @DELETE
	@Path("/admin/boleta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteBoletaAdmin(Boleta boleta) {
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
    
    @DELETE
   	@Path("/anonimo/boleta")
   	@Consumes(MediaType.APPLICATION_JSON)
   	@Produces(MediaType.APPLICATION_JSON)
   	public Response deleteBoletaAnonimo(Boleta boleta) {
    	return Response.status(500).entity("No puede borrar la infomacion").build();
   	}
    
    // --------------------------------------------------------------------------------------------------------------------------------------
 	// llenarTablas ------------------------------------------------------------------------------------------------------------------------
 	// --------------------------------------------------------------------------------------------------------------------------------------
 	@GET
 	@Path("/llenar")
 	public Response llenarTabla() {
 		FestiAndesMaster tm = new FestiAndesMaster(getPath());
 		try {
 			tm.llenarTablaBoleta();
 		} 
 		catch (Exception e) {
 			return Response.status(500).entity(doErrorMessage(e)).build();
 		}
 		return Response.status(200).build();
 	}

}
