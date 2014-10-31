package com.nematode.model;

import com.nematode.gui.VideoPanelViewControllerInterface;

public class DisplayFrameImageChangeObserver implements VideoFrameObserverInterface {

	private final VideoPanelViewControllerInterface videoPanelViewController;

	public DisplayFrameImageChangeObserver(
			final VideoPanelViewControllerInterface videoPanelViewController) {
		this.videoPanelViewController = videoPanelViewController;
	}

	@Override
	public void notifyVideoFrameHasBeenSet() {
	}

	@Override
	public void notifyDisplayFrameHasBeenSet() {
		this.videoPanelViewController.updateVideoDisplay();
	}

	public VideoPanelViewControllerInterface getPanelViewController() {
		return this.videoPanelViewController;
	}

}
