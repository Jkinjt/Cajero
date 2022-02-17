package com.iesfranciscodelosrios.Cajero.client.model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.iesfranciscodelosrios.Cajero.client.model.Client;

public class ClientDAO {
	
	
private static EntityManagerFactory emf;
	
	public static void save(Client a) {
		//crear singleton del emf
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}
	
	public static Client selectById(Long id) {
		Client result=null;
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		result=em.find(Client.class, id);
		em.getTransaction().commit();
		return result;
	}
	
	
	

}
