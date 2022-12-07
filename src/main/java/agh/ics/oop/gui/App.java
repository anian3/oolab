package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;

public class App extends Application implements IPositionChangeObserver {

    private IWorldMap map;
    private int moveDelay;
    private GridPane gridPane = new GridPane();
    private Stage stage;
    private Scene scene;

    public void init(){
        try {
            MoveDirection[] directions = new OptionsParser().parse(getParameters().getRaw().toArray(new String[0]));
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(-2, 1), new Vector2d(3, 7), new Vector2d(-2, 8)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            for (Animal animal: map.animals.values()){
                animal.addObserver(this);
            }
            Thread thread = new Thread((Runnable) engine);
            thread.start();
            moveDelay = 300;
        }
        catch (IllegalArgumentException exception){
            System.out.println("Wrong argument. " + exception.getMessage());
        }
    }

    public void actualize(){
        gridPane.setGridLinesVisible(false);
        gridPane.getColumnConstraints().clear();
        gridPane.getRowConstraints().clear();
        gridPane.getChildren().clear();
        gridPane.setGridLinesVisible(true);
        Vector2d mapStart = map.findMapStart();
        Vector2d mapEnd = map.findMapEnd();
        int minX = mapStart.x;
        int minY = mapStart.y;
        gridPane.getColumnConstraints().add(new ColumnConstraints(40));
        gridPane.getRowConstraints().add(new RowConstraints(40));
        for (int i = 0; i <= mapEnd.x - mapStart.x; i++) {
            Label label = new Label(Integer.toString(minX + i));
            gridPane.add(label, i + 1, 0);
            gridPane.setHalignment(label, HPos.CENTER);
            gridPane.getColumnConstraints().add(new ColumnConstraints(40));
        }
        for (int i = 0; i <= mapEnd.y - mapStart.y; i++) {
            Label label = new Label(Integer.toString(minY + i));
            gridPane.add(label, 0, i + 1);
            gridPane.setHalignment(label, HPos.CENTER);
            gridPane.getRowConstraints().add(new RowConstraints(40));
        }
        for (int i = 0; i <= mapEnd.x - mapStart.x; i++) {
            for (int j = 0; j <= mapEnd.y - mapStart.y; j++) {
                Vector2d position = new Vector2d(minX + i, minY + j);
                if (map.isOccupied(position)) {
                    VBox vbox;
                    try {
                        vbox = new GuiElementBox(map.objectAt(position)).vBox;
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    gridPane.add(vbox, i + 1, j + 1);
                }
            }
        }
        scene.setRoot(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    public void positionChanged(Vector2d oldPosition, Vector2d NewPosition){
        Platform.runLater(this::actualize);
    }

    @Override
    public void start(Stage primaryStage) {
        Platform.runLater(() -> {
            stage = primaryStage;
            gridPane = new GridPane();
            TextField textfield = new TextField();
            gridPane.setConstraints(textfield, 5, 5);
            Button start = new Button("START");
            gridPane.setConstraints(start, 0, 0);
            scene = new Scene(gridPane);
            actualize();
        });

    }

}
