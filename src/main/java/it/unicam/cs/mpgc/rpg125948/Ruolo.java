package it.unicam.cs.mpgc.rpg125948;


public enum Ruolo {
    PORTIERE("POR",0),
    DIFENSORE("DIF",1),
    CENTROCAMPISTA("CEN",2),
    ATTACCANTE("ATT",3);

    private final String abbreviazione;



    private int occasioniPerPartita;

    public int getOccasioniPerPartita() {
        return occasioniPerPartita;
    }

    Ruolo(String abbreviazione, int occasioniPerPartita) {
        this.abbreviazione = abbreviazione;
        this.occasioniPerPartita= occasioniPerPartita;
    }

    public String getAbbreviazione() {
        return abbreviazione;
    }
}