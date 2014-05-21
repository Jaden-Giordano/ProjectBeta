package com.base.engine;

import java.util.ArrayList;

public class World {
	
	int[][] data;
	ArrayList<GameObject> objs;

	public World(int[][] worldData) {
		objs = new ArrayList<GameObject>();
		this.data = worldData;
		Block tmp = new Block();
		tmp.InitBlocks();
		
		LoadWorld();
	}
	
	private void LoadWorld() {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				objs.add(new GameObject(i*32, j*32, Registry.Get(data[i][j])));
			}
		}
	}
	
	public void Draw() {
		for (GameObject i : objs) {
			i.Draw();
		}
	}

}
