package com.mygame.test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackgroundManager {
    private Texture bg;
    private float bgX1 = 0, bgX2 = 360, bgX3 = 720;
    private final float bgSpeed = 100;

    public BackgroundManager() {
        bg = new Texture("back.png");
    }

    public void update(float delta) {
        float move = bgSpeed * delta;
        bgX1 -= move;
        bgX2 -= move;
        bgX3 -= move;

        if (bgX1 + 360 <= 0) bgX1 = bgX3 + 360;
        if (bgX2 + 360 <= 0) bgX2 = bgX1 + 360;
        if (bgX3 + 360 <= 0) bgX3 = bgX2 + 360;
    }

    public void render(SpriteBatch batch) {
        batch.draw(bg, bgX1, 0);
        batch.draw(bg, bgX2, 0);
        batch.draw(bg, bgX3, 0);
    }

    public void dispose() {
        bg.dispose();
    }
}
