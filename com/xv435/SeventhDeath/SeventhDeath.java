package com.xv435.SeventhDeath;

import java.io.IOException;

import com.xv435.SeventhDeath.game.Constants;
import com.xv435.SeventhDeath.game.Game;


public class SeventhDeath {
	public static void main(String[] args) throws IOException {
		Constants constant = new Constants();
	    Game Game = new Game();
	    Game.start(constant.width, constant.height);
	}
}
