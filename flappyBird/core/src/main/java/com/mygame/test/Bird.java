package com.mygame.test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Bird {
    private Texture texture;
    private Vector2 position;
    private float y;
    private float gravity;
    private Rectangle bounds;

    public Bird() {
        texture = new Texture("bird1.png");
        position = new Vector2(100, 200);
        y = 0;
        gravity = 0.5f;
        bounds = new Rectangle(position.x, position.y, 50, 48);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            y = 4;
        }
        y -= gravity;
        position.y += y;

        bounds.setPosition(position.x, position.y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Texture getTexture() {
        return texture;
    }

    public float getY() {
        return y;
    }

    public float getGravity() {
        return gravity;
    }

    public void recreate() {
        position.set(100, 200);
        y = 0;
        bounds.setPosition(position.x, position.y);
    }
}
