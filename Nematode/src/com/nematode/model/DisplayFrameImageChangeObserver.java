package com.nematode.model;

import com.nematode.gui.NematodePanelViewControllerInterface;

public class DisplayFrameImageChangeObserver implements
		NematodeVideoFrameObserverInterface {

	private final NematodePanelViewControllerInterface panelViewController;

	public DisplayFrameImageChangeObserver(
			final NematodePanelViewControllerInterface panelViewController) {
		this.panelViewController = panelViewController;
	}

	@Override
	public void notifyVideoFrameHasBeenSet() {

	}

	@Override
	public void notifyDisplayFrameHasBeenSet() {
		this.panelViewController.updateImage();
	}

	public NematodePanelViewControllerInterface getPanelViewController() {
		return this.panelViewController;
	}

}
