package com.iesfranciscodelosrios.Cajero;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.iesfranciscodelosrios.Cajero.client.model.Account;
import com.iesfranciscodelosrios.Cajero.client.model.ClientBanco;
import com.iesfranciscodelosrios.Cajero.client.singleton.ClientSocket;
import com.iesfranciscodelosrios.Cajero.client.singleton.OperatorSingleton;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
public class OpsOperarioController implements Initializable{
	OperatorSingleton singletonOperario;
	ClientSocket singleton;
	ObjectInputStream flujoEntrada;
	ObjectOutputStream flujoSalida;

    @FXML
    private ImageView fondo;

    @FXML
    private TextField tf_usuario;

    @FXML
    private Button btn_ingresar;

    @FXML
    private TextField tf_saldoCuenta;

    @FXML
    private Button btn_IngresarCuenta;

    @FXML
    private TableView<Account> tablaCuentas;

    @FXML
    private TableColumn<Account, Long> columnaCuentaID;

    @FXML
    private TableColumn<Account, Float> columnaSaldo;

    @FXML
    private TableColumn<String, ClientBanco> columnaCliente;

    @FXML
    private TableView<ClientBanco> tablaUsuarios;

    @FXML
    private TableColumn<ClientBanco, String> columnaNombre;

    @FXML
    private TableColumn<Account, Long> columnaCuentaUsuarios;

    @FXML
    private ComboBox<Account> cuentaEliminar;

    @FXML
    private Button btn_eliminarCuenta;

    @FXML
    private Button btn_Salir;
    
    @FXML
    private TextField nombre_operario;
    
    @FXML
    private ComboBox<ClientBanco> cb_Cliente;

    @FXML
    private TextField tf_contra;
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		singletonOperario= OperatorSingleton.getInstance();
		singleton=ClientSocket.getInstance();
		nombre_operario.setText(singletonOperario.getOperator().getName());
		
		 tablaCuentas();
		 tablaUsuarios();
		
	}
    
    
    @FXML
    private void createCliente() {
    	ClientBanco cliente= new ClientBanco("Antonio","1212");
    	try {
			flujoSalida= new ObjectOutputStream(singletonOperario.getOperatorSocket().getOutputStream());
			flujoSalida.writeInt(1);
			flujoSalida.flush();
			//flujoSalida= new ObjectOutputStream(singleton.getSocket().getOutputStream());
			flujoSalida.writeObject(cliente);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
    }
    
    
    @FXML
    private void addCuenta() {
    	ClientBanco c= new ClientBanco("Antonio","1212");
    	Account a= new Account(1L, 2500f, c);
    	try {
			flujoSalida= new ObjectOutputStream(singletonOperario.getOperatorSocket().getOutputStream());
			flujoSalida.writeInt(2);
			flujoSalida.flush();
			//flujoSalida= new ObjectOutputStream(singleton.getSocket().getOutputStream());
			flujoSalida.writeObject(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
    }
    
    
    @FXML
    private void deleteCuenta() {
    	//Long id_cancion=cuentaEliminar.getSelectionModel().getSelectedItem().getId();
    	ClientBanco c= new ClientBanco("Antonio","1212");
    	Account a= new Account(1L, 2500f, c);
    	try {
			flujoSalida= new ObjectOutputStream(singletonOperario.getOperatorSocket().getOutputStream());
			flujoSalida.writeInt(3);
			flujoSalida.flush();
			//flujoSalida= new ObjectOutputStream(singleton.getSocket().getOutputStream());
			flujoSalida.writeObject(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
    }
    
    
    @FXML
    private void tablaCuentas() {
    	tablaCuentas.setItems(FXCollections.observableArrayList(singletonOperario.getAccounts()));
    	this.columnaCuentaID.setCellValueFactory(new PropertyValueFactory<Account,Long>("id"));
    	this.columnaSaldo.setCellValueFactory(new PropertyValueFactory<Account,Float>("balance"));
    }
    
    @FXML
    private void tablaUsuarios() {
    	tablaUsuarios.setItems(FXCollections.observableArrayList(singletonOperario.getClients()));
    	this.columnaNombre.setCellValueFactory(new PropertyValueFactory<ClientBanco,String>("nombre"));
    	this.columnaCuentaUsuarios.setCellValueFactory(new PropertyValueFactory<Account,Long>("id"));
    }
    
    
    @FXML
    private void salir() throws IOException {
    	App.setRoot("LoginSceen");
    }



    
    
    
    
    
    
    
}
