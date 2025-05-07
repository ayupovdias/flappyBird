package com.mygame.test;


import com.badlogic.gdx.Input;

public class InputHandler {
    private static InputHandler instance;
    private boolean spacePressed;

    private InputHandler() {}

    public static InputHandler getInstance() {
        if (instance == null) {
            instance = new InputHandler();
        }
        return instance;
    }

    public void update() {
        spacePressed = com.badlogic.gdx.Gdx.input.isKeyPressed(Input.Keys.SPACE);
    }

    public boolean isSpacePressed() {
        return spacePressed;
    }
}
