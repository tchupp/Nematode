package com.nematode.model;

import java.util.HashMap;

public class VideoInfoMatriarch implements VideoInfoMatriarchInterface {

	private final VideoFrameSequenceInterface videoFrameSequence;
	private final HashMap<VideoFrameInterface, VideoFrameInfoInterface> videoFrameInfoMap;

	public VideoInfoMatriarch() {
		this.videoFrameSequence = new VideoFrameSequence();
		this.videoFrameInfoMap = new HashMap<VideoFrameInterface, VideoFrameInfoInterface>();
	}

	public VideoFrameSequenceInterface getVideoFrameSequence() {
		return this.videoFrameSequence;
	}

	public HashMap<VideoFrameInterface, VideoFrameInfoInterface> getVideoFrameInfoMap() {
		return this.videoFrameInfoMap;
	}
}
