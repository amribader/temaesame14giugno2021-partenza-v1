package it.unimi.di.prog2.esame.model;

public class Squadra {
    private String name;
    private int gol;
    private char partita;

    public Squadra() {
    }

    public Squadra(String name, int gol, char partita) {
        this.name = name;
        this.gol = gol;
        this.partita = partita;
    }

    public String getName() {
        return name;
    }

    public int getGol() {
        return gol;
    }

    public char getPartita() {
        return partita;
    }

    @Override
    public String toString() {
        return "Squadra{" +
                "name='" + name + '\'' +
                ", gol=" + gol +
                ", partita=" + partita +
                '}';
    }
}
