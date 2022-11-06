package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] arguments) {
        MoveDirection[] moveDirections = new MoveDirection[arguments.length];
        int i = 0;
        for (String argument : arguments) {
            switch (argument) {
                case "f", "forward" -> moveDirections[i] = MoveDirection.FORWARD;
                case "b", "backward" ->  moveDirections[i] = MoveDirection.BACKWARD;
                case "r", "right" ->  moveDirections[i] = MoveDirection.RIGHT;
                case "l", "left" ->  moveDirections[i] = MoveDirection.LEFT;
                default -> i--;
            }
            i++;
        }
        return Arrays.copyOfRange(moveDirections, 0, i);
    }
}
