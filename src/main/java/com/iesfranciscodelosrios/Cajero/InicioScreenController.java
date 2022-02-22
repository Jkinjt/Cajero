package com.iesfranciscodelosrios.Cajero;

import java.net.URL;
import java.util.ResourceBundle;

import com.iesfranciscodelosrios.Cajero.client.model.Account;

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

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}
		
		@FXML
	    private void tablaCuentas() {
	    	
	    }
		
		@FXML
	    private void salir() {
	    	
	    }
	    
	    

}
