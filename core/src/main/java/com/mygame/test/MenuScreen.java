package com.mygame.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input;

public class MenuScreen implements Screen {
    private final MyGdxGame game;
    private final BitmapFont font;

    public MenuScreen(MyGdxGame game) {
        this.game = game;
        this.font = new BitmapFont();
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0.4f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        SpriteBatch batch = game.batch;
        batch.begin();
        font.getData().setScale(2);
        font.draw(batch, "FLAPPY BIRD", 250, 500);
        font.draw(batch, "Press 1 - Easy", 250, 400);
        font.draw(batch, "Press 2 - Medium", 250, 350);
        font.draw(batch, "Press 3 - Hard", 250, 300);
        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            game.setScreen(new GameScreen(game, new EasyDifficulty()));
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            game.setScreen(new GameScreen(game, new MediumDifficulty()));
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
            game.setScreen(new GameScreen(game, new HardDifficulty()));
        }
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {
        font.dispose();
    }
}
