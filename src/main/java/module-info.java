module com.tuni.faltas {
    requires javafx.controls;
    requires javafx.fxml;
	requires com.dmm.primer_javafx;

    opens com.tuni.faltas to javafx.fxml;
    exports com.tuni.faltas;
}
