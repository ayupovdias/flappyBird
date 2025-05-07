package com.mygame.test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tubes {
    private Texture texture;
    private Tube[] tubes;
    private int spacing;
    private int startX;

    public Tubes() {
        texture = new Texture("wall.png");
        spacing = 120; // расстояние между трубами
        startX = 720;

        tubes = new Tube[6];
        int x = startX;
        for (int i = 0; i < tubes.length; i++) {
            tubes[i] = new Tube(new Vector2(x, 0));
            x += spacing;
        }
    }

    public void render(SpriteBatch batch) {
        for (Tube tube : tubes) {
            // рисуем нижнюю трубу
            batch.draw(texture, tube.getX(), -tube.getOffset());

            // рисуем верхнюю трубу (размер окна: 640)
            batch.draw(texture, tube.getX(), 640 - tube.getOffset());
        }
    }

    public void update() {
        for (Tube tube : tubes) {
            tube.update();
        }
    }

    public int getLength() {
        return tubes.length;
    }

    public float getPositionById(int id) {
        return tubes[id].getX();
    }

    public Tube getTubeById(int id) {
        return tubes[id];
    }

    public void recreate() {
        int x = startX;
        for (int i = 0; i < tubes.length; i++) {
            tubes[i] = new Tube(new Vector2(x, 0));
            x += spacing;
        }
    }
}
