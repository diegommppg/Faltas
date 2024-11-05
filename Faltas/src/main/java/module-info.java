module com.tuni.faltas {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.tuni.faltas to javafx.fxml;
    exports com.tuni.faltas;
}
