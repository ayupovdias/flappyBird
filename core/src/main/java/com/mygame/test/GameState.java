package com.mygame.test;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameState {
    void render(SpriteBatch batch, float delta);
    void dispose();
}
