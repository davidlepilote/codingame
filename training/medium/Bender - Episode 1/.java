import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    static StringBuilder builder = new StringBuilder();
    static Teleporter t1 = null;
    static Teleporter t2 = null;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int C = in.nextInt();
        Bender bender = new Bender(0,0);
        in.nextLine();
        char[][] grid = new char[C][L];
        for (int i = 0; i < L; i++) {
            String row = in.nextLine();
            for(int j = 0; j < C; j++){
                char current = row.charAt(j);
                grid[j][i] = current;
                if(current == '@'){
                    bender = new Bender(j, i);
                }
                if(current == 'T'){
                    if(t1 == null){
                        t1 = new Teleporter(j, i);
                    } else {
                        t2 = new Teleporter(j, i); 
                    }
                }
            }
        }

        int i = 0;
        while(bender.position(grid) != '$'){
            if(i++ > 10000){
                System.out.println("LOOP");
                return;
            } else {
                bender.tryToMove(grid);
            }
        }
        System.out.println(builder.toString().substring(0, builder.length() - 1));
    }
    
    private static enum Direction{
        S,
        E,
        N,
        W
    }
    
    private static class Teleporter{
        private final int X;
        private final int Y;
        
        public Teleporter(int X, int Y){
            this.X = X;
            this.Y = Y;
        }
        
        public boolean isHere(int X, int Y){
            return this.X == X && this.Y == Y;
        }
    }
    
    private static class Bender{
        private boolean isCasseur = false;
        private boolean isInverse = false;
        private Direction _direction = Direction.S;
        private int _X;
        private int _Y;
        private int _directionIndex = 0;
        
        public Bender(int X, int Y){
            _X = X;
            _Y = Y;
        }
        
        public char position(char[][] grid){
            return grid[_X][_Y];
        }
        
        public void tryToMove(char[][] grid){
            char nextCase = nextCase(grid);
            switch (nextCase){
                case '#':
                    changeDirection(_directionIndex++);
                    tryToMove(grid);
                    break;
                case 'X':
                    if(isCasseur){
                        breakNext(grid);
                        move();
                    } else {
                        changeDirection(_directionIndex++);
                        tryToMove(grid);
                    }
                    break;
                case ' ':
                    move();
                    break;
                case 'E':
                    move();
                    _direction = Direction.E;
                    break;
                case 'S':
                    move();
                    _direction = Direction.S;
                    break;
                case 'N':
                    move();
                    _direction = Direction.N;
                    break;
                case 'W':
                    move();
                    _direction = Direction.W;
                    break;
                case 'B':
                    isCasseur = !isCasseur;
                    move();
                    break;
                case 'I':
                    isInverse = !isInverse;
                    move();
                    break;
                case 'T':
                    move();
                    if(t1.isHere(_X, _Y)){
                        moveTo(t2.X, t2.Y);
                    } else {
                        moveTo(t1.X, t1.Y);
                    }
                    break;
                default:
                    move();
                    break;
            }
        }
        
        public void moveTo(int X, int Y){
            _X = X;
            _Y = Y;
        }
        
        public void move(){
            _directionIndex = 0;
            switch (_direction){
                case S:
                    _Y = _Y + 1;
                    builder.append("SOUTH").append('\n');
                    break;
                case N:
                    _Y = _Y - 1;
                    builder.append("NORTH").append('\n');
                    break;
                case E:
                    _X = _X + 1;
                    builder.append("EAST").append('\n');
                    break;
                case W:
                    _X = _X - 1;
                    builder.append("WEST").append('\n');
                    break;
            }
        }
        
        public void changeDirection(int directionIndex){
            Direction[] normal = new Direction[]{Direction.S, Direction.E, Direction.N, Direction.W, Direction.S};
            Direction[] reverse = new Direction[]{Direction.W, Direction.N, Direction.E, Direction.S, Direction.W};
            if(isInverse){
                _direction = reverse[directionIndex];
            } else {
                _direction = normal[directionIndex];
            }
        }
        
        public char nextCase(char[][] grid){
            switch (_direction){
                case S:
                    return grid[_X][_Y+1];
                case N:
                    return grid[_X][_Y-1];
                case E:
                    return grid[_X+1][_Y];
                case W:
                    return grid[_X-1][_Y];
                default:
                    return grid[_X][_Y];
            }
        }
        
        public void breakNext(char[][] grid){
            switch (_direction){
                case S:
                    grid[_X][_Y+1] = ' ';
                    break;
                case N:
                    grid[_X][_Y-1] = ' ';
                    break;
                case E:
                    grid[_X+1][_Y] = ' ';
                    break;
                case W:
                    grid[_X-1][_Y] = ' ';
                    break;
            }
        }
    }
}