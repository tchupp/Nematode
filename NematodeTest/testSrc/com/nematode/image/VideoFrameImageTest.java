package com.nematode.image;

import java.awt.image.BufferedImage;

import org.junit.Test;

import com.nematode.image.VideoFrameImage;
import com.nematode.image.VideoFrameImageInterface;
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

		assertSame(bufferedImage, videoFrameImage.getImage());
	}
}
