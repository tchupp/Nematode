package com.nematode.nullmodel;

import java.util.ArrayList;
import java.util.List;

import com.nematode.imaging.DisplayFrameImageInterface;
import com.nematode.imaging.ProcessedFrameImageInterface;
import com.nematode.imaging.VideoFrameImageInterface;
import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.model.NematodeVideoFrameObserverInterface;

public class NullNematodeVideoFrame implements NematodeVideoFrameInterface {

	public static NullNematodeVideoFrame NULL = new NullNematodeVideoFrame();

	private NullNematodeVideoFrame() {
	}

	@Override
	public VideoFrameImageInterface getVideoFrameImage() {
		return NullFrameImage.NULL;
	}

	@Override
	public void setVideoFrameImage(
			final VideoFrameImageInterface videoFrameImage) {
	}

	@Override
	public DisplayFrameImageInterface getDisplayFrameImage() {
		return NullFrameImage.NULL;
	}

	@Override
	public void setDisplayFrameImage(
			final DisplayFrameImageInterface displayFrameImage) {

	}

	@Override
	public ProcessedFrameImageInterface getProcessedFrameImage() {
		return NullFrameImage.NULL;
	}

	@Override
	public void setProcessedFrameImage(
			final ProcessedFrameImageInterface processedFrameImage) {
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
