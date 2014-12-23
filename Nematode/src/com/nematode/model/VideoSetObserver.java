package com.nematode.model;

import org.bytedeco.javacpp.opencv_core.Mat;

import com.nematode.gui.VideoPanelViewControllerInterface;

public class VideoSetObserver implements VideoObserverInterface {

	private final VideoPanelViewControllerInterface videoPanelViewController;

	public VideoSetObserver(final VideoPanelViewControllerInterface videoPanelViewController) {
		this.videoPanelViewController = videoPanelViewController;
	}

	@Override
	public void notifyVideoHasBeenSet(final Mat thumbnail) {
	}

	public VideoPanelViewControllerInterface getPanelViewController() {
		return this.videoPanelViewController;
	}

}
