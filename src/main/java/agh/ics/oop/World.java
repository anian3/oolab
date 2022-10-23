package agh.ics.oop;

public class World {

    public static void main(String[] args) {
        System.out.println("Start");
        Animal Azor = new Animal();
        System.out.println(Azor);
        MoveDirection[] moveDirections = OptionsParser.parse(args);
        for (MoveDirection direction : moveDirections) {
            Azor.move(direction);
        }
        System.out.println(Azor);
        System.out.println("Stop");
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
