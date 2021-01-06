package com.example.maketheway;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class MovingObjects extends Sprite{
    public MovingObjects(int x, int y, Bitmap bitmap) {
        super(x, y, bitmap);
    }
    protected char state = 'i';


    public void downEvent(int x, int y) {
        if (x >= this.x && x <= this.x + bitmap.getWidth() &&
                (y >= this.y && y <= this.y + bitmap.getHeight())) {
            state = 'm';
            //state=moving;
        }

    }

    public void moveEvent(int x, int y) {
        if (state == 'm') {
            this.x = x;
            this.y = y;
        }

    }

    public char getState() {
        return state;
    }

    public void upEvent() {
        state = 'i';
    }

    public void processCollision(Player player) {
    }
}
