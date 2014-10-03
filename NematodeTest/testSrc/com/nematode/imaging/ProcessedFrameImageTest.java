package com.nematode.imaging;

import org.junit.Test;

import com.nematode.nullmodel.NullBufferedImage;
import com.nematode.unittesting.AssertTestCase;

public class ProcessedFrameImageTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ProcessedFrameImageInterface.class,
				ProcessedFrameImage.class);
	}

	@Test
	public void testGetsBufferedImage() throws Exception {
		final NullBufferedImage expectedImage = new NullBufferedImage();
		final ProcessedFrameImage processedFrameImage = new ProcessedFrameImage(
				expectedImage);

		assertSame(expectedImage, processedFrameImage.getImage());
	}

}
