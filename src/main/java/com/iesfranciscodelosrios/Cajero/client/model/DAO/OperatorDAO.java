package com.iesfranciscodelosrios.Cajero.client.model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.iesfranciscodelosrios.Cajero.client.model.Operator;

public class OperatorDAO {
	
	private static EntityManagerFactory emf;
	
	public static Operator selectById(Long id) {
		Operator result=null;
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		result=em.find(Operator.class, id);
		em.getTransaction().commit();
		return result;
	}
}
