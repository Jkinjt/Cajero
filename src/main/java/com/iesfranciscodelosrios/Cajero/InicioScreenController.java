package com.iesfranciscodelosrios.Cajero;

import com.iesfranciscodelosrios.Cajero.client.model.Account;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class InicioScreenController {
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
	    
	    

}
