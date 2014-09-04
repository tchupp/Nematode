package com.nematode.gui;

import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.nullmodel.NullNematodeVideoFrame;

public class NematodeVideoPanelViewController implements
NematodePanelViewControllerInterface {

	private final NematodeVideoPanel nematodeVideoPanel;
	private final NematodeVideoFrameInterface nematodeVideoFrame;

	public NematodeVideoPanelViewController() {
		this.nematodeVideoPanel = new NematodeVideoPanel();
		this.nematodeVideoFrame = NullNematodeVideoFrame.NULL;
	}

	@Override
	public NematodePanel getNematodePanel() {
		return this.nematodeVideoPanel;
	}

	public NematodeVideoFrameInterface getNematodeVideoFrame() {
		return this.nematodeVideoFrame;
	}
}
