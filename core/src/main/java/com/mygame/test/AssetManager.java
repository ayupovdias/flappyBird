package com.mygame.test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;

public class AssetManager {

    private static AssetManager instance;


    public Texture background;
    public Texture bird;
    public Texture wall;
    public Texture restart;


    private AssetManager() {}


    public static AssetManager getInstance() {
        if (instance == null) {
            instance = new AssetManager();
        }
        return instance;
    }


    public void loadAssets() {
        try{
            background = new Texture("back.jpg");
            bird = new Texture("bird1.png");
            wall = new Texture("wall.png");
            restart = new Texture("restart.png");
        }catch(Exception e){
            Gdx.app.error("Assets","Error");
        }

    }


    public void dispose() {
        background.dispose();
        bird.dispose();
        wall.dispose();
        restart.dispose();
    }
}
