package com.iesfranciscodelosrios.Cajero;

import com.iesfranciscodelosrios.Cajero.client.model.Account;
import com.iesfranciscodelosrios.Cajero.client.model.ClientBanco;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
public class OpsOperarioController {
	

    @FXML
    private ImageView fondo;

    @FXML
    private TextField tf_usuario;

    @FXML
    private Button btn_ingresar;

    @FXML
    private TextField tf_cuentaAdd;

    @FXML
    private Button btn_IngresarCuenta;

    @FXML
    private TableView<Account> tablaCuentas;

    @FXML
    private TableColumn<Integer, Account> columnaCuentaID;

    @FXML
    private TableColumn<Float, Account> columnaSaldo;

    @FXML
    private TableColumn<String, ClientBanco> columnaCliente;

    @FXML
    private TableView<ClientBanco> tablaUsuarios;

    @FXML
    private TableColumn<String, ClientBanco> columnaNombre;

    @FXML
    private TableColumn<Integer, Account> columnaCuentaUsuarios;

    @FXML
    private TextField tf_CuentaEliminar;

    @FXML
    private Button btn_eliminarCuenta;

    @FXML
    private Button btn_Salir;
    
    
    @FXML
    private void addUsuario() {
    	
    }
    
    
    @FXML
    private void addCuenta() {
    	
    }
    
    
    @FXML
    private void deleteCuenta() {
    	
    }
    
    
    @FXML
    private void tablaCuentas() {
    	
    }
    
    @FXML
    private void tablaUsuarios() {
    	
    }
    
    
    @FXML
    private void salir() {
    	
    }
    
    
    
    
    
    
    
    
}
