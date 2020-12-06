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
    private Box box2;
    private Platform platform;
    private Background background;
    private Objects[] arry = new Objects[3];
    private Player player;





    public GameView(Context context) {
        super(context);
        ArrayList<Bitmap> images = new ArrayList<>();
        images.add(BitmapFactory.decodeResource(getResources(),R.drawable.run1));
        images.add(BitmapFactory.decodeResource(getResources(),R.drawable.run2));
        images.add(BitmapFactory.decodeResource(getResources(),R.drawable.run3));
        images.add(BitmapFactory.decodeResource(getResources(),R.drawable.run4));


        Bitmap jumperBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.jumper);
        Bitmap boxBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.box);
        Bitmap platformBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.platformr);
        Bitmap backgroundBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        player = new Player(300, 600,images);
        jumper = new Jumper(200,100,jumperBitmap);
        box1 = new Box(865,630,boxBitmap);
        platform = new Platform(1300,100,platformBitmap);
        arry[0] = jumper;
        arry[1] = box1;
        arry[2] = platform;
        background = new Background(0,0,backgroundBitmap);
        thread = new Thread(this);

        thread.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        boolean moving=false;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                for (int i=0;i<arry.length && !moving;i++){
                    arry[i].downEvent(x,y);
                    if(arry[i].getState()=='m'){
                        moving=true;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                for (int i=0;i<arry.length;i++){
                    arry[i].upEvent(x,y);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                for (int i=0;i<arry.length;i++){
                    arry[i].moveEvent(x,y);
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
        player.move();

    }
    private void drawSurface(){
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            background.draw(canvas);
            player.draw(canvas);
            jumper.draw(canvas);
            box1.draw(canvas);
            platform.draw(canvas);

            getHolder().unlockCanvasAndPost(canvas);

        }

    }
}
