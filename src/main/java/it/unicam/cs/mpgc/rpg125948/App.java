package it.unicam.cs.mpgc.rpg125948;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.IOException;

public class App extends Application {
    private Carriera carriera;
    private Label settimana;
    private Label stagione;
    private Label riepilogo;
    private Label eta;

    private Label statistiche;
    private Label stanchezza;

    private final ArchivioCarriera archivio = new ArchivioCarrieraFile(new File("carriera.sav"));
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
        settimana = new Label();


        stagione = new Label();
        eta = new Label();


        riepilogo = new Label("Nessuna stagione conclusa");


        statistiche = new Label();
        stanchezza = new Label();
        Label risultato = new Label("Nessuna partita giocata");
        aggiorna();
        ComboBox<Statistica> sceltaStatistica = new ComboBox<>();
        sceltaStatistica.getItems().addAll(Statistica.values());
        sceltaStatistica.setValue(Statistica.TIRO);
        Button bottoneAllena = new Button("Allena");
        Button bottoneRiposa = new Button("Riposa");

        bottoneAllena.setOnAction(e -> {
            Partita partita = carriera.allenati(sceltaStatistica.getValue());
            risultato.setText(partita.toString());
            aggiorna();
        });

        bottoneRiposa.setOnAction(e -> {
            Partita partita = carriera.riposa();
            risultato.setText(partita.toString());
            aggiorna();
        });

        Button bottoneSalva = new Button("Salva");
        bottoneSalva.setOnAction(e -> {
            try {
                archivio.salva(carriera);
                risultato.setText("Carriera salvata");
            } catch (IOException ex) {
                risultato.setText("Errore nel salvataggio: " + ex.getMessage());
            }
        });

        Button bottoneCarica = new Button("Carica");
        bottoneCarica.setOnAction(e -> {
            try {
                carriera = archivio.carica();
                aggiorna();
                risultato.setText("Carriera caricata");
            } catch (IOException ex) {
                risultato.setText("Nessun salvataggio trovato");
            }
        });

        VBox box = new VBox(10);
        box.getChildren().addAll(giocatore, eta, settimana, stagione, riepilogo, statistiche, stanchezza,sceltaStatistica,
                bottoneAllena, bottoneRiposa,bottoneSalva, bottoneCarica,risultato);

        Scene scena = new Scene(box, 500, 450);
        stage.setTitle("Carriera da calciatore");
        stage.setScene(scena);
        stage.show();
    }

    private void aggiorna() {
        Giocatore g = carriera.getGiocatore();

        settimana.setText("Settimana: " + carriera.getSettimana());
        stagione.setText("Stagione " + carriera.getStagioneCorrente().getNumero() + " - Partite " + carriera.getStagioneCorrente().getPartite().size() + "/" + Stagione.PARTITE_PER_STAGIONE);
        statistiche.setText("Velocità: " + g.getVelocita()
                + "  Difesa: " + g.getDifesa()
                + "  Tiro: " + g.getTiro()
                + "  Passaggio: " + g.getPassaggio());
        stanchezza.setText("Stanchezza: " + g.getStanchezza());
        eta.setText("Età: " + g.getEta());


        List<Stagione> concluse = carriera.getStagioniConcluse();
        if (!concluse.isEmpty()) {
            Stagione ultima = concluse.get(concluse.size() - 1);
            riepilogo.setText("Stagione " + ultima.getNumero() + " conclusa - media voto "
                    + String.format("%.2f", ultima.getMediaVoto())
                    + ", gol " + ultima.getGolTotali());
        }else {
            riepilogo.setText("Nessuna stagione conclusa");
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}