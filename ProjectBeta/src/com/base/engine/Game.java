package com.base.engine;

import java.io.IOException;

import com.base.helpers.FileHelper;

public class Game {
	
	World test;
	Block blocks;
	
	public Game() throws IOException {
		test = new World(FileHelper.LoadTileData("/res/blah.txt", 6));
		blocks = new Block();
		blocks.InitBlocks();
	}

	public void GetInput() {
		// TODO NOTHING!!!!
	}
	
	public void Update() {
		
	}
	
	public void Draw() {
		test.Draw();
	}
	
}
