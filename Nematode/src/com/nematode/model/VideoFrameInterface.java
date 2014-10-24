package com.nematode.model;

import java.util.List;

import com.nematode.image.DisplayFrameImageInterface;
import com.nematode.image.VideoFrameImageInterface;

public interface VideoFrameInterface {

	public VideoFrameImageInterface getVideoFrameImage();

	public void setVideoFrameImage(VideoFrameImageInterface videoFrameImage);

	public DisplayFrameImageInterface getDisplayFrameImage();

	public void setDisplayFrameImage(DisplayFrameImageInterface displayFrameImage);

	public void addObserver(VideoFrameObserverInterface videoFrameObserver);

	public void removeObserver(VideoFrameObserverInterface videoFrameObserver);

	public List<VideoFrameObserverInterface> getListOfObservers();

	public void dispose();

	public List<NematodeWormInterface> getObjectsOnImage();

	public void setObjectsOnImage(List<NematodeWormInterface> objectsOnImage);

}
