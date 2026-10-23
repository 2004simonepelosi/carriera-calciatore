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
        Giocatore s = new Giocatore("Simone", "pelosi", Ruolo.DIFENSORE, "Roma", 22);
        s.allenati("tiro");
        System.out.println(s.getTiro());
        s.riposa();
        System.out.println(s.getStanchezza());


        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}