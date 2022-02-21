package com.iesfranciscodelosrios.Cajero.client.singleton;

import java.net.Socket;

import com.iesfranciscodelosrios.Cajero.client.model.Client;

public class ClientSocket {
	
	private static ClientSocket _instance;
	
	private Client client;
	private Socket socket;

	/**
	 * @param socket
	 */
	public ClientSocket(Socket socket) {
		super();
		this.socket = socket;
		this.client=new Client();
	}
	
	public static ClientSocket getInstance(Socket socket) {
		if(_instance==null) {
			_instance=new ClientSocket(socket);
		}
		return _instance;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
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

	@Override
	public String toString() {
		return "ClientSocket [client=" + client + ", socket=" + socket + "]";
	}
	
	
	

}
