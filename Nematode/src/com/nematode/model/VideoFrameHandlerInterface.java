package com.nematode.model;

import com.nematode.fileIO.ValidatedImageFileInterface;

public interface VideoFrameHandlerInterface {

	public void buildNewFrameImageFromFile(
			ValidatedImageFileInterface validatedImageFile);

	public void scanImage();

	public VideoFrameInterface getVideoFrame();

	public void updateDisplayImageFromScannedObjects();

}
