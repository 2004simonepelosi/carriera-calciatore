package it.unicam.cs.mpgc.rpg125948;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Random;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        Squadra miaSquadra = new Squadra("Roma", 50);
        Giocatore g = new Giocatore("Simone", "Pelosi", Ruolo.ATTACCANTE, miaSquadra, 22);
        List<Squadra> avversari = List.of(
                new Squadra("Lazio", 60),
                new Squadra("Napoli", 70),
                new Squadra("Empoli", 40)
        );
        Carriera carriera = new Carriera(g, new SimulatorePartita(new Random()), avversari);

        Label giocatore = new Label(g.getNome() + " " + g.getCognome()
                + " (" + g.getRuolo().getAbbreviazione() + ") - " + g.getSquadra().getNome());
        Label settimana = new Label("Settimana: " + carriera.getSettimana());
        Label statistiche = new Label("Tiro: " + g.getTiro());
        Label stanchezza = new Label("Stanchezza: " + g.getStanchezza());
        Label risultato = new Label("Nessuna partita giocata");

        Button bottoneAllena = new Button("Allena tiro");
        Button bottoneRiposa = new Button("Riposa");

        bottoneAllena.setOnAction(e -> {
            Partita partita = carriera.allenati(Statistica.TIRO);
            risultato.setText(partita.toString());
            statistiche.setText("Tiro: " + carriera.getGiocatore().getTiro());
            stanchezza.setText("Stanchezza: " + carriera.getGiocatore().getStanchezza());
            settimana.setText("Settimana: " + carriera.getSettimana());
        });

        bottoneRiposa.setOnAction(e -> {
            Partita partita = carriera.riposa();
            risultato.setText(partita.toString());
            statistiche.setText("Tiro: " + carriera.getGiocatore().getTiro());
            stanchezza.setText("Stanchezza: " + carriera.getGiocatore().getStanchezza());
            settimana.setText("Settimana: " + carriera.getSettimana());
        });

        VBox box = new VBox(10);
        box.getChildren().addAll(giocatore, settimana, statistiche, stanchezza,
                bottoneAllena, bottoneRiposa, risultato);

        Scene scena = new Scene(box, 400, 300);
        stage.setTitle("Carriera da calciatore");
        stage.setScene(scena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}