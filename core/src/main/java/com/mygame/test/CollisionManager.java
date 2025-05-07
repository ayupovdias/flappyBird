package com.mygame.test;


import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class CollisionManager {
    private final List<CollisionListener> listeners = new ArrayList<>();
    private final Bird bird;
    private final List<WallPair> walls;

    public CollisionManager(Bird bird, List<WallPair> walls) {
        this.bird = bird;
        this.walls = walls;
    }

    public void checkCollisions() {
        if (bird.getY() < 0 || bird.getY() > 640 - 48) {
            notifyListeners();
            return;
        }


        Rectangle birdBounds = bird.getBounds();
        for (WallPair wall : walls) {
            if (Intersector.overlaps(birdBounds, wall.getTopBounds())) {
                notifyListeners();
            }
            if (Intersector.overlaps(birdBounds, wall.getBottomBounds())) {
                notifyListeners();
            }
        }
    }
    public void addListener(CollisionListener listener){
        listeners.add(listener);
    }

    private void notifyListeners() {
        for (CollisionListener listener : listeners) {
            listener.onCollision();
        }
    }
}
