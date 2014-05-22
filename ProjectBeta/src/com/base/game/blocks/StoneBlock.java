package com.base.game.blocks;

import com.base.engine.Block;
import com.base.helpers.FileHelper;

public class StoneBlock extends Block {

	public StoneBlock() {
		this.SetTexture(FileHelper.LoadTexture("/assets/objects/blocks/stone.png"));
	}

}
