package com.xv435.SeventhDeath.game;



import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.xv435.SeventhDeath.game.Entities.Player;

public class Game {
	private Player player;
	private Texture mapTexture;
	
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
		
	    try {
			mapTexture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("assets/map.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

    	mapTexture.bind();

		
		
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
    	if (Keyboard.isKeyDown(Keyboard.KEY_D) == true) {
    		player.RenderX += 1;
    	}
    	if (Keyboard.isKeyDown(Keyboard.KEY_A) == true) {
    		player.RenderX -= 1;
    	}
    	if (Keyboard.isKeyDown(Keyboard.KEY_W) == true) {
    		player.RenderY += 1;
    	}
    	if (Keyboard.isKeyDown(Keyboard.KEY_S) == true) {
    		player.RenderY -= 1;
    	}
    	if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) == true) {
    		player.attack();
    	}

    }
    public void events() {
    	
    }
    public void renderBackground(int x, int y) {
    	GL11.glBegin(GL11.GL_QUADS);
    	GL11.glTexCoord2f(player.x,player.y);
    	GL11.glVertex2i(0, 600);
    	GL11.glTexCoord2f(1,0);
    	GL11.glVertex2i(0, 0);
    	GL11.glTexCoord2f(1,1);
    	GL11.glVertex2i(800, 0);
    	GL11.glTexCoord2f(0,1);
    	GL11.glVertex2i(800, 600);
    	GL11.glEnd();
    }
    public void renderEntities() {
    	player.render();

    }
    public void registerEntities() {
    	player = new Player();
    }
}
