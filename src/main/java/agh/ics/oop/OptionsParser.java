package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] arguments) {
        MoveDirection[] moveDirections = new MoveDirection[arguments.length];
        int i = 0;
        for (String argument : arguments) {
            switch (argument) {
                case "f", "forward" -> {
                    moveDirections[i] = MoveDirection.FORWARD;
                    i++;
                }
                case "b", "backward" -> {
                    moveDirections[i] = MoveDirection.BACKWARD;
                    i++;
                }
                case "r", "right" -> {
                    moveDirections[i] = MoveDirection.RIGHT;
                    i++;
                }
                case "l", "left" -> {
                    moveDirections[i] = MoveDirection.LEFT;
                    i++;
                }
            }
        }
        return Arrays.copyOfRange(moveDirections, 0, i);
    }
}
