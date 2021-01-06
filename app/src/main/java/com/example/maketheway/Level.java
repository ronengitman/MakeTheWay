package com.example.maketheway;

import java.util.List;

public class Level {
    protected Jumper jumper;
    protected Box box1;
    protected Platform platform;
    protected Background background;
    protected LevelChanger levelChanger;
    protected MovingObjects[] movingObjects;
    protected NonMovingObjects[] nonMovingObjects;

    public Level(Jumper jumper, Box box, Platform platform, Background background, LevelChanger levelChanger, MovingObjects[] movingObjects, NonMovingObjects [] nonMovingObjects) {
        this.jumper = jumper;
        this.box1 = box;
        this.platform = platform;
        this.background = background;
        this.levelChanger = levelChanger;
        this.movingObjects = movingObjects;
        this.nonMovingObjects = nonMovingObjects;
    }


}
