package com.iesfranciscodelosrios.Cajero;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.iesfranciscodelosrios.Cajero.client.model.Account;
import com.iesfranciscodelosrios.Cajero.client.model.ClientBanco;
import com.iesfranciscodelosrios.Cajero.client.singleton.OperatorSingleton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
public class OpsOperarioController implements Initializable{
	OperatorSingleton singleton;
	ObjectInputStream flujoEntrada;
	ObjectOutputStream flujoSalida;
	DataOutputStream flujoSalidaData;

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
    private TextField nombre_operario;
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		singleton= OperatorSingleton.getInstance();
		nombre_operario.setText(singleton.getOperator().getName());
		
	}
    
    
    @FXML
    private void createCliente() {
    	ClientBanco cliente= new ClientBanco("Antonio","1212");
    	try {
			flujoSalidaData= new DataOutputStream(singleton.getOperatorSocket().getOutputStream());
			flujoSalidaData.writeInt(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
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
