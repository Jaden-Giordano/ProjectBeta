package com.base.blocks;

import com.base.engine.Block;
import com.base.helpers.FileHelper;

public class DefaultBlock extends Block {

	public DefaultBlock() {
		this.SetTexture(FileHelper.LoadTexture("PNG", "/res/blocks/default.png"));
	}

}
