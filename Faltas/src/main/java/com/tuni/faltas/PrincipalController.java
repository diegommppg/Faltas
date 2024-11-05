	package com.tuni.faltas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class PrincipalController implements Initializable {

	//Campos vinculados a la interfaz principal a continuación
	//Labels
    @FXML
    Label NombreLabel;
    
    @FXML
    Label ApellidosLabel;
    
    @FXML
    Label FaltasLabel;
    
    //Textfields
    @FXML
    TextField NombreTextField;
    
    @FXML
    TextField ApellidosTextField;
    
    @FXML
    TextField FaltasTextField;
    
    //Botones
    @FXML
    Button EliminarAlumnoButton;
	
    @FXML
    Button GuardarCambiosButton;
    
    //Comboboxes
	@FXML
    private ComboBox<Curso> CursosComboBox;
    
    @FXML
    private ComboBox<Asignatura> AsignaturasComboBox;
    
    @FXML
    private ComboBox<Alumno> AlumnosComboBox;
	
    //Método que hace que al iniciar la interfaz, añadiendo valores al combobox y seleccionando por defecto un alumno
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Alumno Rodo = new Alumno("Rodolfo", "Díaz", 6);
		Alumno Luis = new Alumno("Luis", "Iturrioz", 10);
		
		ArrayList<Asignatura> asignaturas1DAM = new ArrayList<>();
		ArrayList<Alumno> aSisin = new ArrayList<>();
		aSisin.add(new Alumno("Rodolfo", "Díaz", 6));
		asignaturas1DAM.add(new Asignatura("SiSin" ,aSisin));
		ArrayList<Alumno> aProg = new ArrayList<>();
		aProg.add(new Alumno("Rodolfo", "Díaz", 6));
		asignaturas1DAM.add(new Asignatura("Programacion", aProg));
		ArrayList<Alumno> aBadat = new ArrayList<>();
		aBadat.add(new Alumno("Rodolfo", "Díaz", 6));
		asignaturas1DAM.add(new Asignatura("BADAT", aBadat));
		ArrayList<Alumno> aEndes = new ArrayList<>();
		aEndes.add(new Alumno("Rodolfo", "Díaz", 6));
		asignaturas1DAM.add(new Asignatura("ENDES", aEndes));
		ArrayList<Alumno> aFol = new ArrayList<>();
		aFol.add(new Alumno("Rodolfo", "Díaz", 6));
		asignaturas1DAM.add(new Asignatura("FOL", aFol));
		ArrayList<Alumno> aMarcas = new ArrayList<>();
		aMarcas.add(new Alumno("Rodolfo", "Díaz", 6));
		asignaturas1DAM.add(new Asignatura("Marcas", aMarcas));
		
		ArrayList<Asignatura> asignaturas2DAM = new ArrayList<>();
		ArrayList<Alumno> aSGem = new ArrayList<>();
		aSGem.add(new Alumno("Luis", "Iturrioz", 10));
		asignaturas2DAM.add(new Asignatura("SGEM", aSGem));
		ArrayList<Alumno> aDesin = new ArrayList<>();
		aDesin.add(new Alumno("Luis", "Iturrioz", 10));
		asignaturas2DAM.add(new Asignatura("DESIN", aDesin));
		ArrayList<Alumno> aPMDM = new ArrayList<>();
		aPMDM.add(new Alumno("Luis", "Iturrioz", 10));
		asignaturas2DAM.add(new Asignatura("PMDM", aPMDM));
		ArrayList<Alumno> aEIE = new ArrayList<>();
		aEIE.add(new Alumno("Luis", "Iturrioz", 10));
		asignaturas2DAM.add(new Asignatura("EIE", aEIE));
		ArrayList<Alumno> aPSPR = new ArrayList<>();
		aPSPR.add(new Alumno("Luis", "Iturrioz", 10));
		asignaturas2DAM.add(new Asignatura("PSPR", aPSPR));
		ArrayList<Alumno> aADT = new ArrayList<>();
		aADT.add(new Alumno("Luis", "Iturrioz", 10));
		asignaturas2DAM.add(new Asignatura("ADT", aADT));
		
		Curso PDAM = new Curso("1DAM", asignaturas1DAM);
		Curso SDAM = new Curso("2DAM", asignaturas2DAM);
		
		CursosComboBox.getItems().addAll(PDAM);
		CursosComboBox.getItems().addAll(SDAM);
		
	}


	//Método que se encarga de comprobar si el alumno cuyos datos se quieren guardar ya existe en el programa o si ha de añadirse,
	//en caso de ya existir se actualiza el número de faltas
	@FXML
	public void GuardarCambios() {
		
		boolean contained = false;
		
		String nombre = NombreTextField.getText();
		String apellidos = ApellidosTextField.getText();	
		int faltas = Integer.parseInt(FaltasTextField.getText());
        Alumno nuevoAlumno = new Alumno(nombre, apellidos, faltas);
        ArrayList<Alumno> alumnos = AsignaturasComboBox.getValue().getAlumnos();
		
		for (Alumno a: alumnos) {
			if ((a.getNombre().equals(nombre)) && (a.getApellidos().equals(apellidos))) {
				contained = true;
				AlumnosComboBox.getValue().setFaltas(faltas);
			} 
		}
		
		if (!contained) {
			alumnos.add(nuevoAlumno);
			AlumnosComboBox.getItems().clear();
			AlumnosComboBox.getItems().addAll(alumnos);
		}
		
	}
	
	
	@FXML
	public void mostrarAsignaturas() {
        Curso selectedCurso = CursosComboBox.getValue();
        if (selectedCurso != null) {
        	AsignaturasComboBox.getItems().clear();
        	AsignaturasComboBox.getItems().addAll(selectedCurso.getAsignaturas());
        	AsignaturasComboBox.getSelectionModel().clearSelection(); 
        }
	}
	
	@FXML
	public void mostrarAlumnos() {
        Asignatura selectedAsignatura = AsignaturasComboBox.getValue();
        if (selectedAsignatura != null) {
            AlumnosComboBox.getItems().clear(); 
            AlumnosComboBox.getItems().addAll(selectedAsignatura.getAlumnos()); 
            AlumnosComboBox.getSelectionModel().clearSelection(); 
        }
	}
	
	@FXML
	public void mostrarDatosAlumno() {
		Alumno selectedAlumno = AlumnosComboBox.getValue();
		if(selectedAlumno != null) {
			NombreTextField.setText(selectedAlumno.getNombre());
			ApellidosTextField.setText(selectedAlumno.getApellidos());
			FaltasTextField.setText(Integer.toString(selectedAlumno.getFaltas()));
		}
	}
	
	//Método que elimina los datos de el alumno seleccionado después de comprobar que efectivamente está presente en la base
	@FXML
	public void eliminar() {
		
		String nombre = NombreTextField.getText();
		String apellido = ApellidosTextField.getText();
		NombreTextField.clear();
		ApellidosTextField.clear();
		FaltasTextField.clear();
        ArrayList<Alumno> alumnos = AsignaturasComboBox.getValue().getAlumnos();
		
		Alumno alumnoEliminar = null;
		
		for (Alumno a: alumnos) {
			if ((a.getNombre().equals(nombre)) && (a.getApellidos().equals(apellido))) {
				alumnoEliminar = a;
			} 
		}
		
		if (alumnoEliminar != null) {
			alumnos.remove(alumnoEliminar);
			AlumnosComboBox.getItems().clear();
			AlumnosComboBox.getItems().addAll(alumnos);
		}
		
		
	}
    
}
