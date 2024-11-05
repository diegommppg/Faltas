package com.tuni.faltas;

import java.net.URL;

import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class InterfazCursosController implements Initializable {

    @FXML
     Button AddAsignatura;

    @FXML
     Button EliminarCurso;

    @FXML
     Button GuardarCambios;

    @FXML
     ComboBox<String> comboCursos; // Especificar tipo String

    @FXML
     TextField nombre;

    @FXML
     Text text;


  //Añadimos un curso
	  private void crearCurso() {
	        String nombreCurso = nombre.getText();
	        if (!nombreCurso.isEmpty()) {
	            comboCursos.getItems().add(nombreCurso);
	            nombre.clear();
	            System.out.println("Curso creado: " + nombreCurso);
	        }
	    }

	@FXML
	//Guardamos cambios
	private void guardarCambios() {
      String nombreCurso = nombre.getText();
      String cursoSeleccionado = comboCursos.getValue();
      if (!nombreCurso.isEmpty()) {
          if (cursoSeleccionado != null) {
              // Actualizar el curso seleccionado
              int index = comboCursos.getItems().indexOf(cursoSeleccionado);
              comboCursos.getItems().set(index, nombreCurso);
              System.out.println("Curso actualizado a: " + nombreCurso);
          } else {
              // Crear un nuevo curso si no está seleccionado
              comboCursos.getItems().add(nombreCurso);
              System.out.println("Curso creado: " + nombreCurso);
          }
          nombre.clear();
      }
  }

	@FXML
	//Eliminamos un curso
  private void eliminarCurso() {
      String cursoSeleccionado = comboCursos.getValue();
      if (cursoSeleccionado != null) {
          comboCursos.getItems().remove(cursoSeleccionado);
          nombre.clear();
          System.out.println("Curso eliminado: " + cursoSeleccionado);
      }
  }

	@FXML
  private void abrirVentanaAsignatura() {
      try {
         MainApp.setRoot("Asignatura");
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Añadir cursos
		comboCursos.getItems().addAll("Primer Curso", "Segundo Curso");
		
		// Anadir botones
		comboCursos.setOnAction(e -> crearCurso());
		GuardarCambios.setOnAction(e -> guardarCambios());
		EliminarCurso.setOnAction(e -> eliminarCurso());	
		AddAsignatura.setOnAction(e -> abrirVentanaAsignatura());
	}

}
