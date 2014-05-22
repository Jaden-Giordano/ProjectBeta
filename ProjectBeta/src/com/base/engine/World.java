package com.base.engine;

import java.util.ArrayList;

public class World {
	
	ArrayList<GameObject> objs;
	
	Camera cam;
	
	int[][] data;

	public World(int[][] worldData) {
		objs = new ArrayList<GameObject>();
		this.data = worldData;
		
		cam = new Camera(0, 0);
		
		LoadWorld();
	}
	
	private void LoadWorld() {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				objs.add(new GameObject(i*Registry.GetBlock(data[i][j]).GetTexture().getWidth(), j*Registry.GetBlock(data[i][j]).GetTexture().getHeight(),
						Registry.GetBlock(data[i][j])));
			}
		}
	}
	
	public void GetInput() {
		if (cam.IsInViewportMode())
			cam.GetInput();
	}
	
	public void Update() {
		cam.Update();
	}
	
	public void Draw() {
		for (GameObject i : objs) {
			i.Draw();
		}
	}

}
