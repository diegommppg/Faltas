package com.tuni.faltas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.tuni.faltas.modelo.Asignatura;
import com.tuni.faltas.modelo.Curso;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AsignaturasController implements Initializable {

    @FXML
    private Button buttonAñadirAlumno;
    @FXML
    private Button buttonEliminarAsignatura;
    @FXML
    private Button buttonGuardarCambios;
    @FXML
    private ComboBox<Asignatura> comboBoxAsignaturas;
    @FXML
    private ComboBox<Curso> comboBoxCursos;
    @FXML
    private Label labelHoras;
    @FXML
    private Label labelNombre;
    @FXML
    private TextField textEditNombre;
    @FXML
    private TextField textEditHoras;

    private ObservableList<Asignatura> listAsignatura = FXCollections.observableArrayList();
    private ObservableList<Curso> listCursos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Asignatura pmdm = new Asignatura("PMDM", 30);
        Asignatura desin = new Asignatura("DESIN", 50);
        Asignatura badat = new Asignatura("BADAT", 10);
        Asignatura progr = new Asignatura("PROGR", 20);

        Curso primeroDam = new Curso("1DAM", FXCollections.observableArrayList(badat, progr));
        Curso segundoDam = new Curso("2DAM", FXCollections.observableArrayList(pmdm, desin));

        listCursos.addAll(primeroDam, segundoDam);

        comboBoxAsignaturas.setItems(listAsignatura);
        comboBoxCursos.setItems(listCursos);
    }

    @FXML
    private void botonEliminarAsignatura() {
        Curso cursoSeleccionado = comboBoxCursos.getSelectionModel().getSelectedItem();
        Asignatura asignaturaSeleccionada = comboBoxAsignaturas.getSelectionModel().getSelectedItem();

        if (cursoSeleccionado != null && asignaturaSeleccionada != null) {
            cursoSeleccionado.getAsignatura().remove(asignaturaSeleccionada);
            comboBoxAsignaturas.setItems(cursoSeleccionado.getAsignatura());
        } else {
            System.out.println("Debe seleccionar una asignatura y un curso para borrar");
        }
    }


    @FXML
    private void botonAnadirAlumno() {
        try {
            MainApp.setRoot("interfazAlumno");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void botonGuardarCambios() {
        String nuevoNombreAsignatura = textEditNombre.getText();
        String nuevasHoras = textEditHoras.getText();
        boolean encontrado = false;
        Asignatura asignaturaSeleccionada = comboBoxAsignaturas.getSelectionModel().getSelectedItem();

        if (!nuevoNombreAsignatura.isEmpty() && !nuevasHoras.isEmpty()) {
            for (Asignatura asignatura : listAsignatura) {
                if (asignatura.getNombre().equals(nuevoNombreAsignatura)) {
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                Asignatura nuevaAsignatura = new Asignatura(nuevoNombreAsignatura, Integer.parseInt(nuevasHoras));
                listAsignatura.add(nuevaAsignatura);
            } else {
                if (asignaturaSeleccionada != null) {
                    asignaturaSeleccionada.setHorasTotales(Integer.parseInt(nuevasHoras));
                }
            }
        } else {
            System.out.println("Introduce el nombre y horas de una asignatura");
        }
    }

    @FXML
    private void comboBoxAsignatura() {
        Asignatura asignaturaSeleccionada = comboBoxAsignaturas.getSelectionModel().getSelectedItem();
        if (asignaturaSeleccionada != null) {
            textEditNombre.setText(asignaturaSeleccionada.getNombre());
            textEditHoras.setText(String.valueOf(asignaturaSeleccionada.getHorasTotales()));
        } else {
            textEditNombre.clear();
            textEditHoras.clear();
        }
    }

    @FXML
    private void comboBoxCurso() {
        Curso cursoSeleccionado = comboBoxCursos.getSelectionModel().getSelectedItem();
        if (cursoSeleccionado != null) {
            ObservableList<Asignatura> asignaturas = cursoSeleccionado.getAsignatura();
            listAsignatura.setAll(asignaturas);
            comboBoxAsignaturas.setItems(listAsignatura);
        }
    }
}
