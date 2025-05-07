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
    private float scrollSpeed = 2;
    private Bird bird;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("back.jpg");
        bird = new Bird();
    }

    @Override
    public void render() {
        InputHandler.getInstance().update();

        for (int i = 0; i < backgroundOffsets.length; i++) {
            backgroundOffsets[i] -= scrollSpeed;
            if (backgroundOffsets[i] <= -360) backgroundOffsets[i] = 720;
        }

        bird.update(Gdx.graphics.getDeltaTime());

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for (float offset : backgroundOffsets) {
            batch.draw(background, offset, 0, 360, 640);
        }
        bird.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        bird.dispose();
    }
}
