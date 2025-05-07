package com.mygame.test;


import com.badlogic.gdx.math.MathUtils;

public class WallFactory {
    private static final float GAP_MIN = 200;
    private static final float GAP_MAX = 400;

    public WallPair createWallPair(float x) {
        float gapY = MathUtils.random(GAP_MIN, GAP_MAX);
        return new WallPair(x, gapY);
    }
}
