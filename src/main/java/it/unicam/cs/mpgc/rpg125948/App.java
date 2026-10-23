package it.unicam.cs.mpgc.rpg125948;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Giocatore g = new Giocatore("Simone", "pelosi", Ruolo.DIFENSORE, "Roma", 22);
        g.allenati(Statistica.TIRO);
        System.out.println(g.getTiro());
        g.riposa();
        System.out.println(g.getStanchezza());

        Label giocatore = new Label("nome: " + g.getNome() + "cognome: " + g.getCognome() );
        Label statistiche = new Label("tiro: " + g.getTiro() );
        Label stanchezza = new Label("stanchezza: " + g.getStanchezza() );
        Button bottone = new Button("Allena Tiro");
        Button bottone1 = new Button("Riposa");

        bottone.setOnAction(e -> {
            g.allenati(Statistica.TIRO);

            statistiche.setText("nuove stats!" + g.getTiro());
            stanchezza.setText("stanchezza" + g.getStanchezza());
        });


        bottone1.setOnAction(e -> {
            g.riposa();
            stanchezza.setText("stanchezza" + g.getStanchezza());

        });



        VBox box = new VBox(10);              // 10 = spazio in pixel tra gli elementi
        box.getChildren().addAll(giocatore, statistiche,stanchezza,bottone,bottone1);

        Scene scena = new Scene(box, 400, 300);   // ora la Scene contiene il VBox
        stage.setScene(scena);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}