package com.example.maketheway;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Sprite {
    protected float x;
    protected float y;
    protected Bitmap bitmap;



    public Sprite(int x, int y, Bitmap bitmap) {
        this.x = x;
        this.y = y;
        this.bitmap = bitmap;
    }
    public void move (){
        x+=3;
        x %= 1551;
    }
    public void draw (Canvas canvas)
    {
        canvas.drawBitmap(bitmap,x,y,null);
    }

}
