package com.iesfranciscodelosrios.Cajero.server.thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import com.iesfranciscodelosrios.Cajero.client.model.ClientBanco;



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
			try {
				
				while (true) {
					
					DataInputStream input=new DataInputStream(this.socket.getInputStream());
					int option=input.readInt();
					input.close();
					choseOptionClient(option);
					
					
					
					
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	/**
	 * Método que obtiene el salario de una cuenta
	 * @return
	 */
	public int getSalary() {
		
		return 500;
	}
	
	public int substracSalary(int substracAmount) {
		
		return 500-substracAmount;
	}
	
	public int enterSalary(int enterSalary) {
		
		return 500+enterSalary;
	}
	
	/**
	 * Recibe un número que establece que tipo de petición esta haciendo el cliente
	 */
	public void choseOptionClient(int option) {
		switch (option) {
		case 1:
			System.out.println("opcion "+ option);
			break;
		case 2:
			System.out.println("opcion "+ option);
			break;
		case 3:
			System.out.println("opcion "+ option);
	
	break;	

		default:
			break;
		}
	}
	
	
	
	

}
