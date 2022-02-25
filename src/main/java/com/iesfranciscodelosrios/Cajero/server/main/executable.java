package com.iesfranciscodelosrios.Cajero.server.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.iesfranciscodelosrios.Cajero.server.model.ClientBanco;
import com.iesfranciscodelosrios.Cajero.server.thread.ClientThread;

public class executable {
	public static final int puerto = 9999;

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(puerto);
			while(true) {
				try {
					//Aceptamos la conexion
					Socket	socket = server.accept();
					DataInputStream flujoEntrada= new DataInputStream(socket.getInputStream());
					String usuario=flujoEntrada.readUTF();
					String pass=flujoEntrada.readUTF();
					if(usuario.equals("Manolo") && pass.equals("1234")) {
						System.out.println("Has entrado al banco");
						ClientBanco cliente = new ClientBanco(usuario,pass);
						ObjectOutputStream flujoSalida= new ObjectOutputStream(socket.getOutputStream());
						flujoSalida.writeObject(cliente);
						flujoSalida.flush();
						//flujoSalida.close();
					}
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
