package com.mygame.test;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class Wall {
    private final Texture texture;
    private float x;
    private final float y;
    private final boolean isTop;

    public Wall(float x, float y, boolean isTop) {
        this.texture = new Texture("wall.png");
        this.x = x;
        this.y = y;
        this.isTop = isTop;
    }

    public void update(float speed) {
        x -= speed;
    }

    public void render(SpriteBatch batch) {
        float height = isTop ? -300 : 300;
        batch.draw(texture, x, y, 50, height);
    }

    public void dispose() {
        texture.dispose();
    }

    public float getX() { return x; }
    public float getY() { return y; }
    public boolean isTop() { return isTop; }
}
