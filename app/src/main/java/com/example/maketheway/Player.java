package com.example.maketheway;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;

public class Player extends Sprite {
    private ArrayList<Bitmap> images = new ArrayList<>();
    private int currentIndex = 0;
    private int delay=0;


    public Player(int x, int y, ArrayList<Bitmap> images) {
        super(x, y, images.get(0));
        this.images = images;
    }

    @Override
    public void draw(Canvas canvas) {
        if (delay==5) delay=0;
        if(delay==4) currentIndex++;
        delay++;
        canvas.drawBitmap(images.get(currentIndex % images.size()),x,y,null);
    }
}
