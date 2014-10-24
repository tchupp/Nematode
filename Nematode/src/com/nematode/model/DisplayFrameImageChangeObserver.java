package com.nematode.model;

import com.nematode.gui.VideoPanelViewControllerInterface;

public class DisplayFrameImageChangeObserver implements VideoFrameObserverInterface {

	private final VideoPanelViewControllerInterface panelViewController;

	public DisplayFrameImageChangeObserver(
			final VideoPanelViewControllerInterface panelViewController) {
		this.panelViewController = panelViewController;
	}

	@Override
	public void notifyVideoFrameHasBeenSet() {

	}

	@Override
	public void notifyDisplayFrameHasBeenSet() {
		this.panelViewController.updateImage();
	}

	public VideoPanelViewControllerInterface getPanelViewController() {
		return this.panelViewController;
	}

}
