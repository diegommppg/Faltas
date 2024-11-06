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
	
	//boton para eliminar un curso
	@FXML
	Button buttonEliminarCurso;
	
	//boton para añadir una asignatura
	@FXML
	Button buttonAniadirCurso;
	
	//boton para guardar los cambios
	@FXML
	Button buttonGuardarCambios;
	
	//texto para el nombre del curso
	@FXML 
	TextField textFieldNombre;
	
	//ComboBox para seleccionar cursos
	@FXML
	ComboBox<String> comboBoxCursos;
	
	
	//metodo para cambia la vista a "Asignatura"
	@FXML
	private void aniadirAsignatura() {
        try {
           App.setRoot("Asignatura");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	//metodo para eliminar curso
	@FXML
	private void eliminarCurso() {
		if(comboBoxCursos.getItems().contains(textFieldNombre.getText())) {
			comboBoxCursos.getItems().remove(textFieldNombre.getText());//elimina el curso del ComboBox si existe
		}
		textFieldNombre.clear();//limpia el campo de texto
	}
	
	@FXML
	private void guardarCambios() {
		String nombre = textFieldNombre.getText();
		String seleccion = comboBoxCursos.getValue();
		
		if(!nombre.isEmpty()) {
			if(seleccion!=null) {
				int index = comboBoxCursos.getItems().indexOf(seleccion);
				comboBoxCursos.getItems().set(index, nombre);//actualiza el nombre del curso seleccionado
			}else {
				comboBoxCursos.getItems().add(nombre);//añade un nuevo curso si no hay ninguno seleccionado
			}
		}
		textFieldNombre.clear();
	}

	
	@FXML
	private void recibirCurso() {
		String nombre = textFieldNombre.getText();
		if(nombre!=null) {
			comboBoxCursos.getItems().add(nombre);//añade el curso al ComboBox
			textFieldNombre.clear();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//eleemntos por defecto añadidos al combobox
		comboBoxCursos.getItems().addAll("Curso 1", "Curso 2", "Curso 3");
		
		//añadir botones
		comboBoxCursos.setOnAction(e ->{recibirCurso();});
		buttonAniadirCurso.setOnAction(e ->{aniadirAsignatura();});
		buttonEliminarCurso.setOnAction(e ->{eliminarCurso();});
		buttonGuardarCambios.setOnAction(e ->{guardarCambios();});
		
		
	}


}

