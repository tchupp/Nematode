package com.nematode.gui;

import com.nematode.imaging.VideoFrameHandlerInterface;

public class MockPanelViewController implements
		NematodePanelViewControllerInterface {

	private boolean updateImageWasCalled = false;
	private VideoFrameHandlerInterface videoFrameHandler;

	@Override
	public NematodePanel getNematodePanel() {
		return new NematodePanel();
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
