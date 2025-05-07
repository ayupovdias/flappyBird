package com.mygame.test;


import java.util.List;
import java.util.ArrayList;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayState implements GameState {
    private final Bird bird;
    private final List<WallPair> walls;
    private final WallFactory wallFactory;
    private final CollisionManager collisionManager;
    private float timeSinceLastWall = 0;

    public PlayState() {
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
        // Обновление птицы и фона
        bird.update(delta);
        bird.render(batch);
        for(WallPair wall :walls){
            wall.render(batch);
        }

        // Генерация труб
        timeSinceLastWall += delta;
        if (timeSinceLastWall >= 2) {
            walls.add(wallFactory.createWallPair(720));
            timeSinceLastWall = 0;
        }

        // Проверка столкновений
        collisionManager.checkCollisions();
    }

    @Override
    public void dispose() {


    }
}
