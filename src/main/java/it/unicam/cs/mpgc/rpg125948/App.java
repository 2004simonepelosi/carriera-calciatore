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
    private Carriera carriera;
    private Label settimana;
    private Label stagione;
    private Label riepilogo;
    private Label statistiche;
    private Label stanchezza;
    @Override
    public void start(Stage stage) {

        Squadra miaSquadra = new Squadra("Roma", 50);
        Giocatore g = new Giocatore("Simone", "Pelosi", Ruolo.ATTACCANTE, miaSquadra, 22);
        List<Squadra> avversari = List.of(
                new Squadra("Lazio", 60),
                new Squadra("Napoli", 70),
                new Squadra("Empoli", 40)
        );
        carriera = new Carriera(g, new SimulatorePartita(new Random()), avversari);
        Label giocatore = new Label(g.getNome() + " " + g.getCognome()
                + " (" + g.getRuolo().getAbbreviazione() + ") - " + g.getSquadra().getNome());
        settimana = new Label("Settimana: " + carriera.getSettimana());


        stagione = new Label("Stagione " + carriera.getStagioneCorrente().getNumero()
                + " - Partite " + carriera.getStagioneCorrente().getPartite().size()
                + "/" + Stagione.PARTITE_PER_STAGIONE);

        riepilogo = new Label("Nessuna stagione conclusa");


        statistiche = new Label("Tiro: " + g.getTiro());
        stanchezza = new Label("Stanchezza: " + g.getStanchezza());
        Label risultato = new Label("Nessuna partita giocata");
        aggiorna();

        Button bottoneAllena = new Button("Allena tiro");
        Button bottoneRiposa = new Button("Riposa");

        bottoneAllena.setOnAction(e -> {
            Partita partita = carriera.allenati(Statistica.TIRO);
            risultato.setText(partita.toString());
            aggiorna();
        });

        bottoneRiposa.setOnAction(e -> {
            Partita partita = carriera.riposa();
            risultato.setText(partita.toString());
            aggiorna();
        });

        VBox box = new VBox(10);
        box.getChildren().addAll(giocatore, settimana, stagione, riepilogo, statistiche, stanchezza,
                bottoneAllena, bottoneRiposa, risultato);

        Scene scena = new Scene(box, 400, 300);
        stage.setTitle("Carriera da calciatore");
        stage.setScene(scena);
        stage.show();
    }

    private void aggiorna() {
        Giocatore g = carriera.getGiocatore();

        settimana.setText("Settimana: " + carriera.getSettimana());
        stagione.setText("Stagione " + carriera.getStagioneCorrente().getNumero()
                + " - Partite " + carriera.getStagioneCorrente().getPartite().size()
                + "/" + Stagione.PARTITE_PER_STAGIONE);
        statistiche.setText("Tiro: " + g.getTiro());
        stanchezza.setText("Stanchezza: " + g.getStanchezza());

        List<Stagione> concluse = carriera.getStagioniConcluse();
        if (!concluse.isEmpty()) {
            Stagione ultima = concluse.get(concluse.size() - 1);
            riepilogo.setText("Stagione " + ultima.getNumero() + " conclusa - media voto "
                    + String.format("%.2f", ultima.getMediaVoto())
                    + ", gol " + ultima.getGolTotali());
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}