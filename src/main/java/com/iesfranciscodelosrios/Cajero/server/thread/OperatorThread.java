package com.iesfranciscodelosrios.Cajero.server.thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.iesfranciscodelosrios.Cajero.client.model.Account;
import com.iesfranciscodelosrios.Cajero.client.model.ClientBanco;
import com.iesfranciscodelosrios.Cajero.client.model.Operator;
import com.iesfranciscodelosrios.Cajero.client.model.DAO.AccountDAO;
import com.iesfranciscodelosrios.Cajero.client.model.DAO.ClientDAO;

public class OperatorThread  extends Thread{
	private Socket socket;
	private Operator operador;
	
	private ObjectOutputStream objectouput;
	private ObjectInputStream objectinput;
	
	public OperatorThread(Socket socket, Operator operador) {
		super();
		this.socket = socket;
		this.operador = operador;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Operator getOperador() {
		return operador;
	}

	public void setOperador(Operator operador) {
		this.operador = operador;
	}
	
	
	
	@Override
	public void run() {
		
		if(this.socket!=null) {
			try {
				
				while (true) {
					this.objectouput=new ObjectOutputStream(this.socket.getOutputStream());
					this.objectinput=new ObjectInputStream(this.socket.getInputStream());
					int option=objectinput.readInt();
				
					choseOptionClient(option);
					
					
					
					
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
	
		
		public void choseOptionClient(int option) {
			switch (option) {
			case 1://crear cliente
				saveClient();
				System.out.println("opcion "+ option);
				break;
			case 2://crear cuenta
				saveAccount();
				System.out.println("opcion "+ option);
				break;
			case 3://eliminar cuenta
				deleteAccount();
				System.out.println("opcion "+ option);
		
		break;	
			case 4://datos del cliente
				seeClient();
				System.out.println("opcion "+ option);
		
		break;	
			case 5://datos de una cuenta
				seeAccount();
				System.out.println("opcion "+ option);
		
		break;	

			default:
				break;
			}
		}
		
	@Override
	public String toString() {
		return "OperatorThread [socket=" + socket + ", operador=" + operador + "]";
	}
	
	/**
	 * Método que se usa para rebir un cliente del operario y almacenarlo en la base de datos
	 */
	public boolean saveClient() {
		boolean result=false;
		try {
			try {
				ClientBanco client=(ClientBanco) objectinput.readObject();
				
				//se guarda en la base de datos
				System.out.println(client.getName());
				ClientDAO.add(client);
				objectouput.writeBoolean(result);
				objectouput.flush();
				result=true;
				
				return result;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				result=false;
				
				e.printStackTrace();
				
				return result;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			result=false;
			e.printStackTrace();
			
			return result;
		}
	}
	
	
	/**
	 * Método que se usa para recibir una cuenta de un operario y guardarlo en la base de datos
	 */
	public boolean saveAccount() {
		boolean result=false;
		try {
			try {
				Account account=(Account) objectinput.readObject();
				
				//se guarda en la base de datos
				System.out.println(account);
				AccountDAO.add(account);
				objectouput.writeBoolean(result);
				objectouput.flush();
				result=true;
				
				return result;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				result=false;
				
				e.printStackTrace();
				
				return result;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			result=false;
			e.printStackTrace();
			
			return result;
		}
	}
	
	
	/**
	 * Método que se usa para recibir una cuenta de un cliente y eliminarla
	 */
	public boolean deleteAccount() {
		boolean result=false;
		try {
			try {
				Account account=(Account) objectinput.readObject();
				
				//se borra de la base de datos
				System.out.println(account.getBalance());
				AccountDAO.eliminar(account.getId());
				objectouput.writeBoolean(result);
				objectouput.flush();
				
				return result;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				result=false;
				
				e.printStackTrace();
				
				return result;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			result=false;
			e.printStackTrace();
			
			return result;
		}
	}
	
	/**
	 * Método que rebice la petición de un operario para ver los datos de un cliente.
	 * Se busca en la base de datos y se lo devuelve al operario
	 * 
	 */
	public boolean seeClient() {
		
		boolean result=false;
		
		try {
			
			
			Long idClient=objectinput.readLong();
			System.out.println("idClient--->"+idClient);
			//Se busca el id en la base de datos
			ClientBanco client= new ClientBanco("Juanito","1234");
			objectouput.writeObject(client);
			objectouput.flush();
			
			result=true;
			
			return result;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			result=false;
			e.printStackTrace();
			
			return result;
		}
		
	}
	
	
	/**
	 * Método que recibe la petición de un operario para ver los datos de una cuenta.
	 * Se busca en la base de datos y se lo devuelve al operario
	 */
	
	public boolean seeAccount() {
		
		boolean result=false;
		
		try {
			
			
			Long idAccount=objectinput.readLong();
			System.out.println("id--->"+idAccount);
			//Se busca el id en la base de datos
			ClientBanco client= new ClientBanco("Juanito","1234");
			Account account= new Account(idAccount,100.00f,client);
			
			objectouput.writeObject(account);
			objectouput.flush();
			result=true;
			
			return result;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			result=false;
			e.printStackTrace();
			
			return result;
		}
	}
	
	
	
}
