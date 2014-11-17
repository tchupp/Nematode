package com.nematode.model;

import java.util.ArrayList;
import java.util.List;

import com.nematode.image.NullFrameImage;
import com.nematode.image.VideoFrameImageInterface;

public class NullVideoFrame implements VideoFrameInterface {

	public static NullVideoFrame NULL = new NullVideoFrame();

	private NullVideoFrame() {
	}

	@Override
	public VideoFrameImageInterface getVideoFrameImage() {
		return NullFrameImage.NULL;
	}

	@Override
	public List<NematodeWormInterface> getObjectsOnImage() {
		return new ArrayList<NematodeWormInterface>();
	}

	@Override
	public void setObjectsOnImage(final List<NematodeWormInterface> objectsOnImage) {

	}

}
