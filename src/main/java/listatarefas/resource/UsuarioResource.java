package listatarefas.resource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import listatarefas.model.entity.Usuario;
import listatarefas.service.UsuarioService;

@RequestScoped
@Path("/")
//@ApplicationPath("/")
public class UsuarioResource {

	@Inject
    private UsuarioService usuarioService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listarUsuarios")
    public Response listarUsuarios() throws Exception {
        return Response.ok(usuarioService.getEntidades(Usuario.class)).build();
    }

    /* 
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{customerId}")
    public Response getCustomer(@PathParam("customerId") String customerId) throws  Exception {
        Usuario usuario = usuarioService.getEntidade(Usuario.class, Long.parseLong(customerId));
        return usuario != null
                ? Response.ok(usuario).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewCustomer(Usuario usuario) throws Exception {
    	usuarioService.salvar(usuario);
        return Response.noContent().build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{customerId}")
    public Response deleteCustomer(@PathParam("customerId") String customerId) throws Exception {
    	usuarioService.excluir(usuarioService.getEntidade(Usuario.class, Long.parseLong(customerId)));
        return Response.noContent().build();
    }
	*/
}
