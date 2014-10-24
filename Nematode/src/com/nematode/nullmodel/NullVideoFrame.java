package com.nematode.nullmodel;

import java.util.ArrayList;
import java.util.List;

import com.nematode.image.DisplayFrameImageInterface;
import com.nematode.image.VideoFrameImageInterface;
import com.nematode.model.NematodeWormInterface;
import com.nematode.model.VideoFrameInterface;
import com.nematode.model.VideoFrameObserverInterface;

public class NullVideoFrame implements VideoFrameInterface {

	public static NullVideoFrame NULL = new NullVideoFrame();

	private NullVideoFrame() {
	}

	@Override
	public VideoFrameImageInterface getVideoFrameImage() {
		return NullFrameImage.NULL;
	}

	@Override
	public void setVideoFrameImage(final VideoFrameImageInterface videoFrameImage) {
	}

	@Override
	public DisplayFrameImageInterface getDisplayFrameImage() {
		return NullFrameImage.NULL;
	}

	@Override
	public void setDisplayFrameImage(final DisplayFrameImageInterface displayFrameImage) {

	}

	@Override
	public void addObserver(final VideoFrameObserverInterface videoFrameObserver) {

	}

	@Override
	public void removeObserver(final VideoFrameObserverInterface videoFrameObserver) {

	}

	@Override
	public List<VideoFrameObserverInterface> getListOfObservers() {
		return new ArrayList<VideoFrameObserverInterface>();
	}

	@Override
	public void dispose() {
	}

	@Override
	public List<NematodeWormInterface> getObjectsOnImage() {
		return new ArrayList<NematodeWormInterface>();
	}

	@Override
	public void setObjectsOnImage(final List<NematodeWormInterface> objectsOnImage) {

	}

}
