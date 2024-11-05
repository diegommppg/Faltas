package com.tuni.faltas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;
import java.util.List;

public class InterfazCursosController {

    @FXML
    private TextField nombreTextField;
    @FXML
    private ComboBox<String> cursosComboBox;
    @FXML
    private Button eliminarCursoButton;
    @FXML
    private Button guardarCambiosButton;
    @FXML
    private Button anadirAsignaturaButton;

    private List<String> cursosList;

    @FXML
    public void initialize() {
        // Inicializa la lista de cursos
        cursosList = new ArrayList<>();

        // Configura la acción para el botón "Añadir Asignatura"
        anadirAsignaturaButton.setOnAction(event -> openAsignaturaInterface());

        // Configura la acción para el botón "Guardar Cambios"
        guardarCambiosButton.setOnAction(event -> saveCurso());

        // Configura la acción para el botón "Eliminar Curso"
        eliminarCursoButton.setOnAction(event -> deleteCurso());

        // Rellena el ComboBox con los cursos existentes
        updateCursosComboBox();
    }

    private void openAsignaturaInterface() {
        try {
            MainApp.setRoot("asignatura"); // Asume que existe un archivo "asignatura.fxml" para la interfaz de Asignatura
        } catch (Exception e) {
            showErrorAlert("Error", "No se pudo abrir la interfaz de Asignatura.");
        }
    }

    private void saveCurso() {
        String cursoName = nombreTextField.getText();

        if (cursoName == null || cursoName.trim().isEmpty()) {
            showErrorAlert("Entrada inválida", "Por favor, ingrese un nombre de curso válido.");
            return;
        }

        if (!cursosList.contains(cursoName)) {
            cursosList.add(cursoName);
        } else {
            cursosList.set(cursosList.indexOf(cursoName), cursoName); // Actualiza el curso si ya existe
        }

        updateCursosComboBox();
        showInfoAlert("Éxito", "Curso guardado correctamente.");
    }

    private void deleteCurso() {
        String selectedCurso = cursosComboBox.getValue();

        if (selectedCurso == null) {
            showErrorAlert("Sin selección", "Por favor, seleccione un curso para eliminar.");
            return;
        }

        cursosList.remove(selectedCurso);
        updateCursosComboBox();
        showInfoAlert("Eliminado", "Curso eliminado correctamente.");
    }

    private void updateCursosComboBox() {
        cursosComboBox.getItems().clear();
        cursosComboBox.getItems().addAll(cursosList);
        cursosComboBox.setValue(null);
    }

    private void showErrorAlert(String title, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showInfoAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
