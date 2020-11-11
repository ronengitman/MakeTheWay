package com.example.maketheway;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Sprite {
    protected int x;
    protected int y;
    protected Bitmap bitmap;



    public Sprite(int x, int y, Bitmap bitmap) {
        this.x = x;
        this.y = y;
        this.bitmap = bitmap;
    }
    public void move (){
        x+=3;
        x %= 1401;
    }
    public void downEvent(float x,float y){
        if (x>=this.x && x <=this.x+bitmap.getWidth()&&
        (y>=this.y && y <=this.y+bitmap.getHeight())){
            //state=moving;
        }

    }
    public void draw (Canvas canvas){
        canvas.drawBitmap(bitmap,x,y,null);
    }
}
