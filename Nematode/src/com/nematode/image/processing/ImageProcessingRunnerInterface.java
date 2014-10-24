package com.nematode.image.processing;

import com.nematode.image.BlackAndWhiteImage;
import com.nematode.image.ProcessedFrameImageInterface;
import com.nematode.model.VideoFrameInterface;

public interface ImageProcessingRunnerInterface {

	public ProcessedFrameImageInterface preprocessImageForScanning(
			VideoFrameInterface videoFrame);

	public BlackAndWhiteImage createImageWithIdentifiedObjects(
			VideoFrameInterface videoFrame);

}
