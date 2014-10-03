package com.nematode.model;

import java.util.List;

import com.nematode.imaging.DisplayFrameImageInterface;
import com.nematode.imaging.ProcessedFrameImageInterface;
import com.nematode.imaging.VideoFrameImageInterface;

public interface NematodeVideoFrameInterface {

	VideoFrameImageInterface getVideoFrameImage();

	void setVideoFrameImage(VideoFrameImageInterface videoFrameImage);

	DisplayFrameImageInterface getDisplayFrameImage();

	void setDisplayFrameImage(DisplayFrameImageInterface displayFrameImage);

	ProcessedFrameImageInterface getProcessedFrameImage();

	void setProcessedFrameImage(ProcessedFrameImageInterface processedFrameImage);

	void addObserver(
			NematodeVideoFrameObserverInterface nematodeVideoFrameObserver);

	void removeObserver(
			NematodeVideoFrameObserverInterface nematodeVideoFrameObserver);

	List<NematodeVideoFrameObserverInterface> getListOfObservers();

	void dispose();

}
