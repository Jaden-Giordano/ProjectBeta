package com.base.blocks;

import com.base.engine.Block;
import com.base.helpers.FileHelper;

public class DirtBlock extends Block {

	public DirtBlock() {
		this.SetTexture(FileHelper.LoadTexture("PNG", "/res/blocks/dirt.png"));
	}

}
