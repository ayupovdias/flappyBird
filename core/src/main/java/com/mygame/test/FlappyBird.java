package com.mygame.test;
import java.util.List;
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBird extends ApplicationAdapter {
    private SpriteBatch batch;
    private float[] backgroundOffsets = {0, 360, 720};
    private float scrollSpeed = 2;

    @Override
    public void create() {
        batch = new SpriteBatch();
        AssetManager.getInstance().loadAssets(); // Загрузка всех текстур
        GameStateManager.getInstance().setState(new PlayState());
    }

    @Override
    public void render() {
        InputHandler.getInstance().update();

        for (int i = 0; i < backgroundOffsets.length; i++) {
            backgroundOffsets[i] -= scrollSpeed;
            if (backgroundOffsets[i] <= -360) backgroundOffsets[i] = 720;
        }

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for (float offset : backgroundOffsets) {
            batch.draw(AssetManager.getInstance().background, offset, 0, 360, 640);
        }
        GameStateManager.getInstance().render(batch, Gdx.graphics.getDeltaTime());
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        AssetManager.getInstance().dispose();
    }
}
