package com.iesfranciscodelosrios.Cajero.client.singleton;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.iesfranciscodelosrios.Cajero.client.model.Account;
import com.iesfranciscodelosrios.Cajero.client.model.Client;
import com.iesfranciscodelosrios.Cajero.client.model.Operator;

public class OperatorSingleton {
	private static OperatorSingleton _instance; 
	private Operator operator;
	private List<Client> clients;
	private List<Account> accounts;
	private Socket operatorSocket;
	/**
	 * @param clients
	 * @param accounts
	 * @param operatorSocket
	 */
	private OperatorSingleton(List<Client> clients, List<Account> accounts, Socket operatorSocket) {
		super();
		this.clients = clients;
		this.accounts = accounts;
		this.operatorSocket = operatorSocket;
	}
	/**
	 * @param operatorSocket
	 */
	private OperatorSingleton(Socket operatorSocket) {
		super();
		this.operatorSocket = operatorSocket;
		this.clients=new ArrayList<>();
		this.accounts=new ArrayList<>();
		
	}
	/**
	 * 
	 */
	public OperatorSingleton() {
		super();
	}
	
	public static OperatorSingleton getInstance(Socket operatorSocket) {
		if(_instance==null) {
			_instance=new OperatorSingleton(operatorSocket);
		}
		return _instance;
		
	}
	
	
	/**
	 * @return the clients
	 */
	public List<Client> getClients() {
		return clients;
	}
	/**
	 * @param clients the clients to set
	 */
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	/**
	 * @return the accounts
	 */
	public List<Account> getAccounts() {
		return accounts;
	}
	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	/**
	 * @return the operatorSocket
	 */
	public Socket getOperatorSocket() {
		return operatorSocket;
	}
	/**
	 * @param operatorSocket the operatorSocket to set
	 */
	public void setOperatorSocket(Socket operatorSocket) {
		this.operatorSocket = operatorSocket;
	}
	
	
	@Override
	public String toString() {
		return "OperatorSingleton [operator=" + operator + ", clients=" + clients + ", accounts=" + accounts
				+ ", operatorSocket=" + operatorSocket + "]";
	}
	
	/**
	 * Método para añadir clientes a la lista
	 * @param client
	 * @return boolean verdadero si se ha añadido a la lista y falso y si no se ha conseguido añadir
	 */
	public boolean addClient(Client client) {
		if(clients.add(client)) {
			
			return true;
		
		}else {
		
			return false;
		
		}
	}
	
	/**
	 * Método para borrar un cliente de la lista
	 * @param client
	 * @return boolean verdadero si se ha borrado de la lista y falso si no se ha conseguido borrar
	 */
	public boolean removeClient(Client client) {
		if(clients.remove(client)) {
		
			return true;
		
		}else {
		
			return false;
		
		}
	}
	
	/**
	 * Método para añadir cuentas de la lista
	 * @param account
	 * @return boolean verdadero si se ha añadido a la lista y falso si no se ha podido añadir
	 */
	public boolean addAccounts(Account account) {
		if(accounts.add(account)) {
		
			return true;
		
		}else {
		
			return false;
		
		}
	}
	
	/**
	 * Método para borrar cuentas de la lista
	 * @param account
	 * @return boolean verdadero si se ha conseguido borrar y falso si no se ha logrado
	 */
	public boolean removeAccounts(Account account) {
		if(accounts.remove(account)) {
		
			return true;
		
		}else {
		
			return false; 
		
		}
	}
	
	
	
	
	
	
	

}
