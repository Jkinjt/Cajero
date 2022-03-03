module com.iesfranciscodelosrios.Cajero {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;
	requires java.base;

    opens com.iesfranciscodelosrios.Cajero to javafx.fxml;
    opens com.iesfranciscodelosrios.Cajero.client.model to javafx.fxml,java.base;
    exports com.iesfranciscodelosrios.Cajero;
    exports com.iesfranciscodelosrios.Cajero.client.model;
}