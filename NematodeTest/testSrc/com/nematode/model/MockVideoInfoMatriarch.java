package com.nematode.model;

import com.nematode.fileIO.VideoFrameAssemblerInterface;

public class MockVideoInfoMatriarch implements VideoInfoMatriarchInterface {

	private VideoFrameAssemblerInterface videoFrameAssembler;

	@Override
	public VideoFrameAssemblerInterface getVideoFrameAssembler() {
		return this.videoFrameAssembler;
	}

	public void setVideoFrameSequence(final VideoFrameAssemblerInterface videoFrameAssembler) {
		this.videoFrameAssembler = videoFrameAssembler;
	}

}
