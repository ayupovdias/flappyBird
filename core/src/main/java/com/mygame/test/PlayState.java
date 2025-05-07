package com.mygame.test;


import java.util.List;
import java.util.ArrayList;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayState implements GameState {
    private final Bird bird;
    private final List<WallPair> walls;
    private final WallFactory wallFactory;
    private final CollisionManager collisionManager;
    private final float scrollSpeed;
    private float timeSinceLastWall = 0;

    public PlayState(float scrollSpeed) {
        this.scrollSpeed=scrollSpeed;
        bird = new Bird();
        walls = new ArrayList<>();
        wallFactory = new WallFactory();
        collisionManager = new CollisionManager(bird, walls);

        collisionManager.addListener(() -> {
            GameStateManager.getInstance().setState(new GameOverState());
        });
    }

    @Override
    public void render(SpriteBatch batch, float delta) {
        walls.forEach(wall->wall.update(this.scrollSpeed));
        bird.update(delta);
        bird.render(batch);
        for(WallPair wall :walls){
            wall.render(batch);
        }


        timeSinceLastWall += delta;
        if (timeSinceLastWall >= 2) {
            walls.add(wallFactory.createWallPair(720));
            timeSinceLastWall = 0;
        }


        collisionManager.checkCollisions();
    }

    @Override
    public void dispose() {


    }
}
