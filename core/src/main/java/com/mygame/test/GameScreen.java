package com.mygame.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.ArrayList;
import java.util.Iterator;

public class GameScreen implements Screen {
    private final MyGdxGame game;
    private final DifficultyStrategy difficulty;


    private Texture bg;
    private Texture birdTexture;

    private float bgX1, bgX2, bgX3;
    private float bgSpeed = 100;

    private Rectangle bird;
    private float birdVelocity = 0;

    private BitmapFont font;
    private int score = 0;

    private ArrayList<Pipe> pipes;
    private PipeFactory pipeFactory;
    private float pipeTimer=0;
    private float spawnInterval=2f;

    public GameScreen(MyGdxGame game, DifficultyStrategy difficulty) {
        this.game = game;
        this.difficulty = difficulty;

        bg = new Texture("back.png");
        birdTexture = new Texture("bird1.png");

        bgX1 = 0;
        bgX2 = 360;
        bgX3 = 720;

        bird = new Rectangle(100, 320, 50, 48);

        font = new BitmapFont();

        pipes=new ArrayList<>();
        pipeFactory=new PipeFactory(difficulty);
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0.5f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(bg, bgX1, 0);
        game.batch.draw(bg, bgX2, 0);
        game.batch.draw(bg, bgX3, 0);

        game.batch.draw(birdTexture, bird.x, bird.y);

        font.getData().setScale(2);
        for(Pipe pipe:pipes){
            pipe.render(game.batch);
        }
        font.draw(game.batch, "Score: " + score, 20, 620);
        game.batch.end();

    }

    private void update(float delta) {
        float move = bgSpeed * delta;
        bgX1 -= move;
        bgX2 -= move;
        bgX3 -= move;

        if (bgX1 + 360 <= 0) bgX1 = bgX3 + 360;
        if (bgX2 + 360 <= 0) bgX2 = bgX1 + 360;
        if (bgX3 + 360 <= 0) bgX3 = bgX2 + 360;

        birdVelocity += difficulty.getGravity();
        bird.y += birdVelocity * delta;

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            birdVelocity = 350;
        }


        if (bird.y < 0 || bird.y + bird.height > 640) {
            game.setScreen(new GameOverScreen(game, score, difficulty));
        }

        pipeTimer += delta;
        if (pipeTimer >= spawnInterval) {
            pipes.add(pipeFactory.createPipe(800));
            pipeTimer = 0;
        }


        Iterator<Pipe> iter = pipes.iterator();
        while (iter.hasNext()) {
            Pipe pipe = iter.next();
            pipe.move(difficulty.getPipeSpeed() * delta);

            if (pipe.bottomRect.overlaps(bird) || pipe.topRect.overlaps(bird)) {
                game.setScreen(new GameOverScreen(game, score, difficulty));
            }

            if (!pipe.scored && pipe.bottomRect.x + pipe.bottomRect.width < bird.x) {
                score++;
                pipe.scored = true;
            }

            if (pipe.isOffScreen()) {
                iter.remove();
            }
        }

    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {
        bg.dispose();
        birdTexture.dispose();
        font.dispose();
    }

    @Override public void show() {}
}
