package com.nematode.imaging;

import com.nematode.fileIO.ValidatedImageFileInterface;

public interface VideoFrameBuilderInterface {

	void buildNewFrameImageFromFile(ValidatedImageFileInterface validatedImageFile);

}
