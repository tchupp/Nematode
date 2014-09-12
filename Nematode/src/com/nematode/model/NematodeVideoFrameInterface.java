package com.nematode.model;

import java.util.List;

import com.nematode.imaging.DisplayFrameImageInterface;
import com.nematode.imaging.ScannedFrameImageInterface;
import com.nematode.imaging.VideoFrameImageInterface;

public interface NematodeVideoFrameInterface {

	VideoFrameImageInterface getVideoFrameImage();

	void setVideoFrameImage(VideoFrameImageInterface videoFrameImage);

	DisplayFrameImageInterface getDisplayFrameImage();

	void setDisplayFrameImage(DisplayFrameImageInterface displayFrameImage);

	ScannedFrameImageInterface getScannedFrameImage();

	void setScannedFrameImage(ScannedFrameImageInterface scannedFrameImage);

	void addObserver(
			NematodeVideoFrameObserverInterface nematodeVideoFrameObserver);

	void removeObserver(
			NematodeVideoFrameObserverInterface nematodeVideoFrameObserver);

	List<NematodeVideoFrameObserverInterface> getListOfObservers();

	void dispose();

}
