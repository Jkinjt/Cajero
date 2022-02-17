module com.iesfranciscodelosrios.Cajero {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.persistence;

    opens com.iesfranciscodelosrios.Cajero to javafx.fxml;
    exports com.iesfranciscodelosrios.Cajero;
}
