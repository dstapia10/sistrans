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
import vos.Funcion;
import vos.ListaUsuario;
import vos.Usuario;

@Path("usuario")
public class FestiAndesUsuarioServices {
	
	@Context
	private ServletContext context;
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
		
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// getUsuarios --------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUsuarios() {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		ListaUsuario usuarios;
		try {
			usuarios = tm.darUsuarios();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(usuarios).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// addUsuario ---------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@POST
	@Path("/admin/usuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUsuarioAdmin(Usuario usuario) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.addUsuario(usuario);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(usuario).build();
	}
	
	@POST
	@Path("/cliente/usuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUsuarioCliente(Usuario usuuario) {
		return Response.status(500).entity("No puede agregar la infomacion").build();
	}
	
	@POST
	@Path("/anonimo/usuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUsuarioAnonimo(Usuario usuuario) {
		return Response.status(500).entity("No puede agregar la infomacion").build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// updateUsuario ------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
	@PUT
	@Path("/usuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUsuario(Usuario usuario) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.updateUsuario(usuario);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(usuario).build();
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	// deleteUsuario ------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------
    @DELETE
	@Path("/usuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUsuario(Usuario usuario) {
		FestiAndesMaster tm = new FestiAndesMaster(getPath());
		try {
			tm.deleteUsuario(usuario);
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(usuario).build();
	}
    
    // --------------------------------------------------------------------------------------------------------------------------------------
 	// llenarTablas ------------------------------------------------------------------------------------------------------------------------
 	// --------------------------------------------------------------------------------------------------------------------------------------
 	@GET
 	@Path("/llenar")
 	public Response llenarTabla() {
 		FestiAndesMaster tm = new FestiAndesMaster(getPath());
 		try {
 			tm.llenarTablaUsuarios();
 		} 
 		catch (Exception e) {
 			return Response.status(500).entity(doErrorMessage(e)).build();
 		}
 		return Response.status(200).build();
 	}
    

}
