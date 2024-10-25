package com.tuni.faltas;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * JavaFX App
 */
public class MainApp extends Application implements Initializable {

	private static Scene scene;

	@FXML
	private ComboBox<String> cbCursos;
	@FXML
	private ComboBox<String> cbAsignaturas;
	
	private String[] cursos = {"1ºDAM", "1ºDAW", "2ºDAM", "2ºDAW"};
	
	@FXML
	private ComboBox<String> cbAlumnos;

	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("principal"), 640, 480);
		stage.setScene(scene);
		stage.show();

	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
			
		cbCursos.getItems().addAll(cursos);
		
	}

}