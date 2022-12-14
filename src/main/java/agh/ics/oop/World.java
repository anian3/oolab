package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {

    public static void main(String[] args) {
        Application.launch(App.class, args);
    }

    public static void run(Direction[] dir) {
        for (Direction argument : dir) {
            String message = switch (argument) {
                case FORWARD -> "Zwierzak idzie do przodu.";
                case BACKWARD -> "Zwierzak idzie do tyłu.";
                case LEFT -> "Zwierzak skręca w lewo.";
                case RIGHT -> "Zwierzak skręca w prawo.";
            };
            System.out.println(message);
        }
    }

    public static Direction[] conversion(String[] args) {
        Direction[] dir = new Direction[args.length];
        for (int i = 0; i < args.length; ++i) {
            dir[i] = switch (args[i]) {
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "l" -> Direction.LEFT;
                case "r" -> Direction.RIGHT;
                default -> null;
            };
        }
        return dir;
    }
}
