package com.nematode.nullmodel;

import java.util.ArrayList;
import java.util.List;

import com.nematode.imaging.VideoFrameImageInterface;
import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.model.NematodeVideoFrameObserverInterface;

public class NullNematodeVideoFrame implements NematodeVideoFrameInterface {

	public static NullNematodeVideoFrame NULL = new NullNematodeVideoFrame();

	private NullNematodeVideoFrame() {
	}

	@Override
	public VideoFrameImageInterface getVideoFrameImage() {
		return NullVideoFrameImage.NULL;
	}

	@Override
	public void setVideoFrameImage(
			final VideoFrameImageInterface videoFrameImage) {
	}

	@Override
	public void addObserver(
			final NematodeVideoFrameObserverInterface nematodeVideoFrameObserver) {

	}

	@Override
	public void removeObserver(
			final NematodeVideoFrameObserverInterface nematodeVideoFrameObserver) {

	}

	@Override
	public List<NematodeVideoFrameObserverInterface> getListOfObservers() {
		return new ArrayList<NematodeVideoFrameObserverInterface>();
	}

	@Override
	public void dispose() {
	}

}
