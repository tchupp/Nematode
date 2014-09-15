package com.nematode.imaging;

import com.nematode.fileIO.ValidatedImageFileInterface;

public interface VideoFrameHandlerInterface {

	public void buildNewFrameImageFromFile(
			ValidatedImageFileInterface validatedImageFile);

	public void scanImage();

}
