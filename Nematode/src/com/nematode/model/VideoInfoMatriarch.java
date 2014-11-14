package com.nematode.model;

import java.util.HashMap;
import java.util.Map;

import com.nematode.fileIO.VideoFrameAssembler;
import com.nematode.fileIO.VideoFrameAssemblerInterface;
import com.nematode.model.factory.FrameImageAssembler;

public class VideoInfoMatriarch implements VideoInfoMatriarchInterface {

	private final VideoFrameSequenceInterface videoFrameSequence;
	private final Map<VideoFrameInterface, VideoFrameInfoInterface> videoFrameInfoMap;
	private final VideoFrameAssembler videoFrameAssembler;

	public VideoInfoMatriarch() {
		this.videoFrameSequence = new VideoFrameSequence();
		this.videoFrameInfoMap = new HashMap<VideoFrameInterface, VideoFrameInfoInterface>();
		this.videoFrameAssembler = new VideoFrameAssembler(this.videoFrameSequence,
				new FrameImageAssembler());
	}

	public VideoFrameSequenceInterface getVideoFrameSequence() {
		return this.videoFrameSequence;
	}

	public Map<VideoFrameInterface, VideoFrameInfoInterface> getVideoFrameInfoMap() {
		return this.videoFrameInfoMap;
	}

	@Override
	public VideoFrameAssemblerInterface getVideoFrameAssembler() {
		return this.videoFrameAssembler;
	}
}
