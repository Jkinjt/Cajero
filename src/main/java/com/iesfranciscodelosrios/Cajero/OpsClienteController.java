package com.iesfranciscodelosrios.Cajero;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
    
    DataOutputStream flujosalida;
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
    	
    }
    
    @FXML
    private void retirar() {
    	
    }
    
    @FXML
    private void salir() {
    	try {
			App.setRoot("inicioScreen");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    
    
    
    
}