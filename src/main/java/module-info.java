module com.iesfranciscodelosrios.Cajero {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.iesfranciscodelosrios.Cajero to javafx.fxml;
    exports com.iesfranciscodelosrios.Cajero;
}
