package org.academiadecodigo.heroisDoVar;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import javax.xml.crypto.Data;
import java.io.IOException;

public class InputHandler implements KeyboardHandler {

    private final Keyboard keyboard;
    private final KeyboardEvent[] events; // vai guardar a informação que cada tecla pressionada (evento) faz;
    private Rectangle cursor;
    private Tile tile;
    private Cursor cursorOb;
    private DataSaver dataSaver;
    private boolean isPressed;



    public InputHandler(Cursor cursor){
        this.keyboard = new Keyboard(this);
        this.events = new KeyboardEvent[9];
        this.cursor = Cursor.cursor;
        this.cursorOb = cursor;
        this.dataSaver = new DataSaver();
        createEvents();
    }

    //Métodos
    public void createEvents(){

        for (int i = 0; i < events.length; i++){
            events[i] = new KeyboardEvent();
        }

        events[0].setKey(KeyboardEvent.KEY_DOWN);
        events[1].setKey(KeyboardEvent.KEY_UP);
        events[2].setKey(KeyboardEvent.KEY_LEFT);
        events[3].setKey(KeyboardEvent.KEY_RIGHT);
        events[4].setKey(KeyboardEvent.KEY_SPACE);
        events[5].setKey(KeyboardEvent.KEY_B);
        events[6].setKey(KeyboardEvent.KEY_S);
        events[7].setKey(KeyboardEvent.KEY_L);
        events[8].setKey(KeyboardEvent.KEY_Q);

        for(KeyboardEvent event : events){
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(event);
        }

    }

    @Override public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_DOWN:
                if(cursor.getY() < (Grid.HEIGHT-Grid.PADDING)){
                    cursor.translate(0, Grid.CELLSIZE);
                }
                break;
            case KeyboardEvent.KEY_UP:
                if(cursor.getY() > (Grid.PADDING)){
                    cursor.translate(0, -Grid.CELLSIZE);
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if(cursor.getX() > (Grid.PADDING)) {
                    cursor.translate(-Grid.CELLSIZE, 0);
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if(cursor.getX() < (Grid.WIDTH - Grid.PADDING)) {
                    cursor.translate(Grid.CELLSIZE, 0);
                }
                break;

            case KeyboardEvent.KEY_B:
                cursor.setColor(Color.BLUE);
                break;

            case KeyboardEvent.KEY_S:
                try {
                    dataSaver.writeFile("resources/DataSaver.txt");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;

            case KeyboardEvent.KEY_L:
                try {
                    dataSaver.readFile("resources/DataSaver.txt");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;

            case KeyboardEvent.KEY_SPACE:
                isPressed = true; //not being used. failed try...
                this.tile = new Tile(this.cursor.getX(), this.cursor.getY(), Grid.CELLSIZE, Grid.CELLSIZE);

                cursorOb.paint(tile);
                break;

            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;

            default:
                System.out.println("Invalid Command.");
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                isPressed = false; //NBU
                break;
        }

    }

    }





