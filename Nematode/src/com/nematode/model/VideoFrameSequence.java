package com.nematode.model;

import java.util.List;

public class VideoFrameSequence implements VideoFrameSequenceInterface {

	private final List<VideoFrameInterface> videoFrameList;

	public VideoFrameSequence(final List<VideoFrameInterface> videoFrameList) {
		this.videoFrameList = videoFrameList;
	}

	@Override
	public VideoFrameInterface getFrame(final int frameNumber) {
		try {
			return this.videoFrameList.get(frameNumber);
		} catch (final IndexOutOfBoundsException exception) {
			return NullVideoFrame.NULL;
		}
	}

	@Override
	public int getSize() {
		return this.videoFrameList.size();
	}

	public List<VideoFrameInterface> getVideoFrameList() {
		return this.videoFrameList;
	}
}
