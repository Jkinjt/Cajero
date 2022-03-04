package com.iesfranciscodelosrios.Cajero;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.iesfranciscodelosrios.Cajero.client.model.Account;
import com.iesfranciscodelosrios.Cajero.client.singleton.ClientSocket;
import com.iesfranciscodelosrios.Cajero.server.thread.ClientThread;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class OpsClienteController implements Initializable {

    @FXML
    private ImageView fondo;

    @FXML
    private TextField tf_cantidadIngresar;

    @FXML
    private Button btn_ingresar;

    @FXML
    private TextField tf_cantidadRetirar;

    @FXML
    private Button btn_Retirar;

    @FXML
    private TextField tf_NombreCuenta;

    @FXML
    private Button btn_salir;
    
    ObjectOutputStream flujosalida;
    ObjectInputStream flujoEntrada;
    ClientSocket singleton;
    ClientThread operaciones;
    
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		
	
		singleton=ClientSocket.getInstance();
		tf_NombreCuenta.setText("Numero de cuenta--->   "+singleton.getCuenta().getId().toString());
		
		
	}
    
    
    @FXML
    private void ingresar() {
    	try {
    		flujosalida=new ObjectOutputStream(singleton.getSocket().getOutputStream());
    		flujosalida.writeInt(2);
    		flujosalida.flush();
    		Float saldonuevo=Float.parseFloat(tf_cantidadIngresar.getText());
    		flujosalida.writeFloat(saldonuevo);
    		flujosalida.flush();
    		singleton.getCuenta().setBalance(saldonuevo);
    		flujosalida.writeObject(singleton.getCuenta());
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    @FXML
    private void retirar() {
    	
    	try {
    		flujosalida=new ObjectOutputStream(singleton.getSocket().getOutputStream());
    		flujosalida.writeInt(3);
    		flujosalida.flush();
    		Float saldonuevo=singleton.getCuenta().getBalance()-Float.parseFloat(tf_cantidadRetirar.getText());
    		singleton.getCuenta().setBalance(saldonuevo);
    		flujosalida.writeObject(singleton.getCuenta());
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    @FXML
    private void salir() {
    	
    	try {
    		singleton.getSocket().close();
			App.setRoot("inicioScreen");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    
    
    
    
}