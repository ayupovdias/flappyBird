package com.mygame.test;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class GameStateManager {
    private static GameStateManager instance;
    private GameState currentState;

    private GameStateManager() {}

    public static GameStateManager getInstance() {
        if (instance == null) instance = new GameStateManager();
        return instance;
    }

    public void setState(GameState state) {
        if (currentState != null) currentState.dispose();
        currentState = state;
    }

    public void render(SpriteBatch batch, float delta) {
        if (currentState != null) currentState.render(batch, delta);
    }
}
