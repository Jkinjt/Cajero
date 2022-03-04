package com.iesfranciscodelosrios.Cajero;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.iesfranciscodelosrios.Cajero.client.model.Account;
import com.iesfranciscodelosrios.Cajero.client.model.ClientBanco;
import com.iesfranciscodelosrios.Cajero.client.model.DAO.AccountDAO;
import com.iesfranciscodelosrios.Cajero.client.model.DAO.ClientDAO;
import com.iesfranciscodelosrios.Cajero.client.singleton.ClientSocket;
import com.iesfranciscodelosrios.Cajero.client.singleton.OperatorSingleton;

import javafx.beans.property.SimpleStringProperty;
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

public class OpsOperarioController implements Initializable {
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
	private TableColumn<Account, String> columnaCliente;

	@FXML
	private TableView<ClientBanco> tablaUsuarios;

	@FXML
	private TableColumn<ClientBanco, String> columnaNombre;

	@FXML
	private TableColumn<ClientBanco, Long> columnaCuentaUsuarios;

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
		singletonOperario = OperatorSingleton.getInstance();
		singleton = ClientSocket.getInstance();
		nombre_operario.setText(singletonOperario.getOperator().getName());
		
		cb_Cliente.setItems(FXCollections.observableArrayList(ClientDAO.todosClientes()));
		cuentaEliminar.setItems(FXCollections.observableArrayList(AccountDAO.todas()));
		tablaCuentas();
		tablaUsuarios();

	}

	@FXML
	private void createCliente() {
	
		ClientBanco cliente = new ClientBanco("Cl_"+tf_usuario.getText(),tf_contra.getText());
	
		try {
			flujoSalida = new ObjectOutputStream(singletonOperario.getOperatorSocket().getOutputStream());
			flujoSalida.writeInt(1);
			flujoSalida.flush();
			// flujoSalida= new ObjectOutputStream(singleton.getSocket().getOutputStream());
			flujoSalida.writeObject(cliente);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	private void addCuenta() {
		
		
		
		Account a= new Account(Float.parseFloat(tf_saldoCuenta.getText()), cb_Cliente.getSelectionModel().getSelectedItem());
		System.out.println("AQUIIIIIIIIIIIII"+cb_Cliente.getSelectionModel().getSelectedItem());

		try {
			flujoSalida = new ObjectOutputStream(singletonOperario.getOperatorSocket().getOutputStream());
			flujoSalida.writeInt(2);
			flujoSalida.flush();
			// flujoSalida= new ObjectOutputStream(singleton.getSocket().getOutputStream());
			flujoSalida.writeObject(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	private void deleteCuenta() {
		Account a = cuentaEliminar.getSelectionModel().getSelectedItem();
		try {
			flujoSalida = new ObjectOutputStream(singletonOperario.getOperatorSocket().getOutputStream());
			flujoSalida.writeInt(3);
			flujoSalida.flush();
			// flujoSalida= new ObjectOutputStream(singleton.getSocket().getOutputStream());
			flujoSalida.writeObject(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	private void tablaCuentas() {
		tablaCuentas.setItems(FXCollections.observableArrayList(AccountDAO.todas()));
		this.columnaCuentaID.setCellValueFactory(new PropertyValueFactory<Account, Long>("id"));
		this.columnaSaldo.setCellValueFactory(new PropertyValueFactory<Account, Float>("balance"));
		this.columnaCliente.setCellValueFactory(
				eachClient -> new SimpleStringProperty(eachClient.getValue().getClient().getName()));
	}

	@FXML
	private void tablaUsuarios() {
		tablaUsuarios.setItems(FXCollections.observableArrayList(ClientDAO.todosClientes()));
		this.columnaNombre.setCellValueFactory(new PropertyValueFactory<ClientBanco, String>("name"));
		this.columnaCuentaUsuarios.setCellValueFactory(new PropertyValueFactory<ClientBanco, Long>("id"));
	}

	@FXML
	private void salir() throws IOException {
		try {
    		singleton.getSocket().close();
			App.setRoot("loginSceen");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
