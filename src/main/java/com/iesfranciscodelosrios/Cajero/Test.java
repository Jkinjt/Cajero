package com.iesfranciscodelosrios.Cajero;

import com.iesfranciscodelosrios.Cajero.client.model.Account;
import com.iesfranciscodelosrios.Cajero.client.model.Client;
import com.iesfranciscodelosrios.Cajero.client.model.DAO.AccountDAO;


public class Test {
	public static void main(String[] args) {
		Client c= new Client("Juan", "1212");
		Account a= new Account(2, 2500, c);
		AccountDAO.save(a);
		
	}
}