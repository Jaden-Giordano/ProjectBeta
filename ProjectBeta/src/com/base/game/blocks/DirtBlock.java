package com.base.game.blocks;

import com.base.engine.Block;
import com.base.helpers.FileHelper;

public class DirtBlock extends Block {

	public DirtBlock() {
		this.SetTexture(FileHelper.LoadTexture("/assets/objects/blocks/dirt.png"));
	}

}
