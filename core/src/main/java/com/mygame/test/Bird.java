package com.mygame.test;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Bird {
    private final Texture texture;
    private final Vector2 position;
    private float velocity;
    private static final float GRAVITY = -15f;
    private static final float JUMP_FORCE = 3.5f;

    public Bird() {
        texture = new Texture("bird1.png");
        position = new Vector2(100, 320);
        velocity = 0;
    }

    public void update(float delta) {
        velocity += GRAVITY * delta;
        position.y += velocity;
        if (InputHandler.getInstance().isSpacePressed()) {
            velocity = JUMP_FORCE;
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, 50, 48);
    }

    public void dispose() {
        texture.dispose();
    }
}
