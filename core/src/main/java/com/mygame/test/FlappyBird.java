package com.mygame.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBird extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture background;
    private float[] backgroundOffsets = {0, 360, 720};

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("back.jpg");
    }

    @Override
    public void render() {
        // Очистка экрана
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        for (int i = 0; i < backgroundOffsets.length; i++) {
            backgroundOffsets[i] -= 2;
            if (backgroundOffsets[i] <= -360) {
                backgroundOffsets[i] = 720;
            }
        }


        batch.begin();
        for (float offset : backgroundOffsets) {
            batch.draw(background, offset, 0, 360, 640);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
    }
}
