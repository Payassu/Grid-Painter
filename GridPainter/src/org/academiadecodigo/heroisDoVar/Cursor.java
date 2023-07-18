package org.academiadecodigo.heroisDoVar;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    public static Rectangle cursor;
    private int row;
    private int col;


    public Cursor() {
        cursor = new Rectangle(Grid.PADDING, Grid.PADDING, Grid.CELLSIZE, Grid.CELLSIZE);
        cursor.setColor(Color.CYAN);
        cursor.draw();
        cursor.fill();
    }

    public int xToColumn(int x) {
        col = (x - Grid.PADDING) / Grid.CELLSIZE;
        return col;
    }

    public int yToRow(int y) {
        row = (y - Grid.PADDING) / Grid.CELLSIZE;
        return row;
    }

    public void paint(Tile tile){
    int x = xToColumn(tile.getX());
    int y = yToRow(tile.getY());
        if(!Grid.grid[x][y].isPainted())
        {
            Grid.grid[x][y].setColor(cursor.getColor());
            Grid.grid[x][y].fill();
            Grid.grid[x][y].setPainted(true);
        } else {
            Grid.grid[x][y].draw();

        }
    }

}
