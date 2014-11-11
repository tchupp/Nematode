package com.nematode.gui.backend;

public class VideoFrameDisplayInfo implements VideoFrameDisplayInfoInterface {

	private final int frameNumber;

	public VideoFrameDisplayInfo(final int frameNumber) {
		this.frameNumber = frameNumber;
	}

	@Override
	public int getFrameNumber() {
		return this.frameNumber;
	}

}
