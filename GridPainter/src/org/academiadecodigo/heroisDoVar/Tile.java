package org.academiadecodigo.heroisDoVar;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Tile extends Rectangle {

    private boolean painted;
    public Tile(int x, int y, int width, int height){
        super(x, y, width, height);
        painted = false;
    }

    public boolean isPainted() {
        return painted;
    }

    public void setPainted(boolean painted) {
        this.painted = painted;
    }

}
