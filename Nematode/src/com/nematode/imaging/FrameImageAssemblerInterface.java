package com.nematode.imaging;

import java.awt.image.BufferedImage;

public interface FrameImageAssemblerInterface {

	public DisplayFrameImageInterface createDisplayFrameImage(
			BufferedImage image);

	public VideoFrameImageInterface createVideoFrameImage(BufferedImage image);

}
