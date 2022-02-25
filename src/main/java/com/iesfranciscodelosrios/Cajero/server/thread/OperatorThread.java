package com.iesfranciscodelosrios.Cajero.server.thread;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

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
		
	@Override
	public String toString() {
		return "OperatorThread [socket=" + socket + ", operador=" + operador + "]";
	}
	
	
	
	
	
}
