package com.nematode.model;

import java.util.List;

import com.nematode.imaging.DisplayFrameImageInterface;
import com.nematode.imaging.VideoFrameImageInterface;

public interface NematodeVideoFrameInterface {

	public VideoFrameImageInterface getVideoFrameImage();

	public void setVideoFrameImage(VideoFrameImageInterface videoFrameImage);

	public DisplayFrameImageInterface getDisplayFrameImage();

	public void setDisplayFrameImage(
			DisplayFrameImageInterface displayFrameImage);

	public void addObserver(
			NematodeVideoFrameObserverInterface nematodeVideoFrameObserver);

	public void removeObserver(
			NematodeVideoFrameObserverInterface nematodeVideoFrameObserver);

	public List<NematodeVideoFrameObserverInterface> getListOfObservers();

	public void dispose();

	public List<NematodeWormInterface> getObjectsOnImage();

	public void setObjectsOnImage(List<NematodeWormInterface> objectsOnImage);

}
