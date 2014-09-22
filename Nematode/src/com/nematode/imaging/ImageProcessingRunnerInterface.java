package com.nematode.imaging;

import com.nematode.model.NematodeVideoFrameInterface;

public interface ImageProcessingRunnerInterface {

	public void preprocessImageForScanning(NematodeVideoFrameInterface videoFrame);

	public void scanVideoFrame(NematodeVideoFrameInterface videoFrame);

	public ImageProcessingHelperInterface getImageProcessingHelper();

}
