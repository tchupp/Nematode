package com.nematode.model;

import java.util.ArrayList;
import java.util.List;

import com.nematode.image.DisplayFrameImageInterface;
import com.nematode.image.NullFrameImage;
import com.nematode.image.VideoFrameImageInterface;

public class VideoFrame implements VideoFrameInterface {

	private VideoFrameImageInterface videoFrameImage;
	private DisplayFrameImageInterface displayFrameImage;
	private List<NematodeWormInterface> objectsOnImage;
	private final List<VideoFrameObserverInterface> videoFrameObservers;

	public VideoFrame() {
		this(NullFrameImage.NULL);
	}

	public VideoFrame(final VideoFrameImageInterface videoFrameImage) {
		this.videoFrameImage = videoFrameImage;
		this.displayFrameImage = NullFrameImage.NULL;
		this.objectsOnImage = new ArrayList<NematodeWormInterface>();
		this.videoFrameObservers = new ArrayList<VideoFrameObserverInterface>();
	}

	@Override
	public void dispose() {
		this.videoFrameObservers.clear();
	}

	@Override
	public VideoFrameImageInterface getVideoFrameImage() {
		return this.videoFrameImage;
	}

	@Override
	public void setVideoFrameImage(final VideoFrameImageInterface videoFrameImage) {
		this.videoFrameImage = videoFrameImage;
	}

	@Override
	public DisplayFrameImageInterface getDisplayFrameImage() {
		return this.displayFrameImage;
	}

	@Override
	public void setDisplayFrameImage(final DisplayFrameImageInterface displayFrameImage) {
		this.displayFrameImage = displayFrameImage;
		notifyDisplayFrameHasBeenSet();
	}

	@Override
	public List<NematodeWormInterface> getObjectsOnImage() {
		return this.objectsOnImage;
	}

	@Override
	public void setObjectsOnImage(final List<NematodeWormInterface> objectsOnImage) {
		this.objectsOnImage = objectsOnImage;
	}

	@Override
	public void addObserver(final VideoFrameObserverInterface videoFrameObserver) {
		this.videoFrameObservers.add(videoFrameObserver);
	}

	@Override
	public void removeObserver(final VideoFrameObserverInterface videoFrameObserver) {
		this.videoFrameObservers.remove(videoFrameObserver);
	}

	@Override
	public List<VideoFrameObserverInterface> getListOfObservers() {
		return this.videoFrameObservers;
	}

	private void notifyDisplayFrameHasBeenSet() {
		for (final VideoFrameObserverInterface observer : this.videoFrameObservers) {
			observer.notifyDisplayFrameHasBeenSet();
		}
	}

}
