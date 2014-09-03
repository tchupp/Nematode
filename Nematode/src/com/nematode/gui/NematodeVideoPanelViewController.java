package com.nematode.gui;

import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.nullmodel.NullNematodeVideoFrame;

public class NematodeVideoPanelViewController {

	private final NematodeVideoPanel nematodeVideoPanel;
	private NematodeVideoFrameInterface nematodeVideoFrame;

	public NematodeVideoPanelViewController() {
		this.nematodeVideoPanel = new NematodeVideoPanel();
		this.nematodeVideoFrame = NullNematodeVideoFrame.NULL;
	}

	public NematodeVideoPanel getNematodeVideoPanel() {
		return this.nematodeVideoPanel;
	}

	public NematodeVideoFrameInterface getNematodeVideoFrame() {
		return this.nematodeVideoFrame;
	}

	public void setNematodeVideoFrame(
			final NematodeVideoFrameInterface nematodeVideoFrame) {
		this.nematodeVideoFrame = nematodeVideoFrame;
	}
}
