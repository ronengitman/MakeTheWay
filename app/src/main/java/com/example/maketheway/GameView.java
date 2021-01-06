package com.example.maketheway;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.ArrayList;

public class GameView extends SurfaceView implements Runnable {
    private Thread thread;
    private Jumper jumper;
    private Box box1;
    private Platform platform;
    private Background background;
    private LevelChanger levelChanger;
    private MovingObjects[] movingObjectsArray = new MovingObjects[3];
    private NonMovingObjects[] nonMovingObjectsArray = new NonMovingObjects[1];

    private Player player;
    public static int level = 1;


    public static void setLevel(int newLevel){
        level = newLevel;
    }
    public static int getLevel(){
        return level;
    }


    public GameView(Context context) {
        super(context);


        ArrayList<Bitmap> images = new ArrayList<>();
        images.add(BitmapFactory.decodeResource(getResources(),R.drawable.run1));
        images.add(BitmapFactory.decodeResource(getResources(),R.drawable.run2));
        images.add(BitmapFactory.decodeResource(getResources(),R.drawable.run3));
        images.add(BitmapFactory.decodeResource(getResources(),R.drawable.run4));
        images.add(BitmapFactory.decodeResource(getResources(),R.drawable.jump));
        images.add(BitmapFactory.decodeResource(getResources(),R.drawable.fall));


        Bitmap jumperBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.jumper);
        Bitmap boxBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.box);
        Bitmap platformBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.platformr);
        Bitmap background1Bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.background1);
        Bitmap background2Bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.background2);
        Bitmap levelChangerBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.changer);


        player = new Player(5, 600,images);
        jumper = new Jumper(200,100,jumperBitmap);
        box1 = new Box(865,630,boxBitmap);
        platform = new Platform(1300,100,platformBitmap);
        levelChanger = new LevelChanger(1560, 590, levelChangerBitmap);
        movingObjectsArray[0] = jumper;
        movingObjectsArray[1] = box1;
        movingObjectsArray[2] = platform;
        nonMovingObjectsArray[0] = levelChanger;


        background = new Background(0,0,background1Bitmap);

        thread = new Thread(this);


        thread.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float floatx = event.getX();
        int x = (int)floatx;
        float floaty = event.getY();
        int y = (int)floaty;
        boolean moving = false;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                for (int i = 0; i<movingObjectsArray.length && !moving; i++){
                    movingObjectsArray[i].downEvent (x,y);
                    if(movingObjectsArray[i].getState() == 'm'){
                        moving = true;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                for (int i = 0 ;i < movingObjectsArray.length; i++){
                    movingObjectsArray[i].upEvent();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                for (int i = 0; i<movingObjectsArray.length; i++){
                    movingObjectsArray[i].moveEvent(x,y);
                }
                break;
            default:

                break;

        }
        return true;
    }

    @Override
    public void run() {
        while (true){
            move();
            drawSurface();

        }
    }
    private void move(){
        for (int i = 0; i < movingObjectsArray.length; i++) {
            if (movingObjectsArray[i].getState() == 'i') {
                if (player.checkCollision(movingObjectsArray[i])) {
                    if (movingObjectsArray[i].getState() == 'i') {
                        movingObjectsArray[i].processCollision(player);
                    }
                }
            }

        }
        for (int i = 0; i < nonMovingObjectsArray.length; i++) {
                if (player.checkCollision(nonMovingObjectsArray[i])) {
                        nonMovingObjectsArray[i].processCollision(player);
                }
        }

        player.move();

    }
    private void restoreDefault(){
        player.setX(5);
        player.setY(600);
        player.setJumping(false);
        box1.setX(865);
        box1.setY(60);
        jumper.setX(200);
        jumper.setY(100);
        platform.setX(1350);
        platform.setY(100);
    }


    private void drawSurface(){
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            if (level == 2){
                background.setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.background2));
                restoreDefault();
                level =3;
            }
            background.draw(canvas);
            player.draw(canvas);
            jumper.draw(canvas);
            box1.draw(canvas);
            platform.draw(canvas);
            levelChanger.draw(canvas);

            getHolder().unlockCanvasAndPost(canvas);

        }


    }

}
