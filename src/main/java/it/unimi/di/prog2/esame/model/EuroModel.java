package it.unimi.di.prog2.esame.model;

import java.util.*;

public class EuroModel implements Subject<List<Integer>>{
    private final List<Observer<List<Integer>>> observers = new ArrayList<>();
    private Map<String,Integer> squadre = new HashMap<>();


    @Override
    public void notifyObservers() {
        for (Observer<List<Integer>> observer : observers) {
            observer.update(this,this.getState());
        }
    }

    @Override
    public void addObserver(Observer<List<Integer>> obs) {
        observers.add(obs);
    }

    @Override
    public List<Integer> getState() {
        return new ArrayList<>(squadre.values());
    }

    public void add(String s) {
        //System.err.println(s);
        //se non ce nella mappa posso aggiongero
        //controllo che nella mappa esiste già questa chiave se lo è aggiorno il vlore incrementanto il gol
        //if(!squadre.containsKey(s)){//se non esiste
            //squadre.getOrDefault(s,1+squadre.get(s));
            //squadre.put(s,squadre.getOrDefault(s,1+squadre.get(s)));
        squadre.put(s,1+squadre.getOrDefault(s,0));
        //squadre.put(s,++);
        //System.err.println(squadre);
        notifyObservers();
        //}
    }

    @Override
    public String toString() {
        return "EuroModel{" +
                "observers=" + observers +
                ", squadre=" + squadre +
                '}';
    }
}
