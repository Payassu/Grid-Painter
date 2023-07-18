package org.academiadecodigo.heroisDoVar;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    public final static int COLS = 30;
    public final static int ROWS = 30;
    public final static int CELLSIZE = 20;
    public final static int WIDTH = COLS * CELLSIZE;
    public final static int HEIGHT = ROWS * CELLSIZE;
    public final static int PADDING = 10;
    private Rectangle gameWindow;
    private InputHandler inputHandler;
    private Cursor cursor;
    public static Tile[][] grid;


    public Grid(){
        gameWindow = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        gameWindow.setColor(Color.WHITE);
        gameWindow.fill();
        cursor = new Cursor();
        inputHandler = new InputHandler(cursor);
        createGrid();
    }

    public void createGrid(){ //cria array bidimensional de "rectangulos"
        grid = new Tile[ROWS][COLS];
        for(int row = 0; row < ROWS; row++){
            for(int col = 0; col < COLS; col++){
                grid[row][col] = new Tile(PADDING + (row*CELLSIZE), PADDING + (col*CELLSIZE), CELLSIZE, CELLSIZE);
                grid[row][col].draw();
            }
        }

        /*
        //cria linhas horizontais
        for (int i = PADDING; i <= PADDING+WIDTH; i += CELLSIZE){
            line = new Line(PADDING, i, PADDING+WIDTH, i);
            line.draw();
        }
         */
        /*//cria linhas verticais
        for(int i = PADDING; i <= PADDING+HEIGHT; i += CELLSIZE){
            line = new Line(i, PADDING, i, PADDING+HEIGHT);
            line.draw();
        }*/
    }


}
