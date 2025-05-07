package com.mygame.test;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class WallPair {
    private final Wall topWall;
    private final Wall bottomWall;
    private final float gapY;

    public WallPair(float x, float gapY) {
        this.gapY = gapY;
        topWall = new Wall(x, gapY + 440, true);
        bottomWall = new Wall(x, gapY - 400, false);
    }
    public Rectangle getTopBounds(){
        return topWall.getBounds();
    }
    public Rectangle getBottomBounds(){
        return bottomWall.getBounds();
    }
    public Wall getTopWall(){
        return topWall;
    }
    public Wall getBottomWall(){
        return bottomWall;
    }
    public void update(float speed) {
        topWall.update(speed);
        bottomWall.update(speed);
    }

    public void render(SpriteBatch batch) {
        topWall.render(batch);
        bottomWall.render(batch);
    }

    public void dispose() {
        topWall.dispose();
        bottomWall.dispose();
    }
}
