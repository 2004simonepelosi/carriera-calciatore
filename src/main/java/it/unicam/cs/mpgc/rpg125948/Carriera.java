package it.unicam.cs.mpgc.rpg125948;

import java.util.ArrayList;
import java.util.List;

public class Carriera {

    private final Giocatore giocatore;
    private final SimulatorePartita simulatore;
    private final List<Squadra> avversari;
    private final List<Partita> partite = new ArrayList<>();
    private int settimana = 1;

    public Carriera(Giocatore giocatore, SimulatorePartita simulatore, List<Squadra> avversari) {
        if (avversari.isEmpty()) {
            throw new IllegalArgumentException("Serve almeno una squadra avversaria");
        }
        this.giocatore = giocatore;
        this.simulatore = simulatore;
        this.avversari = List.copyOf(avversari);
    }

    public Partita allenati(Statistica statistica) {
        giocatore.allenati(statistica);
        return giocaPartita();
    }

    public Partita riposa() {
        giocatore.riposa();
        return giocaPartita();
    }

    private Partita giocaPartita() {
        Squadra avversario = avversari.get((settimana - 1) % avversari.size());
        Partita partita = simulatore.gioca(giocatore, avversario);
        partite.add(partita);
        giocatore.affaticaDopoPartita();
        settimana++;
        return partita;
    }

    public Giocatore getGiocatore() {
        return giocatore;
    }

    public int getSettimana() {
        return settimana;
    }

    public List<Partita> getPartite() {
        return List.copyOf(partite);
    }
}