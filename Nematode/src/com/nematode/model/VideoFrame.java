package com.nematode.model;

import java.util.ArrayList;
import java.util.List;

import com.nematode.image.VideoFrameImageInterface;

public class VideoFrame implements VideoFrameInterface {

	private final VideoFrameImageInterface videoFrameImage;
	private List<NematodeWormInterface> objectsOnImage;

	public VideoFrame(final VideoFrameImageInterface videoFrameImage) {
		this.videoFrameImage = videoFrameImage;
		this.objectsOnImage = new ArrayList<NematodeWormInterface>();
	}

	@Override
	public VideoFrameImageInterface getVideoFrameImage() {
		return this.videoFrameImage;
	}

	@Override
	public List<NematodeWormInterface> getObjectsOnImage() {
		return this.objectsOnImage;
	}

	@Override
	public void setObjectsOnImage(final List<NematodeWormInterface> objectsOnImage) {
		this.objectsOnImage = objectsOnImage;
	}

}
