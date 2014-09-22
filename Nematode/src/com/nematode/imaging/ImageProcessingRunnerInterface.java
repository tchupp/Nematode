package com.nematode.imaging;

import com.nematode.model.NematodeVideoFrameInterface;

public interface ImageProcessingRunnerInterface {

	public void preprocessImageForScanning();

	public void scanVideoFrame(NematodeVideoFrameInterface videoFrame);

	public ImageProcessingHelperInterface getImageProcessingHelper();

}
