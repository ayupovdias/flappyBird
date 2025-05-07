package com.mygame.test;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;
import java.util.Random;

public class Tube {
    private Vector2 position;
    private int offset;
    private int speed;
    private Rectangle rectTop;
    private Rectangle rectBottom;

    public Tube(Vector2 vector) {
        position = vector;
        offset = new Random().nextInt(250);
        speed = 1;
        rectTop = new Rectangle();
        rectBottom = new Rectangle();
        update(); // инициализация
    }

    public void update() {
        position.x -= speed;
        if (position.x < -50) {
            position.x = 720;
            offset = new Random().nextInt(250);
        }

        // высота труб: 300, ширина: 50
        rectBottom.set(position.x, -offset, 50, 300);
        rectTop.set(position.x, 640 - offset, 50, 300);
    }

    public float getX() {
        return position.x;
    }

    public int getOffset() {
        return offset;
    }

    public Rectangle getTopRect() {
        return rectTop;
    }

    public Rectangle getBottomRect() {
        return rectBottom;
    }
}
