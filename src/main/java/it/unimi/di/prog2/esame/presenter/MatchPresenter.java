package it.unimi.di.prog2.esame.presenter;


import it.unimi.di.prog2.esame.model.EuroModel;
import it.unimi.di.prog2.esame.model.Observer;
import it.unimi.di.prog2.esame.model.Squadra;
import it.unimi.di.prog2.esame.model.Subject;
import it.unimi.di.prog2.esame.view.MatchView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MatchPresenter implements Presenter, Observer<List<Squadra>> {

  private final MatchView view;
  private final EuroModel model;
  private final int gameNumber;

  public MatchPresenter(@NotNull final MatchView view, EuroModel model, int gameNumber) {
    this.view = view;
    this.model = model;
    this.gameNumber = gameNumber;
    view.addHandlers(this);
    model.addObserver(this);
    //TODO completare
  }


  public final void goal(int i) {//corrisponde ad updateModel //
    //System.err.println(String.format("Partita %d: la squadra %d ha fatto un goal", gameNumber, i));
    model.addGoal(gameNumber+""+i);
    //TODO completare
  }

  @Override
  public void update(Subject<List<Squadra>> subject, List<Squadra> state) {

    Squadra squadra = model.getSquadraByName(gameNumber+""+0);
    Squadra squadra2 = model.getSquadraByName(gameNumber+""+1);
    view.set(0,squadra.getName()+"  "+squadra.getGol());
    view.set(1, squadra2.getName()+"  "+squadra2.getGol());
    //System.out.println("state"+state);
    //subject.
    //for (Squadra squadra : subject) {

    //}

    //for (int i = 0; i < 2; i++) {
      //System.out.println(i);
      //Squadra squadra = model.getByName(state,gameNumber+""+0);
      //Squadra squadra1 = model.getByName(state,gameNumber+""+1);

      //System.err.println("-->"+squadra);
      //view.set(0,squadra.getName()+" "+squadra.getGol());
      //view.set(1,squadra1.getName()+" "+squadra1.getGol());
      //System.err.println(state.get(i).getPartita());
      //System.err.println(gameNumber);
      //if (state.get(i).getPartita() ==  gameNumber){
      //  view.set(i,state.get(i).getName()+" "+state.get(i).getGol());
      //}


    //}
    //System.err.println(subject);
    //System.err.println("getState"+subject.getState());
    //System.err.println("gameNumber"+gameNumber);
    //view.set(state);
    //System.out.println(state.size());
    //int i = 0;//può essere solamente 0 e 1
    //for (Integer integer : state) {
      //System.out.println(integer);
    //  view.set(i, String.valueOf(integer));
    //  i++;
    //}

  }

  @Override
  public String toString() {
    return "MatchPresenter{"+gameNumber+" + gameNumber +}";
  }
}
