package com.nematode.model;

import java.util.HashMap;

public class VideoFrameSequence implements VideoFrameSequenceInterface {

	private final HashMap<Integer, VideoFrameInterface> videoFrameMap;

	public VideoFrameSequence() {
		this.videoFrameMap = new HashMap<Integer, VideoFrameInterface>();
	}

	@Override
	public void addVideoFrame(final Integer index, final VideoFrameInterface videoFrame) {
		this.videoFrameMap.put(index, videoFrame);
	}

	@Override
	public VideoFrameInterface getVideoFrame(final Integer frameNumber) {
		final VideoFrameInterface videoFrame = this.videoFrameMap.get(frameNumber);
		if (videoFrame != null) {
			return videoFrame;
		}
		return NullVideoFrame.NULL;
	}

	@Override
	public int size() {
		return this.videoFrameMap.size();
	}

	@Override
	public boolean isEmpty() {
		return this.videoFrameMap.isEmpty();
	}

	@Override
	public void clear() {
		this.videoFrameMap.clear();
	}

	public HashMap<Integer, VideoFrameInterface> getVideoFrameMap() {
		return this.videoFrameMap;
	}
}
