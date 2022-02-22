package com.iesfranciscodelosrios.Cajero.client.model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.iesfranciscodelosrios.Cajero.client.model.ClientBanco;
import com.iesfranciscodelosrios.Cajero.utils.PersistenceUnit;

public class ClientDAO {
	
	

	
	public static void save(ClientBanco a) {
		//crear singleton del emf
		EntityManager em=PersistenceUnit.getEM();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}
	
	public static ClientBanco selectById(Long id) {
		ClientBanco result=null;
		EntityManager em=PersistenceUnit.getEM();
		em.getTransaction().begin();
		result=em.find(ClientBanco.class, id);
		em.getTransaction().commit();
		return result;
	}
	
	
	

}
