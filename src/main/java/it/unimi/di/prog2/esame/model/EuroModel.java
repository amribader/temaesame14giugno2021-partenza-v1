package it.unimi.di.prog2.esame.model;

import java.util.*;

public class EuroModel implements Subject<List<Squadra>>{
    private final List<Observer<List<Squadra>>> observers = new ArrayList<>();
    private Map<String,Squadra> squadre = new HashMap<>();


    @Override
    public void notifyObservers() {
        for (Observer<List<Squadra>> observer : observers) {
            observer.update(this,this.getState());
        }
    }

    @Override
    public void addObserver(Observer<List<Squadra>> obs) {
        observers.add(obs);
    }

    @Override
    public List<Squadra> getState() {
        return new ArrayList<>(squadre.values());
    }
    public void addGoal(String nome) {
        if(!squadre.containsKey(nome)){
            squadre.put(nome,new Squadra(nome,1,nome.charAt(0)));
            notifyObservers();
        }else{
            squadre.put(nome,new Squadra(nome,squadre.get(nome).getGol()+1,squadre.get(nome).getPartita()));
            notifyObservers();

        }
        //System.err.println(squadre);

    }

    //public void add(String s) {

        //System.err.println(s);
        //se non ce nella mappa posso aggiongero
        //controllo che nella mappa esiste già questa chiave se lo è aggiorno il vlore incrementanto il gol
        //if(!squadre.containsKey(s)){//se non esiste
            //squadre.getOrDefault(s,1+squadre.get(s));
            //squadre.put(s,squadre.getOrDefault(s,1+squadre.get(s)));
        //squadre.put(s,1+squadre.getOrDefault(s,new Squadra(s,)));
        //squadre.put(s,++);
        //System.err.println(squadre);
        //notifyObservers();

        //}
    //}

    public Squadra getByName(List<Squadra> squadras, String name){
        //System.err.println("-->"+squadras);
        //System.err.println("-->"+name);
        Squadra result = new Squadra();
        for (Squadra squadra : squadras) {
            //System.err.println("-->"+squadra.getName());
            if (Objects.equals(squadra.getName(), name)){
                //result = squadra;
                System.out.println("dentro");
                return new Squadra(squadra.getName(),squadra.getGol(),squadra.getPartita());
            }
        }
        return null;
    }

    public Squadra getSquadraByName( String name){

        //System.err.println("-->"+squadras);
        //System.err.println("-->"+name);
        //squadre.forEach((k, v) -> {
        //    System.out.println((k + ":" + v));
        //    if ()
        //});
        if (squadre.containsKey(name)){
            return squadre.get(name);
        }
        return new Squadra("",0,'0');
    }

    @Override
    public String toString() {
        return "EuroModel{" +
                "observers=" + observers +
                ", squadre=" + squadre +
                '}';
    }
}
