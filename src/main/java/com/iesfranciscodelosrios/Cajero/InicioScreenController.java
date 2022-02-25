package com.iesfranciscodelosrios.Cajero;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import com.iesfranciscodelosrios.Cajero.client.model.Account;
import com.iesfranciscodelosrios.Cajero.client.model.ClientBanco;
import com.iesfranciscodelosrios.Cajero.client.singleton.ClientSocket;
import com.iesfranciscodelosrios.Cajero.server.singleton.ClientsSingleton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class InicioScreenController implements Initializable{
	 @FXML
	    private ImageView fondo;

	    @FXML
	    private TableView<Integer> tablaInicio;

	    @FXML
	    private TableColumn<Integer, Account> clm_Cuenta;

	    @FXML
	    private TableColumn<Integer, Account> clm_Saldo;

	    @FXML
	    private TextField tf_NBanco;

	    @FXML
	    private TextField tf_SalidaNombre;

	    @FXML
	    private TextField tf_Nombre;

	    @FXML
	    private Button btn_salir;
	    
	    DataOutputStream flujosalida;
	    ObjectInputStream flujoEntrada;
	    ClientSocket singleton;
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
		
			singleton=ClientSocket.getInstance();
			tf_SalidaNombre.setText(singleton.getClient().getName());
			
			
		}
		
		@FXML
	    private void tablaCuentas() {
	    	
	    }
		
		@FXML
	    private void salir() {
	    	
	    }
	    
	    

}
