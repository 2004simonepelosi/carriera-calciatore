package it.unicam.cs.mpgc.rpg125948;

public class Partita {


    private final Squadra avversario;
    private final int voto;
    private final int gol;
    private static final int VOTO_MASSIMO = 10;
    private static final int VOTO_MINIMO = 1;



    public Partita(Squadra avversario, int voto, int gol) {
        if ((voto > VOTO_MASSIMO || voto<VOTO_MINIMO)|| (gol < 0)) {
            throw new IllegalArgumentException("Il VOTO massimo è : " + VOTO_MASSIMO + " " + "Il VOTO minimo è : " + VOTO_MINIMO+ "il gol deve essere un valore > 0 ");
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

    // esempio con Squadra, non serve aggiungerlo
    public boolean isBuonaPrestazione() {
        return voto >= 7;
    }
    public String toString() {
        return  "vs " + avversario.getNome() + " - voto " + voto + ", " + gol + " gol";
    }
}
