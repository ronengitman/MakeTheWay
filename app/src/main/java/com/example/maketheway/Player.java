package com.example.maketheway;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;

import java.util.ArrayList;

public class Player extends Sprite {
    private ArrayList<Bitmap> images = new ArrayList<>();
    private int currentIndex = 0;
    private int delay = 0;
    private int jumpLength = 0;
    protected boolean jumping = false;
    protected boolean goingRight = true;


    public Player(int x, int y, ArrayList<Bitmap> images)  {
        super(x, y, images.get(0));
        this.images = images;
    }
    public void move (){
        if (goingRight) x += 3;
        else x -= 3;


        if (y == 0) y=600;

        if (jumpLength == 360){
            jumpLength = 0;
            jumping=false;
        }

        if (jumping){
                if (jumpLength < 180){
                    y -=7;
                }
                else {
                    y +=7;
                }
                jumpLength +=3 ;
        }

       if (x < 4) changeDirection();
       if (x > 1550) changeDirection();

    }
    public boolean checkCollision(Sprite other) {
        int left = Math.max(x, other.x);
        int right = Math.min(x+bitmap.getWidth(), other.x+other.bitmap.getWidth());
        int top = Math.max(y, other.y);
        int bottom = Math.min(y+bitmap.getHeight(), other.y+other.bitmap.getHeight());
        for (int row  = left; row < right; row++) {
            for (int col = top; col < bottom; col++) {
                if (bitmap.getPixel(row-x, col-y)!= Color.TRANSPARENT &&
                        other.bitmap.getPixel(row-other.x, col-other.y)!= Color.TRANSPARENT) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        if (jumping){
            if (jumpLength < 180) {
                currentIndex = 4;
                canvas.drawBitmap(images.get(currentIndex), x, y, null);
            }
            else {
                currentIndex = 5;
                canvas.drawBitmap(images.get(currentIndex), x, y, null);
            }
            delay =0;
            currentIndex = 0;
        }

        else {
            if (delay == 5) delay=0;
            if(delay == 4) currentIndex++;
            delay++;
            if (currentIndex == 4) currentIndex =0;
            canvas.drawBitmap(images.get(currentIndex), x, y, null);

        }
    }


    public void setJumping (boolean jump){
        jumping=jump;
    }

    public void changeDirection(){
        if (goingRight == true) goingRight=false;
        else goingRight = true;
    }


    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y =y;
    }
}
