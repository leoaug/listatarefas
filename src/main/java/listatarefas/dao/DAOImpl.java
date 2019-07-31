package listatarefas.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

/**
 * 
 * @author Leonardo
 * @param <T>
 */
@RequestScoped
public abstract class DAOImpl <T extends Serializable> implements DAO <T> {

	
	@Inject
	private EntityManager em;

	@Override
	public T getEntidade(Class <T> clazz,Long id) throws Exception {
		return (T) em.find(clazz, id);
	}

	@Override
	@Transactional
	public void salvar(T entidade) throws Exception {
		em.persist(entidade);
	}


	@Override
	public List <T> getEntidades(Class <T> clazz) throws Exception {
		return em.createQuery("SELECT tableEntidade FROM "+clazz.getCanonicalName()+" tableEntidade").getResultList();
	}

	@Override
	@Transactional
	public void excluir(T entidade) throws Exception {
		em.remove(entidade);		
	}

	@Override
	@Transactional
	public T alterar(T entidade) throws Exception {
		return em.merge(entidade);
	}


	
	
}
