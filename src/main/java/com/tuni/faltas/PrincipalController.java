package com.tuni.faltas;

import java.io.IOException;

import com.samuel.PrimerProyectoMaven_DesinT2.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;

public class PrincipalController {

	@FXML
    private Button buttonConfi;

    @FXML
    private Button buttonPoner;

    @FXML
    private ComboBox<?> comboBoxAsig;

    @FXML
    private ComboBox<?> comboBoxCurso;

    @FXML
    private RadioButton radioButton1Hora;

    @FXML
    private RadioButton radioButton2Horas;

    @FXML
    private RadioButton radioButtonJusti;

    @FXML
    private RadioButton radioButtonNoJusti;
	
	@FXML
	public void irAConfig() throws IOException{
		App.setRoot("configuracion");
	}
	
	
	
}