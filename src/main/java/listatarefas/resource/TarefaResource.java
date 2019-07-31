package listatarefas.resource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import listatarefas.model.entity.Tarefa;
import listatarefas.service.TarefaService; 


@RequestScoped
@Path("/tarefas")
public class TarefaResource {

	@Inject
    private TarefaService tarefaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listarTarefas")
    public Response listarTarefas() throws Exception {
        return Response.ok(tarefaService.getEntidades(Tarefa.class)).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/salvarTarefa")
    public Response salvarTarefa(Tarefa tarefa) throws Exception {
    	tarefaService.salvar(tarefa);
        return Response.noContent().build();
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
