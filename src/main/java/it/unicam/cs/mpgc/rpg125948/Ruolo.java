package it.unicam.cs.mpgc.rpg125948;


public enum Ruolo {
    PORTIERE("POR"),
    DIFENSORE("DIF"),
    CENTROCAMPISTA("CEN"),
    ATTACCANTE("ATT");

    private final String abbreviazione;

    Ruolo(String abbreviazione) {
        this.abbreviazione = abbreviazione;
    }

    public String getAbbreviazione() {
        return abbreviazione;
    }
}