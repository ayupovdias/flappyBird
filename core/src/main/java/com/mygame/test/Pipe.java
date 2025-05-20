package com.mygame.test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Pipe {
    public Rectangle topRect;
    public Rectangle bottomRect;
    public static Texture texture = new Texture("wallTall.png");
    public boolean scored = false;

    public static final float PIPE_WIDTH = 120f;
    public static final float PIPE_HEIGHT = 724f;

    public Pipe(float x, float gapY, float gapHeight) {
        bottomRect = new Rectangle(x, gapY - PIPE_HEIGHT, PIPE_WIDTH, PIPE_HEIGHT);
        topRect = new Rectangle(x, gapY + gapHeight, PIPE_WIDTH, PIPE_HEIGHT);
    }

    public void move(float dx) {
        bottomRect.x -= dx;
        topRect.x -= dx;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, bottomRect.x, bottomRect.y, PIPE_WIDTH, PIPE_HEIGHT);
        batch.draw(texture,
            topRect.x, topRect.y,
            PIPE_WIDTH, PIPE_HEIGHT,
            0, 0,
            texture.getWidth(), texture.getHeight(),
            false, true
        );
    }

    public boolean isOffScreen() {
        return bottomRect.x + bottomRect.width < 0;
    }
}
