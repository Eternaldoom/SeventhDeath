package com.xv435.SeventhDeath.game;



import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import com.xv435.SeventhDeath.game.Entities.Player;

public class Game {
	private Player player;
	private int x;
	private int y;

	
    public Game() {
    	
    }
    public void start(int width, int height) throws IOException {
		try {
			Display.setDisplayMode(new DisplayMode(width,height));
			Display.setTitle("Legend Of Z");
			Display.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			System.out.println("[It crashed! We're all doomed!]");
			e.printStackTrace();
			System.exit(0);
		}
        this.registerEntities();
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);    
		GL11.glEnable(GL11.GL_BLEND);
		

		x = 50;
		y = 50;
		
		
		while (!Display.isCloseRequested()) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);


			this.inputEvents();
			this.events();
			this.renderBackground(player.x, player.y);
			this.renderEntities();
			
			Display.update();

			Display.sync(180);
		}
		
		Display.destroy();
    }
    
    public void inputEvents() {
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT) == true) {
			x = x - 3;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT) == true) {
			x = x + 3;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_UP) == true) {
			y = y - 3;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN) == true) {
			y = y + 3;
		}

    }
    public void events() {
    	
    }
    public void renderBackground(int x, int y) {
    	
    }
    public void renderEntities() {
    	player.render();

    }
    public void registerEntities() {
    	player = new Player();
    }
}
