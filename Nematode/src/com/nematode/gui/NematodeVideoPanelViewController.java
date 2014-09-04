package com.nematode.gui;

import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.nullmodel.NullNematodeVideoFrame;

public class NematodeVideoPanelViewController implements
NematodePanelViewControllerInterface {

	private final NematodeVideoPanel nematodeVideoPanel;
	private NematodeVideoFrameInterface nematodeVideoFrame;

	public NematodeVideoPanelViewController() {
		this.nematodeVideoPanel = new NematodeVideoPanel();
		this.nematodeVideoFrame = NullNematodeVideoFrame.NULL;
	}

	public NematodeVideoFrameInterface getNematodeVideoFrame() {
		return this.nematodeVideoFrame;
	}

	public void setNematodeVideoFrame(
			final NematodeVideoFrameInterface nematodeVideoFrame) {
		this.nematodeVideoFrame = nematodeVideoFrame;
	}

	@Override
	public NematodePanel getNematodePanel() {
		return this.nematodeVideoPanel;
	}
}
