package com.example.maketheway;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Platform extends MovingObjects {


    public Platform(int x, int y, Bitmap bitmap) {
        super(x, y, bitmap);
    }

    public void draw (Canvas canvas){
        canvas.drawBitmap(bitmap,x,y,null);
    }
}
