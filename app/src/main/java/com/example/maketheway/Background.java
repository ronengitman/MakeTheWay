package com.example.maketheway;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Background extends Sprite {
    public Background(int x, int y, Bitmap bitmap) {
        super(x, y, bitmap);
    }

    public void draw (Canvas canvas){
        canvas.drawBitmap(bitmap,x,y,null);
    }
    public void setBitmap(Bitmap bitmap)
    {
        this.bitmap = bitmap;
    }
}

