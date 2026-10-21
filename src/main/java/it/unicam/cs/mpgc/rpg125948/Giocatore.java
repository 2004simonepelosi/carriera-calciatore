package it.unicam.cs.mpgc.rpg125948;

public class Giocatore {

    private String nome;
    private String cognome;

    private String ruolo;

    private String squadra;
    private static final int STATISTICA_INIZIALE = 40;

    private int eta;
    private int velocita = STATISTICA_INIZIALE;
    private int tiro = STATISTICA_INIZIALE;
    private int passaggio = STATISTICA_INIZIALE;
    private int difesa = STATISTICA_INIZIALE;

    private int stanchezza = 0;

    public Giocatore(String nome, String cognome, String ruolo, String squadra, int eta) {

        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
        this.squadra = squadra;
        this.eta = eta;


    }

}
