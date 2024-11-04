module com.tuni.faltas {
    requires javafx.controls;
    requires javafx.fxml;
	requires com.samuel.PrimerProyectoMaven_DesinT2;

    opens com.tuni.faltas to javafx.fxml;
    exports com.tuni.faltas;
}
