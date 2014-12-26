package com.nematode.gui;

import org.bytedeco.javacpp.opencv_core.Mat;

public class MockVideoPanelViewController implements VideoPanelViewControllerInterface {

	private Mat displayImagePassedIn;
	private boolean showImageWasCalled = false;

	@Override
	public ExtendableJPanel getVideoPanel() {
		return new ExtendableJPanel();
	}

	@Override
	public void showImage(final Mat displayImage) {
		this.showImageWasCalled = true;
		this.displayImagePassedIn = displayImage;
	}

	public boolean wasShowImageCalled() {
		return this.showImageWasCalled;
	}

	public Mat getDisplayImagePassedIn() {
		return this.displayImagePassedIn;
	}

}
