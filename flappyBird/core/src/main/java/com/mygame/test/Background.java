package com.mygame.test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Background {
    private Texture texture;
    private Vector2 position;

    public Background(String picture,Vector2 position){
        texture=new Texture(picture);
        this.position=position;
    }
    public void update(int speed){
        position.x-=speed;
    }
    public float getPositionX(){
        return position.x;
    }
    public void setPositionX(float x){
        position.x=x;
    }
    public float getPositionY(){
        return position.y;
    }
    public Texture getTexture(){
        return texture;
    }
}
