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
import vos.ListaObras_Categorias;
import vos.Obra_Categoria;

@Path("obraCategoria")
public class FestiAndesObra_CategoriaServices {
	
	@Context
	private ServletContext context;
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
		
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getObrasCategorias -------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getObrasCategorias() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaObras_Categorias obrasCategorias;
		try {
			obrasCategorias = tm.darObrasCategorias();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(obrasCategorias).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getObrasCategoriasIdCategoria --------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Path("/idCategoria/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getObrasCategoriasIdCategoria(@javax.ws.rs.PathParam("id") int id) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaObras_Categorias obrasCategorias;
		try {
			obrasCategorias = tm.buscarObrasCategoriasPorIdCategoria(id);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(obrasCategorias).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getObrasCategoriasIdObra -------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Path("/idObra/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getObrasCategoriasIdObra(@javax.ws.rs.PathParam("id") int id) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaObras_Categorias obrasCategorias;
		try {
			obrasCategorias = tm.buscarObrasCategoriasPorIdObra(id);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(obrasCategorias).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// addObraCategoria ---------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@POST
	@Path("/obraCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addObraCategoria(Obra_Categoria obraCategoria) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addObraCategoria(obraCategoria);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(obraCategoria).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// updateObraCategoria ------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@PUT
	@Path("/obraCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateObraCategoria(Obra_Categoria obraCategoria) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateObraCategoria(obraCategoria);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(obraCategoria).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// deleteObraCategoria ------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
    @DELETE
	@Path("/obraCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteObraCategoria(Obra_Categoria obraCategoria) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteObraCategoria(obraCategoria);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(obraCategoria).build();
	}
	
}
