package com.mygame.test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;

public class AssetManager {
    // Singleton instance
    private static AssetManager instance;

    // Текстуры игры
    public Texture background;  // back.jpg (фон)
    public Texture bird;        // bird1.png (птица)
    public Texture wall;        // wall.png (труба)
    public Texture restart;     // restart.png (экран рестарта)

    // Приватный конструктор (Singleton)
    private AssetManager() {}

    // Метод для получения экземпляра (ленивая инициализация)
    public static AssetManager getInstance() {
        if (instance == null) {
            instance = new AssetManager();
        }
        return instance;
    }

    // Загрузка всех текстур
    public void loadAssets() {
        try{
            background = new Texture("back.jpg"); // 360x640
            bird = new Texture("bird1.png");       // 50x48
            wall = new Texture("wall.png");        // 50x300
            restart = new Texture("restart.png");  // 400x200
        }catch(Exception e){
            Gdx.app.error("Assets","Error");
        }

    }

    // Выгрузка ресурсов
    public void dispose() {
        background.dispose();
        bird.dispose();
        wall.dispose();
        restart.dispose();
    }
}
