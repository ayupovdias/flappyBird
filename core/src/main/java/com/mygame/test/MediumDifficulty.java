package com.mygame.test;

public class MediumDifficulty implements DifficultyStrategy {
    @Override public float getPipeSpeed() { return 250; }
    @Override public float getGravity() { return -12; }
    @Override public float getGap() { return 150; }
}
