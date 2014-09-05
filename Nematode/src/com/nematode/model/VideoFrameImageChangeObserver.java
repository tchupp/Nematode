package com.nematode.model;

import com.nematode.gui.NematodePanelViewControllerInterface;

public class VideoFrameImageChangeObserver implements
NematodeVideoFrameObserverInterface {

	private final NematodePanelViewControllerInterface panelViewController;

	public VideoFrameImageChangeObserver(
			final NematodePanelViewControllerInterface panelViewController) {
		this.panelViewController = panelViewController;
	}

	@Override
	public void notifyFrameHasBeenSet() {
		this.panelViewController.updateImage();
	}

	public NematodePanelViewControllerInterface getPanelViewController() {
		return this.panelViewController;
	}

}
