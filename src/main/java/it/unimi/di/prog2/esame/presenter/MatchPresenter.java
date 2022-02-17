package it.unimi.di.prog2.esame.presenter;


import it.unimi.di.prog2.esame.model.EuroModel;
import it.unimi.di.prog2.esame.model.Observer;
import it.unimi.di.prog2.esame.model.Subject;
import it.unimi.di.prog2.esame.view.MatchView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MatchPresenter implements Presenter, Observer<List<Integer>> {

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
    model.add(gameNumber+""+i);
    //TODO completare
  }

  @Override
  public void update(Subject<List<Integer>> subject, List<Integer> state) {
    //System.out.println("state"+state);
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
