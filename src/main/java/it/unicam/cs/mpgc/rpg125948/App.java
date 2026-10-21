package it.unicam.cs.mpgc.rpg125948;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Label titolo = new Label("Carriera da calciatore");
        Scene scena = new Scene(titolo, 400, 300);
        stage.setTitle("Carriera da calciatore");
        stage.setScene(scena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}