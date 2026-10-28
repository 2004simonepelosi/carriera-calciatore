package it.unicam.cs.mpgc.rpg125948;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
public class Stagione implements Serializable {
    public static final int PARTITE_PER_STAGIONE = 10;


    private final int numero;
    private final List<Partita> partite = new ArrayList<>();

    public Stagione(int numero) {
        this.numero = numero;
    }



    public void aggiungiPartita(Partita partita){
        if (isFinita()) {
            throw new IllegalStateException("La stagione " + numero + " è già finita");
        }
        partite.add(partita);
    }

    public boolean isFinita(){
        return partite.size() >= PARTITE_PER_STAGIONE;
    }
    public double getMediaVoto() {
        if (partite.isEmpty()) {
            return 0;
        }
        int sommaVoti = 0;
        for (Partita partita : partite) {
            sommaVoti += partita.getVoto();
        }
        return (double) sommaVoti / partite.size();
    }

    public int getGolTotali() {
        int gol = 0;
        for (Partita partita : partite) {
            gol += partita.getGol();
        }
        return gol;
    }
    public List<Partita> getPartite() {
        return List.copyOf(partite);
    }
    public int getNumero() {
        return numero;
    }


}
