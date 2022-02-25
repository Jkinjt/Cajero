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
import com.iesfranciscodelosrios.Cajero.client.model.Operator;
import com.iesfranciscodelosrios.Cajero.client.singleton.ClientSocket;
import com.iesfranciscodelosrios.Cajero.client.singleton.OperatorSingleton;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    	if(usuario.startsWith("Op")) {
    		try {
    			flujosalida.writeUTF(usuario);
    			flujosalida.flush();
    			flujosalida.writeUTF(password);
    			flujosalida.flush();
    			//flujosalida.close();
    			OperatorSingleton singleton = OperatorSingleton.getInstance(socket);
    			flujoEntrada= new ObjectInputStream(socket.getInputStream());
    			singleton.setOperator((Operator) flujoEntrada.readObject());
    			App.setRoot("opsOperario");
    			System.out.println(singleton.getOperator().getName());
    			
    		} catch (UnknownHostException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}else if (usuario.startsWith("Cl")){
    		try {
    			flujosalida.writeUTF(usuario);
    			flujosalida.flush();
    			flujosalida.writeUTF(password);
    			flujosalida.flush();
    			//flujosalida.close();
    			ClientSocket singleton = ClientSocket.getInstance(socket);
    			flujoEntrada= new ObjectInputStream(socket.getInputStream());
    			singleton.setClient((ClientBanco) flujoEntrada.readObject());
    			App.setRoot("inicioScreen");
    			System.out.println(singleton.getClient().getName());
    			
    		} catch (UnknownHostException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}else {
    		mostrarAlerta("METE ALGO EN CONDICIONES");
    	}
    	
    }
    
    @FXML
    private void comprobarTipoUsuario() {
    	
    }
    
    
    @FXML
    private void salir() {
    	
    }

    private void mostrarAlerta(String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("ERROR");
        alert.setContentText(error);
        alert.showAndWait();
    }
    
   
}
