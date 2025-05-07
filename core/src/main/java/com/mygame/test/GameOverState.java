package com.mygame.test;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
public class GameOverState implements GameState {
    private final Texture restartTexture;

    public GameOverState() {
        restartTexture = AssetManager.getInstance().restart;
    }

    @Override
    public void render(SpriteBatch batch, float delta) {
        batch.draw(restartTexture, 160, 220, 400, 200);


        if (InputHandler.getInstance().isSpacePressed()) {
            GameStateManager.getInstance().setState(new PlayState(2f));
        }
    }

    @Override
    public void dispose() {

    }
}
