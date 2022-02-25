module com.iesfranciscodelosrios.Cajero {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.persistence;
	requires javafx.graphics;

    opens com.iesfranciscodelosrios.Cajero to javafx.fxml;
    exports com.iesfranciscodelosrios.Cajero;
}
