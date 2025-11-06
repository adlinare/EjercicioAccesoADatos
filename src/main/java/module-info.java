module com.prueba {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.base;

    opens com.prueba to javafx.fxml;
    exports com.prueba;
}
