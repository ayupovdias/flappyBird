package com.mygame.test;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
public class Wall {
    private final Texture texture;
    private float x;
    private final float y;
    private final boolean isTop;
    private final Rectangle bounds;

    public Wall(float x, float y, boolean isTop) {
        texture =AssetManager.getInstance().wall;
        this.x = x;
        this.y = y;
        this.isTop = isTop;
        bounds = new Rectangle(x, y, 50,300);
        if(isTop) bounds.height*=-1;
    }
    public Rectangle getBounds() { return bounds; }

    public void update(float speed) {
        x -= speed;
        bounds.setX(x);
    }

    public void render(SpriteBatch batch) {
        float height = isTop ? -300 : 300;
        batch.draw(texture, x, y, 50, height);
    }



    public float getX() { return x; }
    public float getY() { return y; }
    public boolean isTop() { return isTop; }
}
