package com.sol.mariobros;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sol.mariobros.screens.PlayScreen;

public class MarioBros extends Game {
    public static final int V_WIDTH = 400;
    public static final int V_HEIGHT = 208;
    public static final float PPM = 100;

    public static final Short DEFAULT_BIT = 1;
    public static final Short MARIO_BIT = 2;
    public static final Short BRICK_BIT = 4;
    public static final Short COIN_BIT = 8;
    public static final Short DESTROYED_BIT = 16;

    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new PlayScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
