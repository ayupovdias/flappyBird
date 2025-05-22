package com.mygame.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameScreen implements Screen {
    private final MyGdxGame game;
    private final DifficultyStrategy difficulty;
    private final GameEngineFacade engine;
    private final BitmapFont font;

    public GameScreen(MyGdxGame game, DifficultyStrategy difficulty) {
        this.game = game;
        this.difficulty = difficulty;
        this.engine = new GameEngineFacade(difficulty);
        this.font = new BitmapFont();
    }

    @Override
    public void show() {
        // Ничего не нужно
    }

    @Override
    public void render(float delta) {
        engine.update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        engine.render(game.batch);
        font.getData().setScale(2);
        font.draw(game.batch, "Score: " + engine.getScore(), 20, 620);
        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            engine.flap();
        }

        if (engine.isGameOver()) {
            game.setScreen(new GameOverScreen(game, engine.getScore(), difficulty));
        }
    }

    @Override
    public void resize(int width, int height) {
        // Необязательно
    }

    @Override
    public void pause() {
        // Необязательно
    }

    @Override
    public void resume() {
        // Необязательно
    }

    @Override
    public void hide() {
        // Необязательно
    }

    @Override
    public void dispose() {
        engine.dispose();
        font.dispose();
    }
}
