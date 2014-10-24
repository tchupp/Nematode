package com.nematode.gui;

import com.nematode.model.VideoFrameHandlerInterface;

public class MockPanelViewController implements
		NematodePanelViewControllerInterface {

	private boolean updateImageWasCalled = false;
	private VideoFrameHandlerInterface videoFrameHandler;

	@Override
	public ExtendableJPanel getNematodePanel() {
		return new ExtendableJPanel();
	}

	@Override
	public void updateImage() {
		this.updateImageWasCalled = true;
	}

	public boolean wasUpdateImageCalled() {
		return this.updateImageWasCalled;
	}

	@Override
	public VideoFrameHandlerInterface getVideoFrameHandler() {
		return this.videoFrameHandler;
	}

	public void setVideoFrameHandler(
			final VideoFrameHandlerInterface videoFrameHandler) {
		this.videoFrameHandler = videoFrameHandler;
	}

}
