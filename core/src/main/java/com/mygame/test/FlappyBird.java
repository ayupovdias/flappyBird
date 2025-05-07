package com.mygame.test;
import java.util.List;
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBird extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture background;
    private float[] backgroundOffsets = {0, 360, 720};
    private float scrollSpeed = 2;
    private Bird bird;
    private List<WallPair> walls;
    private WallFactory wallFactory;
    private float timeSinceLastWall=0;
    private static final float WALL_SPAWN_TIME=2f;
    private CollisionManager collisionManager;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("back.jpg");
        bird = new Bird();
        walls=new ArrayList<>();
        wallFactory=new WallFactory();
        collisionManager =new CollisionManager(bird, walls);
        collisionManager.addListener(()->{
            Gdx.app.log("COLLISION", "GAME OVER!");
        });
    }

    @Override
    public void render() {
        InputHandler.getInstance().update();

        for (int i = 0; i < backgroundOffsets.length; i++) {
            backgroundOffsets[i] -= scrollSpeed;
            if (backgroundOffsets[i] <= -360) backgroundOffsets[i] = 720;
        }

        bird.update(Gdx.graphics.getDeltaTime());
        collisionManager.checkCollisions();
        timeSinceLastWall+=Gdx.graphics.getDeltaTime();
        if(timeSinceLastWall>=WALL_SPAWN_TIME){
            walls.add(wallFactory.createWallPair(720));
            timeSinceLastWall=0;
        }
        for(WallPair wall:walls){
            wall.update(scrollSpeed);
        }
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for (float offset : backgroundOffsets) {
            batch.draw(background, offset, 0, 360, 640);
        }
        for(WallPair wall:walls){
            wall.render(batch);
        }
        bird.render(batch);
        batch.end();
        walls.removeIf(wall->wall.getTopWall().getX()<-50);
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        bird.dispose();
        for(WallPair wall: walls){
            wall.dispose();
        }
    }
}
