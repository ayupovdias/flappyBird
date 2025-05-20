package com.mygame.test;

public class HardDifficulty implements DifficultyStrategy {
    @Override public float getPipeSpeed() { return 300; }
    @Override public float getGravity() { return -14; }
    @Override public float getGap() { return 120; }
}
