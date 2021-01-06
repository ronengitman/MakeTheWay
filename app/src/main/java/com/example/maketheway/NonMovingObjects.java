package com.example.maketheway;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class NonMovingObjects extends Sprite {
    public NonMovingObjects(int x, int y, Bitmap bitmap) {
        super(x, y, bitmap);
    }

    public void processCollision(Player player) {
    }
}
