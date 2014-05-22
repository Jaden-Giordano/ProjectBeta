package com.base.game.blocks;

import com.base.engine.Block;
import com.base.helpers.FileHelper;

public class DefaultBlock extends Block {

	public DefaultBlock() {
		this.SetTexture(FileHelper.LoadTexture("/assets/objects/blocks/default.png"));
	}

}
