package com.iesfranciscodelosrios.Cajero.server.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.iesfranciscodelosrios.Cajero.client.model.ClientBanco;
import com.iesfranciscodelosrios.Cajero.client.model.Operator;
import com.iesfranciscodelosrios.Cajero.client.model.DAO.ClientDAO;
import com.iesfranciscodelosrios.Cajero.client.model.DAO.OperatorDAO;
import com.iesfranciscodelosrios.Cajero.server.thread.ClientThread;
import com.iesfranciscodelosrios.Cajero.server.thread.OperatorThread;

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
					if(usuario.startsWith("Op")) {
						Operator o=OperatorDAO.buscarUser(usuario);
						if(usuario.equals(o.getName()) && pass.equals(o.getPassword())) {
						System.out.println("Has entrado al banco");
						ObjectOutputStream flujoSalida= new ObjectOutputStream(socket.getOutputStream());
						flujoSalida.writeObject(o);
						flujoSalida.flush();
						OperatorThread cc= new OperatorThread(socket, o);
						cc.start();
						System.out.println("Hilo de operador iniciado");
						}
			    	}else if (usuario.startsWith("Cl")){
			    		ClientBanco c=ClientDAO.buscarUser(usuario);
			    		if(usuario.equals(c.getName()) && pass.equals(c.getPassword())) {
							System.out.println("Has entrado al banco");
							ObjectOutputStream flujoSalida= new ObjectOutputStream(socket.getOutputStream());
							flujoSalida.writeObject(c);
							flujoSalida.flush();
							ClientThread cc= new ClientThread(socket, c);
							cc.start();
							System.out.println("Hilo de cliente iniciado");
						}
			    	}
					
					System.out.println("Conexión establecida con el server");
					
					
					//Iniciamos el hilo
					
					
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
