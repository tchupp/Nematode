package com.nematode.model;

public interface VideoFrameSequenceInterface {

	public VideoFrameInterface getVideoFrame(Integer frameNumber);

	public int size();

	public void addVideoFrame(Integer index, VideoFrameInterface videoFrame);

	public boolean isEmpty();

	public void clear();

}
