module com.tuni.faltas {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires javafx.base;

    opens com.tuni.faltas to javafx.fxml;
    exports com.tuni.faltas;
}
