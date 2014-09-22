package com.nematode.imaging;

import com.nematode.fileIO.ValidatedImageFileInterface;
import com.nematode.model.NematodeVideoFrameInterface;

public interface VideoFrameHandlerInterface {

	public void buildNewFrameImageFromFile(
			ValidatedImageFileInterface validatedImageFile);

	public void scanImage();

	public NematodeVideoFrameInterface getNematodeVideoFrame();

	public void updateDisplayImageFromScannedImage();

}
