package it.unicam.cs.mpgc.rpg125948;

import java.util.Random;
import java.io.Serializable;

public class SimulatorePartita implements Serializable{

    private static final int VOTO_BASE = 6;
    private static final int DIVISORE_DIFFERENZA = 10;
    private static final int DIVISORE_STANCHEZZA = 40;

    private static final int DIVISORE_TIRO = 3;
        private static final int BONUS_VOTO_PER_GOL = 1;


    private final Random random;

    public SimulatorePartita(Random random) {
        this.random = random;
    }

    public Partita gioca(Giocatore giocatore, Squadra avversario) {
        int gol = calcolaGol(giocatore);

        int voto = calcolaVoto(giocatore, avversario,gol);
        return new Partita(avversario, voto, gol);
    }

    private int calcolaVoto(Giocatore giocatore, Squadra avversario, int gol) {
        int differenza = giocatore.getMediaStatistiche() - avversario.getForza();
        int voto = VOTO_BASE + differenza / DIVISORE_DIFFERENZA - giocatore.getStanchezza() / DIVISORE_STANCHEZZA + random.nextInt(-1, 2)+(gol*BONUS_VOTO_PER_GOL);          // -1, 0 oppure +1

        return Math.max(Partita.VOTO_MINIMO, Math.min(Partita.VOTO_MASSIMO, voto));
    }

    private int calcolaGol(Giocatore giocatore) {
        int probabilita = giocatore.getTiro() / DIVISORE_TIRO;
        int gol = 0;
        for (int i = 0; i < giocatore.getRuolo().getOccasioniPerPartita(); i++) {
            if (random.nextInt(100) < probabilita) {
                gol++;
            }
        }
        return gol;
    }
}