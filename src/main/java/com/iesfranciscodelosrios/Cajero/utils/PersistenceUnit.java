package com.iesfranciscodelosrios.Cajero.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUnit {
	private static final String REMOTE = "aplicacionMariaDB";
	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static EntityManagerFactory getInstance(String name) {
	
				emf = Persistence.createEntityManagerFactory(name);
			
		return emf;
	}

	public static EntityManagerFactory getInstance() {
	
				emf = Persistence.createEntityManagerFactory(REMOTE);
			
		
		return emf;
	}

	public static EntityManager getEM() {
		if (em == null) {
			em = PersistenceUnit.getInstance().createEntityManager();
			return em;
		} else {
			return em;
		}
	}
}