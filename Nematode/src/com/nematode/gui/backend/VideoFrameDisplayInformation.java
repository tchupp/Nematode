package com.nematode.gui.backend;

public class VideoFrameDisplayInformation implements VideoFrameDisplayInformationInterface {

	private final int frameNumber;

	public VideoFrameDisplayInformation(final int frameNumber) {
		this.frameNumber = frameNumber;
	}

	@Override
	public int getFrameNumber() {
		return this.frameNumber;
	}

}
