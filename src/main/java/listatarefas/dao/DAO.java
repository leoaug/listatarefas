package listatarefas.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO <T extends Serializable >{

	public List <T> getEntidades(Class <T> clazz) throws Exception;
	public void salvar(T entidade) throws Exception;
	public void excluir(T entidade) throws Exception;
	public T alterar(T entidade) throws Exception;
	public T getEntidade(Class<T> clazz, Long id) throws Exception;
}
