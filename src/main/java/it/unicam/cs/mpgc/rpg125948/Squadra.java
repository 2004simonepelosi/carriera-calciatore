package it.unicam.cs.mpgc.rpg125948;
import java.io.Serializable;
public class Squadra implements Serializable{

    private final String nome;
    private final int forza;
    private static final int FORZA_MASSIMA = 100;
    private static final int FORZA_MINIMA = 1;



    public Squadra(String nome, int forza) {
        if (forza > FORZA_MASSIMA || forza<FORZA_MINIMA) {
            throw new IllegalArgumentException("Il limite massimo è : " + FORZA_MASSIMA + " " + "Il limite minimo è : " + FORZA_MINIMA);
        }
        this.nome = nome;
        this.forza = forza;
    }

    public String getNome() {
        return nome;
    }

    public int getForza() {
        return forza;
    }

    @Override
    public String toString() {
        return  nome + " (forza " + forza + ")";
    }
}
