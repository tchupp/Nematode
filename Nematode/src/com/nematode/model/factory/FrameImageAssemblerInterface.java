package com.nematode.model.factory;

import java.awt.image.BufferedImage;

import com.nematode.image.DisplayFrameImageInterface;
import com.nematode.image.VideoFrameImageInterface;

public interface FrameImageAssemblerInterface {

	public DisplayFrameImageInterface createDisplayFrameImage(
			BufferedImage image);

	public VideoFrameImageInterface createVideoFrameImage(BufferedImage image);

}
