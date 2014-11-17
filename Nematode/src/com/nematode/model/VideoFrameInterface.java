package com.nematode.model;

import java.util.List;

import com.nematode.image.VideoFrameImageInterface;

public interface VideoFrameInterface {

	public VideoFrameImageInterface getVideoFrameImage();

	public List<NematodeWormInterface> getObjectsOnImage();

	public void setObjectsOnImage(List<NematodeWormInterface> objectsOnImage);

}
