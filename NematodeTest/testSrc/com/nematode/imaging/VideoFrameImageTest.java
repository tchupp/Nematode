package com.nematode.imaging;

import java.awt.image.BufferedImage;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class VideoFrameImageTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoFrameImageInterface.class,
				VideoFrameImage.class);
	}

	@Test
	public void testGetsBufferedImage() throws Exception {
		final BufferedImage bufferedImage = new BufferedImage(10, 10,
				BufferedImage.TYPE_INT_RGB);
		final VideoFrameImage videoFrameImage = new VideoFrameImage(
				bufferedImage);

		assertSame(bufferedImage, videoFrameImage.getBufferedImage());
	}
}
