package com.iesfranciscodelosrios.Cajero;

import com.iesfranciscodelosrios.Cajero.client.model.Account;
import com.iesfranciscodelosrios.Cajero.client.model.ClientBanco;
import com.iesfranciscodelosrios.Cajero.client.model.Operator;
import com.iesfranciscodelosrios.Cajero.client.model.DAO.AccountDAO;
import com.iesfranciscodelosrios.Cajero.client.model.DAO.ClientDAO;
import com.iesfranciscodelosrios.Cajero.client.model.DAO.OperatorDAO;


public class Test {
	public static void main(String[] args) {
		ClientBanco c= new ClientBanco(1,"Juan", "1212");
		ClientDAO cdao= new ClientDAO();
		//cdao.guardarCliente("Miguel","1234");
		OperatorDAO odao= new OperatorDAO();
		//odao.buscarUser("Op_Pepe");
		Account a= new Account(1L, 2500f, c);
		AccountDAO.getContenido(c);
		//adao.guardarCuenta(2500.45f, c.getId());
		
	}
}