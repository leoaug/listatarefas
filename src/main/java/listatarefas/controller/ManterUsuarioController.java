package listatarefas.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import listatarefas.dto.DTO;
import listatarefas.model.entity.Usuario;

@Named
@ViewScoped
public class ManterUsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	private DTO <Usuario> usuarioDTO;
	
	@PostConstruct
	public void onInit(){
		setUsuarioDTO(new DTO <Usuario> ());
		getUsuarioDTO().setEntidade(new Usuario());
	}

	public DTO<Usuario> getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(DTO<Usuario> usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	
	
}
