package com.sol.mariobros.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sol.mariobros.MarioBros;

public class DesktopLauncher {
    public static void main(String[] arg) {
        System.setProperty("user.name", "seconduser");
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = MarioBros.V_WIDTH * 2;
        config.height = MarioBros.V_HEIGHT * 2;
        new LwjglApplication(new MarioBros(), config);
    }
}
