package listatarefas.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.google.gson.Gson;

import listatarefas.dto.DTO;
import listatarefas.model.entity.Tarefa;
import listatarefas.model.entity.Usuario;
import listatarefas.util.WebServiceUtil;

@Named
@ViewScoped
public class ManterTarefaController implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private DTO <Tarefa> tarefaDTO;
	private DTO <Usuario> usuarioDTO;
	
	@PostConstruct
	public void onInit(){
		setTarefaDTO(new DTO<Tarefa>());
		getTarefaDTO().setEntidade(new Tarefa());
		
		setUsuarioDTO(new DTO<Usuario>());
		getUsuarioDTO().setEntidade(new Usuario());
	}

	@SuppressWarnings("unchecked")
	public void listarTarefas(){
	
		try {
			getTarefaDTO().setEntidades((List<Tarefa>) WebServiceUtil.requisicaoGET("http://localhost:8080/listatarefas/rest/listarTarefas"));
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void salvarTarefa(){
		
		int status = WebServiceUtil.
				requisicaoPOST("http://localhost:8080/listatarefas/rest/salvarTarefa", new Gson().toJson(getTarefaDTO().getEntidade()));
		
		if(status == 200){
			System.out.println("inserido com sucesso");
		}
	}

	public DTO <Tarefa> getTarefaDTO() {
		return tarefaDTO;
	}

	public void setTarefaDTO(DTO <Tarefa> tarefaDTO) {
		this.tarefaDTO = tarefaDTO;
	}

	public DTO<Usuario> getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(DTO<Usuario> usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	
	
}
