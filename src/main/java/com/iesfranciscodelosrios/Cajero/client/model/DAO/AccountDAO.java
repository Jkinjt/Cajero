package com.iesfranciscodelosrios.Cajero.client.model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.iesfranciscodelosrios.Cajero.client.model.Account;

public class AccountDAO  {
	private static EntityManagerFactory emf;
	
	public static void save(Account a) {
		//crear singleton del emf
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}
	

	public static void delete(Account a) {
        EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();
	}
	
	public static void update(Account a) {
        EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
	}
	
	

}
