package com.example.maketheway;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class LevelChanger extends NonMovingObjects {
    public LevelChanger(int x, int y, Bitmap bitmap) {
        super(x, y, bitmap);
    }

    public void draw (Canvas canvas){
        canvas.drawBitmap(bitmap,x,y,null);
    }

    @Override
    public void processCollision(Player player) {
        int newLevel = GameView.getLevel() + 1;
        GameView.setLevel(newLevel);
        player.changeDirection();

    }


}

