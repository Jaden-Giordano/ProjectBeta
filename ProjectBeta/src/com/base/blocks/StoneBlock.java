package com.base.blocks;

import com.base.engine.Block;
import com.base.helpers.FileHelper;

public class StoneBlock extends Block {

	public StoneBlock() {
		this.SetTexture(FileHelper.LoadTexture("/res/blocks/stone.png"));
	}

}
