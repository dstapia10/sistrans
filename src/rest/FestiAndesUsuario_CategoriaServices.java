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
import vos.ListaUsuario_Categoria;
import vos.Usuario_Categoria;

@Path("usuarioCategoria")
public class FestiAndesUsuario_CategoriaServices {
	
	@Context
	private ServletContext context;
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
		
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// Usuario_Categoria ---------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUsuarioCategoria() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaUsuario_Categoria usuarioCategorias;
		try {
			usuarioCategorias = tm.darUsuarioCategoria();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(usuarioCategorias).build();
	}
		
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getUsuarioCategoriasCedula -----------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Path("/usuario/{cedula}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUsuarioCategoriasCedula(@javax.ws.rs.PathParam("cedula") int cedula) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaUsuario_Categoria usuarioCategorias;
		try {			
			usuarioCategorias = tm.buscarUsuarioCategoriaPorCedula(cedula);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(usuarioCategorias).build();
	}
		
	// --------------------------------------------------------------------------------------------------------------------------------------
	// addUsuarioCategoria ------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@POST
	@Path("/usuarioCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUsuarioCategoria(Usuario_Categoria usuarioCategoria) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addUsuarioCategoria(usuarioCategoria);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(usuarioCategoria).build();
	}

	// --------------------------------------------------------------------------------------------------------------------------------------
	// updateUsuarioCategoria ---------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@PUT
	@Path("/usuarioCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUsuarioCategoria(Usuario_Categoria usuarioCategoria) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateUsuarioCategoria(usuarioCategoria);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(usuarioCategoria).build();
	}

	// --------------------------------------------------------------------------------------------------------------------------------------
	// addActor -----------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
    @DELETE
	@Path("/usuarioCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUsuarioCategoria(Usuario_Categoria usuarioCategoria) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteUsuarioCategoria(usuarioCategoria);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(usuarioCategoria).build();
	}
    	
}
