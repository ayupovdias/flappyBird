package com.mygame.test;

import java.util.Random;

public class PipeFactory {
    private final DifficultyStrategy difficulty;
    private final Random rand;

    public PipeFactory(DifficultyStrategy difficulty) {
        this.difficulty = difficulty;
        this.rand = new Random();
    }

    public Pipe createPipe(float x) {
        float minY = 50;
        float maxY = 400;
        float gapY = minY + rand.nextFloat() * (maxY - minY);
        return new Pipe(x, gapY, difficulty.getGap());
    }
}
