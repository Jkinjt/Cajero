package com.iesfranciscodelosrios.Cajero.server.thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.iesfranciscodelosrios.Cajero.client.model.Account;
import com.iesfranciscodelosrios.Cajero.client.model.ClientBanco;

public class ClientThread extends Thread {
	private Socket socket;
	private ClientBanco client;

	private ObjectOutputStream objectouput;
	private ObjectInputStream objectinput;

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

		if (this.socket != null) {
			try {

				while (true) {
					this.objectouput = new ObjectOutputStream(this.socket.getOutputStream());
					this.objectinput = new ObjectInputStream(this.socket.getInputStream());
					
					int option = objectinput.readInt();
					try {
						choseOptionClient(option);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * Método que obtiene el salario de una cuenta
	 * 
	 * @return
	 */
	public int getSalary() {

		return 500;
	}

	public float substracSalary(float substracAmount) {

		return 500 - substracAmount;
	}

	public float enterSalary(float enterSalary) {

		return 500 + enterSalary;
	}

	/**
	 * Recibe un número que establece que tipo de petición esta haciendo el cliente
	 * @throws ClassNotFoundException 
	 */
	public void choseOptionClient(int option) throws ClassNotFoundException {
		switch (option) {
		case 1:
			seeSalary();
			System.out.println("opcion " + option);
			break;
		case 2:
			enterMoney();
			System.out.println("opcion " + option);
			break;
		case 3:
			substracMoney();
			System.out.println("opcion " + option);

			break;

		default:
			break;
		}
	}

	/**
	 * Envia el salario actual de una cuenta
	 */
	public void seeSalary() {
		try {
			objectouput.writeFloat(getSalary());
			objectouput.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Recibe una cantidad desde el cliente que resta una cantidad a una cuenta
	 * @throws ClassNotFoundException 
	 */
	public void substracMoney() throws ClassNotFoundException {
		try {

			Account c= (Account) objectinput.readObject();
			System.out.println(c);
			objectouput.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Recibe una cantidad de dinero de un cliente que suma dicha cantidad a la
	 * cuenta
	 * @throws ClassNotFoundException 
	 */
	public void enterMoney() throws ClassNotFoundException {
		try {

			Account c= (Account) objectinput.readObject();
			System.out.println(c);
			objectouput.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
