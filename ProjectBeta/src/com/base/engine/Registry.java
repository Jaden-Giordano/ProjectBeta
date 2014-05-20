package com.base.engine;

import java.util.ArrayList;

public class Registry {
	
	private static ArrayList<Block> blocks = new ArrayList<Block>();

	public static void Add(Block b) {
		blocks.add(b);
	}
	
	public static Block Get(int id) {
		for (Block i : blocks) {
			if (i.GetID() == id) {
				return i;
			}
		}
		return null;
	}

}
