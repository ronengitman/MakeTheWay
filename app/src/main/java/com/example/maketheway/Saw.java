package com.example.maketheway;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Saw extends NonMovingObjects {
    public Saw (int x, int y, Bitmap bitmap) { super(x, y, bitmap); }

    public void draw (Canvas canvas){
        canvas.drawBitmap(bitmap,x,y,null);
    }

    @Override
    public void processCollision(Player player) {

    }
}
