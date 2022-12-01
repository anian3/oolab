package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class App extends Application {

    public void start(Stage primaryStage) {
        try {
            MoveDirection[] directions = new OptionsParser().parse(getParameters().getRaw().toArray(new String[0]));
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(-2, 1), new Vector2d(3, 7), new Vector2d(-2,10)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            System.out.println(map);
            GridPane gridPane = new GridPane();
            gridPane.setGridLinesVisible(true);
            Vector2d mapStart = map.findMapStart();
            Vector2d mapEnd = map.findMapEnd();
            int minX = mapStart.x;
            int minY = mapStart.y;
            gridPane.getColumnConstraints().add(new ColumnConstraints(30));
            gridPane.getRowConstraints().add(new RowConstraints(30));
            for (int i=0; i <= mapEnd.x-mapStart.x; i++){
                Label label = new Label(Integer.toString(minX+i));
                gridPane.add(label, i+1, 0);
                gridPane.setHalignment(label, HPos.CENTER);
                gridPane.getColumnConstraints().add(new ColumnConstraints(30));
            }
            for (int i=0; i <= mapEnd.y-mapStart.y; i++) {
                Label label = new Label(Integer.toString(minY+i));
                gridPane.add(label, 0, i+1);
                gridPane.setHalignment(label, HPos.CENTER);
                gridPane.getRowConstraints().add(new RowConstraints(30));
            }
            for (int i = 0; i <= mapEnd.x-mapStart.x; i++) {
                for (int j = 0; j <= mapEnd.y-mapStart.y; j++) {
                    Vector2d position = new Vector2d(minX+i, minY+j);
                    if (map.isOccupied(position)) {
                        Label label = new Label(map.objectAt(position).toString());
                        gridPane.add(label, i+1, j+1);
                        gridPane.setHalignment(label, HPos.CENTER);
                    }
                }
            }
            Scene scene = new Scene(gridPane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IllegalArgumentException exception) {
            System.out.println("Wrong argument. " + exception.getMessage());
        }
    }

}
