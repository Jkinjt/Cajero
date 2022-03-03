package com.iesfranciscodelosrios.Cajero.client.singleton;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.iesfranciscodelosrios.Cajero.client.model.Account;
import com.iesfranciscodelosrios.Cajero.client.model.ClientBanco;

public class ClientSocket {
	
	private static ClientSocket _instance;
	private static final String dominio="localhost";
	private static final int port=9999;
	private ClientBanco client;
	private Socket socket;
	private Account cuenta;

	/**
	 * @param socket
	 */
	private ClientSocket(Socket socket) {
		super();
		this.socket = socket;
		this.client=new ClientBanco();
	}
	
	private ClientSocket() {
		super();
		try {
			this.socket=new Socket(dominio,port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ClientSocket getInstance(Socket socket) {
		if(_instance==null) {
			_instance=new ClientSocket(socket);
		}
		return _instance;
	}
	
	public static ClientSocket getInstance() {
		if(_instance==null) {
			_instance=new ClientSocket();
		}
		return _instance;
	}

	/**
	 * @return the client
	 */
	public ClientBanco getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(ClientBanco client) {
		this.client = client;
	}

	/**
	 * @return the socket
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * @param socket the socket to set
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	

	public Account getCuenta() {
		return cuenta;
	}

	public void setCuenta(Account cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "ClientSocket [client=" + client + ", socket=" + socket + "]";
	}
	
	
	

}
