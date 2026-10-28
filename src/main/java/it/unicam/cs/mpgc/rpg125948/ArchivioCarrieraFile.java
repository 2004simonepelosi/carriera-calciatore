package it.unicam.cs.mpgc.rpg125948;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArchivioCarrieraFile implements ArchivioCarriera {

    private final File file;

    public ArchivioCarrieraFile(File file) {
        this.file = file;
    }

    @Override
    public void salva(Carriera carriera) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(carriera);
        }
    }

    @Override
    public Carriera carica() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (Carriera) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("File di salvataggio non valido", e);
        }
    }
}