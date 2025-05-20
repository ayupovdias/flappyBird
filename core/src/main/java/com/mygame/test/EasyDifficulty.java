package com.mygame.test;

public class EasyDifficulty implements DifficultyStrategy {
    @Override public float getPipeSpeed() { return 200; }
    @Override public float getGravity() { return -10; }
    @Override public float getGap() { return 200; }
}

