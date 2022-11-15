package agh.ics.oop;

public class World {

    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map);
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
