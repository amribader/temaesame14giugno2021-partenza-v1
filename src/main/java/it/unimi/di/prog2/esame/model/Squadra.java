package it.unimi.di.prog2.esame.model;

public class Squadra {
    private String name;
    private int gol;

    public Squadra(String name, int gol) {
        this.name = name;
        this.gol = gol;
    }

    public String getName() {
        return name;
    }

    public int getGol() {
        return gol;
    }
}
