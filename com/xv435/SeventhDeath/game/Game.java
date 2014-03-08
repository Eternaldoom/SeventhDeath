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

    public Game() {
    	
    }
    public void start(int width, int height) throws IOException {
		try {
			Display.setDisplayMode(new DisplayMode(width,height));
			Display.setTitle("Seventh Death");
			Display.create();
			
		} catch (LWJGLException e) {
			System.out.println("[It crashed! We're all doomed!]");
			e.printStackTrace();
			System.exit(0);
		}
        this.registerEntities();
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);    
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 640, 480, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		
		
		while (!Display.isCloseRequested()) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);


			this.inputEvents();
			this.events();
			this.renderBackground(player.x, player.y);
			this.renderEntities();
			
			Display.update();

			Display.sync(60);
		}
		
		Display.destroy();
    }
    
    public void inputEvents() {
    	if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) == true) {
    		player.attack();
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
