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
import vos.Categoria;
import vos.ListaCategoria;

@Path("categoria")
public class FestiAndesCategoriaServices {
	
	@Context
	private ServletContext context;
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
		
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getCategorias ------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCategorias() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaCategoria categorias;
		try {
			categorias = tm.darCategorias();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(categorias).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getCategoriaName ---------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Path("/name/{name}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCategoriaName(@javax.ws.rs.PathParam("name") String name) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaCategoria categorias;
		try {
			if (name == null || name.length() == 0) throw new Exception("Nombre de la categroia no valido");
			categorias = tm.buscarCategoriaPorNombre(name);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(categorias).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// addCategoria -------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@POST
	@Path("/categoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCategoria(Categoria categoria) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addCategoria(categoria);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(categoria).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// updateCategoria ----------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@PUT
	@Path("/categoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCategoria(Categoria categoria) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateCategoria(categoria);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(categoria).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// deleteCategoria ----------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
    @DELETE
	@Path("/categoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCategoria(Categoria categoria) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteCategoria(categoria);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(categoria).build();
	}

}
