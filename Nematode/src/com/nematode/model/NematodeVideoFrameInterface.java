package com.nematode.model;

import java.util.List;

import com.nematode.imaging.VideoFrameImageInterface;

public interface NematodeVideoFrameInterface {

	VideoFrameImageInterface getVideoFrameImage();

	void setVideoFrameImage(VideoFrameImageInterface videoFrameImage);

	void addObserver(
			NematodeVideoFrameObserverInterface nematodeVideoFrameObserver);

	void removeObserver(
			NematodeVideoFrameObserverInterface nematodeVideoFrameObserver);

	List<NematodeVideoFrameObserverInterface> getListOfObservers();

	void dispose();

}
