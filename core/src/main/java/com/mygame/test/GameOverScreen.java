package com.mygame.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameOverScreen implements Screen {
    private final MyGdxGame game;
    private final int finalScore;
    private final DifficultyStrategy difficulty;

    private Texture restartTexture;
    private BitmapFont font;

    public GameOverScreen(MyGdxGame game, int score, DifficultyStrategy difficulty) {
        this.game = game;
        this.finalScore = score;
        this.difficulty = difficulty;

        restartTexture = new Texture("restart.png");
        font = new BitmapFont();
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(restartTexture, 160, 250);
        font.getData().setScale(2);
        font.draw(game.batch, "Final Score: " + finalScore, 250, 200);
        font.draw(game.batch, "Press SPACE to restart", 220, 150);
        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            game.setScreen(new MenuScreen(game));
        }
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {
        restartTexture.dispose();
        font.dispose();
    }
}
