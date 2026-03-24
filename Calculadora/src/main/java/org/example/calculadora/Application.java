package org.example.calculadora;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Calculadora.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 360, 480);
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.show();
    }
}
