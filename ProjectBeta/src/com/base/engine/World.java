package com.base.engine;

import java.util.ArrayList;

public class World {
	
	int[][] data;
	ArrayList<GameObject> objs;

	public World(int[][] worldData) {
		this.data = worldData;
		objs = new ArrayList<GameObject>();
		Block tmp = new Block();
		tmp.InitBlocks();
		
		LoadWorld();
	}
	
	private void LoadWorld() {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				objs.add(new GameObject(i * 800/data.length, j * 600/data[i].length, Registry.Get(data[j][i])));
			}
		}
	}
	
	public void Draw() {
		for (GameObject i : objs) {
			i.Draw();
		}
	}

}
