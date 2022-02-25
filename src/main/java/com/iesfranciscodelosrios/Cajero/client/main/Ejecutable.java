package com.iesfranciscodelosrios.Cajero.client.main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ejecutable {

	public static void main(String[] args) {
		Socket socket;
		try {
			socket = new Socket("localhost",9999);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeInt(1);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
