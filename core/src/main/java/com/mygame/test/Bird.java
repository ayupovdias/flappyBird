package com.mygame.test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bird {
    private Texture texture;
    private Rectangle rect;
    private float velocity = 0;
    private final float gravity;

    public Bird(DifficultyStrategy difficulty) {
        this.gravity = difficulty.getGravity();
        texture = new Texture("bird1.png");
        rect = new Rectangle(100, 320, 50, 48);
    }

    public void update(float delta) {
        velocity += gravity;
        rect.y += velocity * delta;
    }

    public void flap() {
        velocity = 350;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, rect.x, rect.y);
    }

    public Rectangle getRect() {
        return rect;
    }

    public void dispose() {
        texture.dispose();
    }
}
