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

public class OperatorThread  extends Thread{
	private Socket socket;
	private Operator operador;
	
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
		ObjectInputStream objectInput;
		DataOutputStream ouput;
		boolean result=false;
		try {
			objectInput=new ObjectInputStream(this.socket.getInputStream());
			ouput=new DataOutputStream(this.socket.getOutputStream());
			try {
				ClientBanco client=(ClientBanco) objectInput.readObject();
				
				//se guarda en la base de datos
				System.out.println(client.getName());
				ouput.writeBoolean(result);
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
		ObjectInputStream objectInput;
		DataOutputStream ouput;
		boolean result=false;
		try {
			objectInput=new ObjectInputStream(this.socket.getInputStream());
			ouput=new DataOutputStream(this.socket.getOutputStream());
			try {
				Account account=(Account) objectInput.readObject();
				
				//se guarda en la base de datos
				System.out.println(account.getBalance());
				ouput.writeBoolean(result);
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
		ObjectInputStream objectInput;
		DataOutputStream ouput;
		boolean result=false;
		try {
			objectInput=new ObjectInputStream(this.socket.getInputStream());
			ouput=new DataOutputStream(this.socket.getOutputStream());
			try {
				Account account=(Account) objectInput.readObject();
				
				//se borra de la base de datos
				System.out.println(account.getBalance());
				ouput.writeBoolean(result);
				
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
		DataInputStream input;
		ObjectOutputStream objectOuput;
		boolean result=false;
		
		try {
			input=new DataInputStream(this.socket.getInputStream());
			objectOuput=new ObjectOutputStream(this.socket.getOutputStream());
			
			Long idClient=input.readLong();
			//Se busca el id en la base de datos
			ClientBanco client= new ClientBanco("Juanito","1234");
			objectOuput.writeObject(client);
			
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
		DataInputStream input;
		ObjectOutputStream objectOuput;
		boolean result=false;
		
		try {
			input=new DataInputStream(this.socket.getInputStream());
			objectOuput=new ObjectOutputStream(this.socket.getOutputStream());
			
			Long idAccount=input.readLong();
			//Se busca el id en la base de datos
			ClientBanco client= new ClientBanco("Juanito","1234");
			Account account= new Account(idAccount,100.00f,client);
			
			objectOuput.writeObject(account);
			
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
