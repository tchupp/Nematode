package com.nematode.imaging;

import com.nematode.model.NematodeVideoFrameInterface;

public interface ImageProcessingRunnerInterface {

	public ProcessedFrameImageInterface preprocessImageForScanning(
			NematodeVideoFrameInterface videoFrame);

	public BlackAndWhiteImage createImageWithIdentifiedObjects(
			NematodeVideoFrameInterface videoFrame);

}
