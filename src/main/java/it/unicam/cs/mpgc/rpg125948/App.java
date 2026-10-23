package it.unicam.cs.mpgc.rpg125948;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Random;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        Squadra s =new Squadra("Roma", 50);
        Giocatore g = new Giocatore("Simone", "pelosi", Ruolo.DIFENSORE, s, 22);

        Label giocatore = new Label("nome: " + g.getNome() + "cognome: " + g.getCognome() + "nome squadra: " + g.getSquadra().getNome() );
        Label statistiche = new Label("Tiro: " + g.getTiro() );
        Label stanchezza = new Label("Stanchezza: " + g.getStanchezza() );
        Button bottoneallena = new Button("Allena Tiro");
        Button bottoneriposati = new Button("Riposa");
        SimulatorePartita simulatore = new SimulatorePartita(new Random());
        Squadra avversario = new Squadra("Lazio", 60);
        Label risultato = new Label("Nessuna partita giocata");
        Button bottoneGioca = new Button("Gioca partita");

        bottoneGioca.setOnAction(e -> {
            Partita partita = simulatore.gioca(g, avversario);
            risultato.setText(partita.toString());
        });
        bottoneallena.setOnAction(e -> {
            g.allenati(Statistica.TIRO);
            g.allenati(Statistica.VELOCITA);
            g.allenati(Statistica.PASSAGGIO);
            g.allenati(Statistica.DIFESA);


            statistiche.setText("nuove stats!" + g.getTiro());
            stanchezza.setText("stanchezza" + g.getStanchezza());
        });


        bottoneriposati.setOnAction(e -> {
            g.riposa();
            stanchezza.setText("stanchezza" + g.getStanchezza());

        });



        VBox box = new VBox(10);              // 10 = spazio in pixel tra gli elementi
        box.getChildren().addAll(giocatore, statistiche,stanchezza,bottoneallena,bottoneriposati,bottoneGioca,risultato);

        Scene scena = new Scene(box, 400, 300);   // ora la Scene contiene il VBox
        stage.setScene(scena);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}