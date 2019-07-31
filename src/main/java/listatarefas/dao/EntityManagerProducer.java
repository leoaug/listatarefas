package listatarefas.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.io.Serializable;

@RequestScoped
public class EntityManagerProducer implements Serializable {

	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("unit_app");

	@Produces
	public EntityManager createEntityManager() {
		return emf.createEntityManager();
	}

	public void close(@Disposes EntityManager em) {
		if (em.isOpen()) {
			em.close();
		}
	}

}