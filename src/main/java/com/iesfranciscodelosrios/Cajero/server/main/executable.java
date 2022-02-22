package com.iesfranciscodelosrios.Cajero.server.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.iesfranciscodelosrios.Cajero.server.model.ClientBanco;
import com.iesfranciscodelosrios.Cajero.server.thread.ClientThread;

public class executable {
	public static final int puerto = 8888;

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(puerto,0);
			while(true) {
				try {
					Socket socket = new Socket("localhost", puerto);
					//Aceptamos la conexion
					socket = server.accept();
					System.out.println("Conexión establecida con el server");
					ClientThread cc= new ClientThread(socket, new ClientBanco());
					
					//Iniciamos el hilo
					cc.start();
					System.out.println("Hilo de cliente iniciado---> "+cc.getClient().getName());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
