package com.tuni.faltas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class MainApp extends Application {

    private static Scene scene;

    @FXML
    Label NombreLabel;
    
    @FXML
    Label ApellidosLabel;
    
    @FXML
    Label FaltasLabel;
    
    @FXML
    TextField NombreTextField;
    
    @FXML
    TextField ApellidosTextField;
    
    @FXML
    TextField FaltasTextField;
    
    @FXML
    ComboBox CursosComboBox;
    
    @FXML
    ComboBox AsignaturasComboBox;
    
    @FXML
    ComboBox AlumnosComboBox;

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


}