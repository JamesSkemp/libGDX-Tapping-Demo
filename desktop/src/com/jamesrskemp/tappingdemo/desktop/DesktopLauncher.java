package com.jamesrskemp.tappingdemo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jamesrskemp.tappingdemo.TappingDemoGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "libGDX Tapping Demo";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new TappingDemoGame(), config);
	}
}
