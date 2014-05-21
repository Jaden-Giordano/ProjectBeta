package com.base.engine;

import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.base.helpers.FileHelper;

public class Game {
	
	World test;
	Block blocks;
	int x, y;
	
	public Game() throws IOException {
		test = new World(FileHelper.LoadTileData("/res/blah.txt", 26));
		blocks = new Block();
		blocks.InitBlocks();
		this.x = 0;
		this.y = 0;
	}

	public void GetInput() {
		if (Keyboard.isKeyDown(Keyboard.KEY_W))
			y--;
		if (Keyboard.isKeyDown(Keyboard.KEY_S))
			y++;
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
			x--;
		if (Keyboard.isKeyDown(Keyboard.KEY_A))
			x++;
	}
	
	public void Update() {
		GL11.glViewport(x, y, 1600, 1200);
	}
	
	public void Draw() {
		test.Draw();
	}
	
}
