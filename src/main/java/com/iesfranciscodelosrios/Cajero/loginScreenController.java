package com.iesfranciscodelosrios.Cajero;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import com.iesfranciscodelosrios.Cajero.client.model.ClientBanco;
import com.iesfranciscodelosrios.Cajero.client.singleton.ClientSocket;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class loginScreenController{
	
	
    @FXML
    private ImageView fondo;

    @FXML
    private TextField tf_usuario;

    @FXML
    private TextField tf_pass;

    @FXML
    private Button btn_login;

    @FXML
    private TextField tf_logo;
    
    Socket socket;
    DataOutputStream flujosalida;
    ObjectInputStream flujoEntrada;
	@FXML
	public void initialize() {
		try {
			socket = new Socket("localhost", 9999);
			flujosalida = new DataOutputStream(socket.getOutputStream());
			//flujoEntrada = new ObjectInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    
	
    @FXML
    private void comprobarUsuario() throws ClassNotFoundException {
    	String usuario= tf_usuario.getText();
    	String password= tf_pass.getText();
    	try {
			flujosalida.writeUTF(usuario);
			flujosalida.flush();
			flujosalida.writeUTF(password);
			flujosalida.flush();
			//flujosalida.close();
			ClientSocket singleton = new ClientSocket(socket);
			flujoEntrada= new ObjectInputStream(socket.getInputStream());
			singleton.setClient((ClientBanco) flujoEntrada.readObject());
			System.out.println(singleton.getClient().getName());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    private void comprobarTipoUsuario() {
    	
    }
    
    
    @FXML
    private void salir() {
    	
    }


    
   
}
