module com.prueba {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.prueba to javafx.fxml;
    exports com.prueba;
}
