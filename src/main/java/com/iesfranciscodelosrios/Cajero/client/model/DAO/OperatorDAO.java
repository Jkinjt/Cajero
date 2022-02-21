package com.iesfranciscodelosrios.Cajero.client.model.DAO;

import javax.persistence.EntityManager;

import com.iesfranciscodelosrios.Cajero.client.model.Operator;
import com.iesfranciscodelosrios.Cajero.utils.PersistenceUnit;

public class OperatorDAO {

	
	public static Operator selectById(Long id) {
		Operator result=null;
		EntityManager em=PersistenceUnit.getEM();
		em.getTransaction().begin();
		result=em.find(Operator.class, id);
		em.getTransaction().commit();
		return result;
	}
}
