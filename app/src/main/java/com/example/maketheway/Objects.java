package com.example.maketheway;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Objects extends Sprite{
    protected char state;
    // m=moving i=idle
    public Objects(int x, int y, Bitmap bitmap) {
        super(x, y, bitmap);
    }

    public void downEvent(float x,float y){
        if (x>=this.x && x <=this.x+bitmap.getWidth()&&
                (y>=this.y && y <=this.y+bitmap.getHeight())){
            state='m';
            //state=moving;
        }

    }
    public void draw (Canvas canvas)
    {
        canvas.drawBitmap(bitmap,x,y,null);
    }

    public void moveEvent(float x, float y) {
        if (state=='m') {
            this.x=x;
            this.y=y;
        }

    }
    public char getState() {
        return state;
    }

    public void upEvent(float x, float y) {
        state='i';
    }
}
