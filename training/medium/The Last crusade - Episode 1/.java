import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt(); // number of columns.
        int h = in.nextInt(); // number of rows.
        in.nextLine();
        Piece[][] pieces = new Piece[w][h];
        for (int line = 0; line < h; line++) {
            String lINE = in.nextLine(); // represents a line in the grid and contains W integers. Each integer represents one room of a given type.
            String[] split = lINE.split(" ");
            int column = 0;
            for(String integerString : split){
                pieces[column][line] = new Piece(Integer.parseInt(integerString));
                column++;
            }
        }
        int eX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).
        in.nextLine();

        // game loop
        while (true) {
            int xI = in.nextInt();
            int yI = in.nextInt();
            String pOS = in.next();
            in.nextLine();

            Direction nextDirection = pieces[xI][yI].nextDirection(Direction.valueOf(pOS));
            Coordinate nextCoordinate = Utils.getNextMove(new Coordinate(xI, yI), nextDirection);
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println(nextCoordinate.getX() + " " + nextCoordinate.getY()); // One line containing the X Y coordinates of the room in which you believe Indy will be on the next turn.
        }
    }

    private static class Coordinate{
        private final int x;
        private final int y;

        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private static class Utils{
        public static Coordinate getNextMove(Coordinate currentCoordinate, Direction direction){
            Coordinate nextCoordinate = null;
            switch (direction){
                case LEFT:
                    nextCoordinate = new Coordinate(currentCoordinate.x - 1, currentCoordinate.y);
                    break;
                case RIGHT:
                    nextCoordinate = new Coordinate(currentCoordinate.x + 1, currentCoordinate.y);
                    break;
                case BOTTOM:
                    nextCoordinate = new Coordinate(currentCoordinate.x, currentCoordinate.y + 1);
                    break;
            }
            return nextCoordinate;
        }
    }

    private static class Piece{
        private final int type;

        public Piece(int type){
            this.type = type;
        }

        public Direction nextDirection(Direction entry){
            Direction exitDirection = Direction.BOTTOM;
            switch (type){
                case 2:
                    switch(entry){
                        case LEFT:
                            exitDirection = Direction.RIGHT;
                            break;
                        case RIGHT:
                            exitDirection = Direction.LEFT;
                            break;
                    }
                    break;
                case 4:
                    if(entry.equals(Direction.TOP)){
                        exitDirection = Direction.LEFT;
                    }
                    break;
                case 5:
                    if(entry.equals(Direction.TOP)){
                        exitDirection = Direction.RIGHT;
                    }
                    break;
                case 6:
                    switch(entry){
                        case LEFT:
                            exitDirection = Direction.RIGHT;
                            break;
                        case RIGHT:
                            exitDirection = Direction.LEFT;
                            break;
                    }
                    break;
                case 10:
                    exitDirection = Direction.LEFT;
                    break;
                case 11:
                    exitDirection = Direction.RIGHT;
                    break;
            }
            return exitDirection;
        }
    }

    private static enum Direction{
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }
}