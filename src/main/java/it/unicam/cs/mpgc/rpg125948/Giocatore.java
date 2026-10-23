package it.unicam.cs.mpgc.rpg125948;

public class Giocatore {
    private String nome;
    private String cognome;
    private Ruolo ruolo;
    private String squadra;
    private static final int STATISTICA_INIZIALE = 40;
            private static final int MIGLIORAMENTO_ALLENAMENTO = 3;
    private static final int STATISTICA_MASSIMA = 100;
    private static final int STANCHEZZA_MASSIMA = 100;
    private static final int STANCHEZZA_MINIMA = 0;

    private static final int FATICA_ALLENAMENTO = 20;
    private static final int RECUPERO_RIPOSO = 30;

    private int eta;
    private int stanchezza = 0;
    private int velocita = STATISTICA_INIZIALE;
    private int tiro = STATISTICA_INIZIALE;
    private int passaggio = STATISTICA_INIZIALE;
    private int difesa = STATISTICA_INIZIALE;

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public String getSquadra() {
        return squadra;
    }

    public int getEta() {
        return eta;
    }

    public int getVelocita() {
        return velocita;
    }

    public int getTiro() {
        return tiro;
    }

    public int getPassaggio() {
        return passaggio;
    }

    public int getDifesa() {
        return difesa;
    }

    public int getStanchezza() {
        return stanchezza;
    }



    public Giocatore(String nome, String cognome, Ruolo ruolo, String squadra, int eta) {

        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
        this.squadra = squadra;
        this.eta = eta;


    }

    public void riposa() {

        stanchezza=Math.max(STANCHEZZA_MINIMA,stanchezza- RECUPERO_RIPOSO);


    }

    public void allenati(String statistica) {

        switch (statistica) {
            case "tiro" -> tiro = Math.min(STATISTICA_MASSIMA, tiro + MIGLIORAMENTO_ALLENAMENTO);
            case "difesa" -> difesa = Math.min(STATISTICA_MASSIMA, difesa+ MIGLIORAMENTO_ALLENAMENTO);
            case "passaggio" -> passaggio = Math.min(STATISTICA_MASSIMA, passaggio + MIGLIORAMENTO_ALLENAMENTO);
            case "velocita" -> velocita = Math.min(STATISTICA_MASSIMA, velocita + MIGLIORAMENTO_ALLENAMENTO);
            default -> throw new IllegalArgumentException("Statistica sconosciuta: " + statistica);
        }
        stanchezza= Math.min(STANCHEZZA_MASSIMA, stanchezza + FATICA_ALLENAMENTO);
    }
}
