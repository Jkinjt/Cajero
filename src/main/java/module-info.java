module com.iesfranciscodelosrios.Cajero {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;
	requires java.base;

    opens com.iesfranciscodelosrios.Cajero to javafx.fxml, java.sql,com.iesfranciscodelosrios.Cajero.client.model;  
    exports com.iesfranciscodelosrios.Cajero;
}