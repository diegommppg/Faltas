package iuyt.test;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Cursos implements Initializable {
	
	@FXML
	Button buttonEliminarCurso;
	
	@FXML
	Button buttonAniadirCurso;
	
	@FXML
	Button buttonGuardarCambios;
	
	@FXML 
	TextField textFieldNombre;
	
	@FXML
	ComboBox<String> comboBoxCursos;
	
	
	
	@FXML
	private void aniadirAsignatura() {
        try {
           App.setRoot("Asignatura");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	@FXML
	private void eliminarCurso() {
		if(comboBoxCursos.getItems().contains(textFieldNombre.getText())) {
			comboBoxCursos.getItems().remove(textFieldNombre.getText());
		}
		textFieldNombre.clear();
	}
	
	@FXML
	private void guardarCambios() {
		String nombre = textFieldNombre.getText();
		String seleccion = comboBoxCursos.getValue();
		
		if(!nombre.isEmpty()) {
			if(seleccion!=null) {
				int index = comboBoxCursos.getItems().indexOf(seleccion);
				comboBoxCursos.getItems().set(index, nombre);
			}else {
				comboBoxCursos.getItems().add(nombre);
			}
		}
		textFieldNombre.clear();
	}

	
	@FXML
	private void recibirCurso() {
		String nombre = textFieldNombre.getText();
		if(nombre!=null) {
			comboBoxCursos.getItems().add(nombre);
			textFieldNombre.clear();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		comboBoxCursos.getItems().addAll("Curso 1", "Curso 2", "Curso 3");
		
		//añadir botones
		comboBoxCursos.setOnAction(e ->{recibirCurso();});
		buttonAniadirCurso.setOnAction(e ->{aniadirAsignatura();});
		buttonEliminarCurso.setOnAction(e ->{eliminarCurso();});
		buttonGuardarCambios.setOnAction(e ->{guardarCambios();});
		
		
	}


}

