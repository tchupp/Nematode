package com.nematode.model;

public class VideoInfoMatriarch implements VideoInfoMatriarchInterface {

	private final VideoFrameSequenceInterface videoFrameSequence;

	public VideoInfoMatriarch() {
		this.videoFrameSequence = new VideoFrameSequence();
	}

	public VideoFrameSequenceInterface getVideoFrameSequence() {
		return this.videoFrameSequence;
	}
}
