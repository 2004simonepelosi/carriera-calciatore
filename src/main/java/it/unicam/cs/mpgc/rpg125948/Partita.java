package it.unicam.cs.mpgc.rpg125948;
import java.io.Serializable;

public class Partita implements Serializable{


    private final Squadra avversario;
    private final int voto;
    private final int gol;
    public static final int VOTO_MASSIMO = 10;
    public static final int VOTO_MINIMO = 1;



    public Partita(Squadra avversario, int voto, int gol) {
        if (voto > VOTO_MASSIMO || voto<VOTO_MINIMO) {
            throw new IllegalArgumentException("Il VOTO massimo è : " + VOTO_MASSIMO + " " + "Il VOTO minimo è : " + VOTO_MINIMO);
        } else if (gol < 0) {
            throw new IllegalArgumentException("il gol deve essere un valore >= 0 ");
        }
        this.avversario = avversario;
        this.voto = voto;
        this.gol = gol;
    }

    public Squadra getAvversario() {
        return avversario;
    }

    public int getVoto() {
        return voto;
    }

    public int getGol() {
        return gol;
    }

    public boolean isBuonaPrestazione() {
        return voto >= 7;
    }
    @Override
    public String toString() {
        return  "vs " + avversario.getNome() + " - voto " + voto + ", " + gol + " gol";
    }
}
