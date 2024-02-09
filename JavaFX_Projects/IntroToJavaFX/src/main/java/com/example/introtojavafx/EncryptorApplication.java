package com.example.introtojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EncryptorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EncryptorApplication.class.getResource("Encryptor-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Encryption Application V1.0");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}