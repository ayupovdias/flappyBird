package com.mygame.test;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

public class GameEngineFacade {
    private final BackgroundManager background;
    private final Bird bird;
    private final PipeFactory pipeFactory;
    private final ArrayList<Pipe> pipes;
    private final DifficultyStrategy difficulty;
    private float pipeTimer = 0;
    private final float spawnInterval = 2f;
    private int score = 0;

    public GameEngineFacade(DifficultyStrategy difficulty) {
        this.difficulty = difficulty;
        background = new BackgroundManager();
        bird = new Bird(difficulty);
        pipes = new ArrayList<>();
        pipeFactory = new PipeFactory(difficulty);
    }

    public void update(float delta) {
        background.update(delta);
        bird.update(delta);

        pipeTimer += delta;
        if (pipeTimer >= spawnInterval) {
            pipes.add(pipeFactory.createPipe(800));
            pipeTimer = 0;
        }

        Iterator<Pipe> iter = pipes.iterator();
        while (iter.hasNext()) {
            Pipe pipe = iter.next();
            pipe.move(difficulty.getPipeSpeed() * delta);

            if (!pipe.scored && pipe.bottomRect.x + pipe.bottomRect.width < bird.getRect().x) {
                score++;
                pipe.scored = true;
            }

            if (pipe.isOffScreen()) {
                iter.remove();
            }
        }
    }

    public void render(SpriteBatch batch) {
        background.render(batch);
        bird.render(batch);
        for (Pipe pipe : pipes) {
            pipe.render(batch);
        }
    }

    public boolean isGameOver() {
        if (bird.getRect().y < 0 || bird.getRect().y + bird.getRect().height > 640) {
            return true;
        }
        for (Pipe pipe : pipes) {
            if (pipe.bottomRect.overlaps(bird.getRect()) || pipe.topRect.overlaps(bird.getRect())) {
                return true;
            }
        }
        return false;
    }

    public void flap() {
        bird.flap();
    }

    public int getScore() {
        return score;
    }

    public void dispose() {
        background.dispose();
        bird.dispose();
    }
}
