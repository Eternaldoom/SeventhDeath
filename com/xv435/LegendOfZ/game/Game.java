package com.xv435.LegendOfZ.game;



import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.xv435.LegendOfZ.game.Entities.Player;

public class Game {
	private Player player;
	private int x;
	private int y;
	public Texture texture;
	
	
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


			this.keyBinds();
			this.renderEntities();
			
			Display.update();

			Display.sync(180);
		}
		
		Display.destroy();
    }
    
    public void keyBinds() {
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
    
    public void renderEntities() {
	    try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("assets/player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

    	texture.bind();
    	
    	GL11.glBegin(GL11.GL_QUADS);
    	GL11.glTexCoord2f(0,0);
    	GL11.glVertex2i(x,y);
    	GL11.glTexCoord2f(1,0);
    	GL11.glVertex2i(x+texture.getTextureWidth(),y);
    	GL11.glTexCoord2f(1,1);
    	GL11.glVertex2i(x+texture.getTextureWidth(),y+texture.getTextureHeight());
    	GL11.glTexCoord2f(0,1);
    	GL11.glVertex2i(x,y+texture.getTextureHeight());
    	GL11.glEnd();

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 640, 480, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		if (x > 20 && x < 680 && y < 480 && y > 20) {
			GL11.glBegin(GL11.GL_TRIANGLES);
			GL11.glTexCoord2f(0,0);
	    	GL11.glVertex2i(x,y);
	    	GL11.glTexCoord2f(1,0);
	    	GL11.glVertex2i(x+texture.getTextureWidth(),y);
	    	GL11.glTexCoord2f(1,1);
	    	GL11.glVertex2i(x+texture.getTextureWidth(),y+texture.getTextureHeight());
	    	GL11.glTexCoord2f(0,1);
	    	GL11.glVertex2i(x,y+texture.getTextureHeight());
			GL11.glEnd();
        } 
		else {
            x = 50;
            y = 50;
			GL11.glBegin(GL11.GL_TRIANGLES);
			GL11.glTexCoord2f(0,0);
	    	GL11.glVertex2i(x,y);
	    	GL11.glTexCoord2f(1,0);
	    	GL11.glVertex2i(x+texture.getTextureWidth(),y);
	    	GL11.glTexCoord2f(1,1);
	    	GL11.glVertex2i(x+texture.getTextureWidth(),y+texture.getTextureHeight());
	    	GL11.glTexCoord2f(0,1);
	    	GL11.glVertex2i(x,y+texture.getTextureHeight());
			GL11.glEnd();
		}

    }
    public void registerEntities() {
    	player = new Player();
    }
}
