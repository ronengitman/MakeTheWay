package com.example.maketheway;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {
    private Thread thread;
    private Sprite sprite;
    private Jumper jumper;
    private Box box;
    private Platform platform;
    private Background background;




    public GameView(Context context) {
        super(context);
        Bitmap spriteBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.run1);
        Bitmap jumperBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.jumper);
        Bitmap boxBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.box);
        Bitmap platformBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.platformr);
        Bitmap backgroundBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        sprite = new Sprite(300, 400,spriteBitmap);
        jumper = new Jumper(200,100,jumperBitmap);
        box = new Box(800,60,boxBitmap);
        platform = new Platform(1300,100,platformBitmap);
        background = new Background(0,0,backgroundBitmap);
        thread = new Thread(this);

        thread.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                sprite.downEvent(x,y);
                break;
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_MOVE:

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
        sprite.move();

    }
    private void drawSurface(){
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            background.draw(canvas);
            sprite.draw(canvas);
            jumper.draw(canvas);
            box.draw(canvas);
            platform.draw(canvas);

            getHolder().unlockCanvasAndPost(canvas);

        }

    }
}
