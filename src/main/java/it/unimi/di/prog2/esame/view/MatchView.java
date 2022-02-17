package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.presenter.MatchPresenter;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.jetbrains.annotations.NotNull;

public class MatchView extends Region {

  private final Label[] teams = new Label[2];
  private final Button[] goal = new Button[2];

  public MatchView() {
    setBackground(new Background(
        new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5.0), Insets.EMPTY)));
    setBorder(new Border(
        new BorderStroke(null, BorderStrokeStyle.SOLID, new CornerRadii(5.0), new BorderWidths(2))));

    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10, 10, 10, 10));

    for (int i = 0; i < 2; i++) {
      teams[i] = new Label(String.format("%10s: %d", "Squadra" + i, 0));
      teams[i].setFont(Font.font("Courier", 14));
      teams[i].setPadding(new Insets(10, 10, 10, 10));
      goal[i] = new Button("Goal");
      grid.add(teams[i], 0, 2 + i);
      grid.add(goal[i], 1, 2 + i);
    }
    this.getChildren().add(grid);
  }

  public void addHandlers(@NotNull MatchPresenter presenter) {
    for (int i = 0; i < 2; i++) {
      final int id = i;
      goal[i].setOnAction(eh -> presenter.goal(id));
    }
  }

  public void set(int i, @NotNull String s) {
    teams[i].setText(s);
  }
}
