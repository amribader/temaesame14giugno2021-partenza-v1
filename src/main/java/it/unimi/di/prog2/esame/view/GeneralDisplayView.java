package it.unimi.di.prog2.esame.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.jetbrains.annotations.NotNull;

public class GeneralDisplayView extends Region {
  private final Label[] rows;

  public GeneralDisplayView(int rows) {
    this.rows = new Label[rows];
    setBackground(new Background(
        new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5.0), Insets.EMPTY)));
    setBorder(new Border(
        new BorderStroke(null, BorderStrokeStyle.SOLID, new CornerRadii(5.0), new BorderWidths(2))));

    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10, 10, 10, 10));
    for (int i = 0; i < rows; i++) {
      this.rows[i] = new Label("Riga #" + i);
      this.rows[i].setPadding(new Insets(10, 10, 10, 10));
      this.rows[i].setFont(Font.font ("Courier", 20));
      grid.add(this.rows[i], 0, i);
    }
    this.getChildren().add(grid);
  }

  public void set(int i, @NotNull String s) {
    rows[i].setText(s);
  }
}
