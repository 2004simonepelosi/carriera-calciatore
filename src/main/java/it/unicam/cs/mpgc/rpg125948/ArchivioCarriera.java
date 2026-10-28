package it.unicam.cs.mpgc.rpg125948;

import java.io.IOException;

public interface ArchivioCarriera {

    void salva(Carriera carriera) throws IOException;

    Carriera carica() throws IOException;
}