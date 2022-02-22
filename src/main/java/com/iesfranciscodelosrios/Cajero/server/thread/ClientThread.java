package com.iesfranciscodelosrios.Cajero.server.thread;

import java.net.Socket;

import com.iesfranciscodelosrios.Cajero.server.model.ClientBanco;

public class ClientThread extends Thread {
	private Socket socket;
	private ClientBanco client;
	/**
	 * @param socket
	 * @param client
	 */
	public ClientThread(Socket socket, ClientBanco client) {
		super();
		this.socket = socket;
		this.client = client;
	}
	/**
	 * 
	 */
	public ClientThread() {
		super();
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
	
	@Override
	public void run() {
		
		if(this.socket!=null) {
			
		}
		
		
	}
	

}
