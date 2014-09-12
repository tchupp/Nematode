package com.nematode.imaging;

import org.junit.Test;

import com.nematode.nullmodel.NullBufferedImage;
import com.nematode.unittesting.AssertTestCase;

public class ScannedFrameImageTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ScannedFrameImageInterface.class,
				ScannedFrameImage.class);
	}

	@Test
	public void testGetsBufferedImage() throws Exception {
		final NullBufferedImage expectedImage = new NullBufferedImage();
		final ScannedFrameImage scannedFrameImage = new ScannedFrameImage(
				expectedImage);

		assertSame(expectedImage, scannedFrameImage.getImage());
	}

}
