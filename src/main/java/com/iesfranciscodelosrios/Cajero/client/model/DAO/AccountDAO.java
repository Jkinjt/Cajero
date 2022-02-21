package com.iesfranciscodelosrios.Cajero.client.model.DAO;

import javax.persistence.EntityManager;

import com.iesfranciscodelosrios.Cajero.client.model.Account;
import com.iesfranciscodelosrios.Cajero.utils.PersistenceUnit;

public class AccountDAO  {
	
	public static void save(Account a) {
		//crear singleton del emf
		EntityManager em=PersistenceUnit.getEM();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}
	

	public static void delete(Account a) {
        EntityManager em=PersistenceUnit.getEM();
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();
	}
	
	public static void update(Account a) {
        EntityManager em=PersistenceUnit.getEM();
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
	}
	
	

}
