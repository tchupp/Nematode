package com.nematode.image;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NullFrameImageTest extends AssertTestCase {

	@Test
	public void testImplementsInterfaces() throws Exception {
		assertImplementsInterfaces(NullFrameImage.class, DisplayFrameImageInterface.class,
				VideoFrameImageInterface.class, ProcessedFrameImageInterface.class);
	}

	@Test
	public void testNoPublicConstructors() throws Exception {
		assertConstructorIsPrivate(NullFrameImage.class);
	}

	@Test
	public void testGetsNullBufferedImage() throws Exception {
		final VideoFrameImageInterface nullVideoFrameImage = NullFrameImage.NULL;

		assertIsOfTypeAndGet(NullBufferedImage.class, nullVideoFrameImage.getImage());
	}

	@Test
	public void testNULLReturnsCorrectImplementationOfInterface() throws Exception {
		final VideoFrameImageInterface nullVideoFrameImage = NullFrameImage.NULL;
		final DisplayFrameImageInterface nullDisplayFrameImage = NullFrameImage.NULL;
		assertSame(nullVideoFrameImage, nullDisplayFrameImage);
	}
}
