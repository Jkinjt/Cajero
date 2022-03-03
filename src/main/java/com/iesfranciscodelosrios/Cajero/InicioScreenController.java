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

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class InicioScreenController implements Initializable{
	 @FXML
	    private ImageView fondo;

	    @FXML
	    private TableView<Account> tablaInicio;

	    @FXML
	    private TableColumn<Account, Integer> clm_Cuenta;

	    @FXML
	    private TableColumn<Account, Float> clm_Saldo;

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
			singleton.getClient().getAcounts().add(new Account(1L, 2500f, singleton.getClient()));
			singleton.getClient().getAcounts().add(new Account(2L, 44252f, singleton.getClient()));
			tf_SalidaNombre.setText(singleton.getClient().getName());
			
			System.out.println(singleton.getClient().getAcounts());
			tablaCuentas();
			
			
			tablaInicio.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	    	tablaInicio.getSelectionModel().setCellSelectionEnabled(true);
			
			
		}
		
		@FXML
	    private void tablaCuentas() {
			//dentro del observable iria la lista de cuenta de la bbdd
			
	    	tablaInicio.setItems(FXCollections.observableArrayList(singleton.getClient().getAcounts()));
	    	this.clm_Cuenta.setCellValueFactory(new PropertyValueFactory<Account,Integer>("id"));
	    	this.clm_Saldo.setCellValueFactory(new PropertyValueFactory<Account,Float>("balance"));
	    	
	    }
		
		
		@FXML
		private void selectColumn() throws IOException{
			TablePosition<Account, Float> tablePosition=tablaInicio.getSelectionModel().getSelectedCells().get(0);
	        int row=tablePosition.getRow();
	        Account item=tablaInicio.getItems().get(row);
	        singleton.setCuenta(item);
	        App.setRoot("opsCliente");
		}
		
		@FXML
	    private void salir() throws IOException {
	    	App.setRoot("loginSceen");
	    }
	    
	    

}
