package com.example.maketheway;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;

public class Sprite {
    protected int x;
    protected int y;
    protected Bitmap bitmap;



    public Sprite(int x, int y, Bitmap bitmap) {
        this.x = x;
        this.y = y;
        this.bitmap = bitmap;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y =y;
    }


    public void draw (Canvas canvas)
    {
        canvas.drawBitmap(bitmap,x,y,null);
    }


}
