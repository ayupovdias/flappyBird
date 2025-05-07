package com.mygame.test;

import com.badlogic.gdx.math.Vector2;

public class Back {
    private Background[] backgrounds;
    private int speed;

    public Back(){
        backgrounds=new Background[3];
        speed=1;
        backgrounds[0]=new Background("light.jpg",new Vector2(0f,0f));
        backgrounds[1]=new Background("light.jpg",new Vector2(360f,0f));
        backgrounds[2]=new Background("light.jpg",new Vector2(720,0));

    }

    public void update(){
        for(int i=0;i<3;i++){
             backgrounds[i].update(speed);
        }
        if(backgrounds[0].getPositionX()<0){
            backgrounds[0].setPositionX(0);
            backgrounds[1].setPositionX(360);
            backgrounds[2].setPositionX(720);
        }
    }

    public Background getBackground(int i){
        return backgrounds[i];
    }
}
