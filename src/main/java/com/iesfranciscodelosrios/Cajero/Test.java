package com.iesfranciscodelosrios.Cajero;

import com.iesfranciscodelosrios.Cajero.client.model.Account;
import com.iesfranciscodelosrios.Cajero.client.model.ClientBanco;
import com.iesfranciscodelosrios.Cajero.client.model.DAO.AccountDAO;


public class Test {
	public static void main(String[] args) {
		ClientBanco c= new ClientBanco(1,"Juan", "1212");
		Account a= new Account(1L, 2500f, c);
		AccountDAO adao= new AccountDAO();
		adao.guardarCuenta(2500.45f, c.getId());
		
	}
}