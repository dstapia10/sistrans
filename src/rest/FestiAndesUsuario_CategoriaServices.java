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
import vos.Actor;
import vos.ListaActores;
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
	@Path("/administrador")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUsuarioCategoriaAdministrador() {
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
	
	@GET
	@Path("/cliente")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUsuarioCategoriaCliente() {		
		return Response.status(500).entity("No puede ver la infomacion").build();		
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getUsuarioCategoriasCedula -----------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Path("/administrador/usuarioCategoria/{cedula}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUsuarioCategoriasCedulaAdministrador(@javax.ws.rs.PathParam("cedula") int cedula) {
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
	
	@GET
	@Path("/cliente/usuarioCategoria/{cedula}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUsuarioCategoriasCedulaCliente(@javax.ws.rs.PathParam("cedula") int cedula) {
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
	@Path("/administrador/usuarioCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUsuarioCategoriaAdministrador(Usuario_Categoria usuarioCategoria) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateUsuarioCategoria(usuarioCategoria);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(usuarioCategoria).build();
	}
	
	@POST
	@Path("/cliente/usuarioCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addusuarioCategoriaCliente(Usuario_Categoria usuarioCategoria) {
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
	// updateUsuarioCategoria ---------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@PUT
	@Path("/administrador/usuarioCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUsuarioCategoriaAdministrador(Usuario_Categoria usuarioCategoria) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addUsuarioCategoria(usuarioCategoria);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(usuarioCategoria).build();
	}
	
	@PUT
	@Path("/cliente/usuarioCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUsuarioCategoriaCliente(Usuario_Categoria usuarioCategoria) {
		return Response.status(500).entity("No puede editar la infomacion").build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// addActor -----------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
    @DELETE
	@Path("/administrador/usuarioCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUsuarioCategoriaAdministrador(Usuario_Categoria usuarioCategoria) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteUsuarioCategoria(usuarioCategoria);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(usuarioCategoria).build();
	}
    
    @DELETE
	@Path("/ciente/usuarioCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUsuarioCategoriaCliente(Usuario_Categoria actor) {
    	return Response.status(500).entity("No puede borrar la infomacion").build();
	}
	
}
