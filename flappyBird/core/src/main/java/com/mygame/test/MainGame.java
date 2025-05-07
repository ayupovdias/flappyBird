package com.mygame.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Input;

public class MainGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Back back;
    private Bird bird;
    private Tubes tubes;
    private Texture restart;
    private boolean gameOver;

    @Override
    public void create() {
        batch = new SpriteBatch();
        back = new Back();
        bird = new Bird();
        tubes = new Tubes();
        restart = new Texture("restart.png");
        gameOver = false;
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.2f, 0.2f, 0.2f, 1f);
        update();

        batch.begin();
        for (int i = 0; i < 3; i++) {
            batch.draw(back.getBackground(i).getTexture(),
                back.getBackground(i).getPositionX(),
                back.getBackground(i).getPositionY());
        }

        if (!gameOver) {
            bird.render(batch);
        } else {
            batch.draw(restart, 180, 200);
        }

        tubes.render(batch);
        batch.end();
    }

    public void update() {
        if (!gameOver) {
            back.update();
            bird.update();
            tubes.update();

            for (int i = 0; i < tubes.getLength(); i++) {
                Tube tube = tubes.getTubeById(i);
                if (tube.getTopRect().overlaps(bird.getBounds()) ||
                    tube.getBottomRect().overlaps(bird.getBounds())) {
                    gameOver = true;
                }
            }

            if (bird.getY() < 0 || bird.getY() > 640) {
                gameOver = true;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameOver) {
            recreate();
        }
    }

    public void recreate() {
        bird.recreate();
        tubes.recreate();
        gameOver = false;
    }

    @Override
    public void dispose() {
        batch.dispose();
        restart.dispose();
    }
}

