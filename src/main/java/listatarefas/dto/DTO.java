package listatarefas.dto;

import java.io.Serializable;
import java.util.List;

public class DTO <T extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public T entidade;
	public List <T> entidades;
	public T getEntidade() {
		return entidade;
	}
	public void setEntidade(T entidade) {
		this.entidade = entidade;
	}
	public List<T> getEntidades() {
		return entidades;
	}
	public void setEntidades(List<T> entidades) {
		this.entidades = entidades;
	}
	
	

}
