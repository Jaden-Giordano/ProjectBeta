package com.base.game;

import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.TrueTypeFont;

import com.base.engine.World;
import com.base.helpers.FileHelper;

public class Game {
	
	ArrayList<World> worlds;
	int currentWorld;
	
	TrueTypeFont test;
	
	public Game() throws IOException {
		worlds = new ArrayList<World>();
		
		test = FileHelper.GetFont("/assets/fonts/Ubuntu-R.ttf", 24f);
		
		LoadWorlds();
	}
	
	private void LoadWorlds() throws IOException {
		World test = new World(FileHelper.LoadTileData("/assets/worlds/test", 4));
		
		worlds.add(test);
		
		currentWorld = 0;
	}

	public void GetInput() {
		worlds.get(currentWorld).GetInput();
	}
	
	public void Update() {
		worlds.get(currentWorld).Update();
	}
	
	public void Draw() {
		worlds.get(currentWorld).Draw();
		if (test != null) {
			test.drawString(0, 120, "This is ELK!");
		}
	}
	
}
