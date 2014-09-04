package com.nematode.model;

import org.junit.Test;

import com.nematode.imaging.MockVideoFrameImage;
import com.nematode.nullmodel.NullVideoFrameImage;
import com.nematode.unittesting.AssertTestCase;

public class NematodeVideoFrameTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodeVideoFrameInterface.class,
				NematodeVideoFrame.class);
	}

	@Test
	public void testGetsVideoFrameImagePassedIn() throws Exception {
		final MockVideoFrameImage mockVideoFrameImage = new MockVideoFrameImage();
		final NematodeVideoFrame nematodeVideoFrame = new NematodeVideoFrame(
				mockVideoFrameImage);

		assertSame(mockVideoFrameImage, nematodeVideoFrame.getVideoFrameImage());
	}

	@Test
	public void testGetsVideoFrameImageSet() throws Exception {
		final MockVideoFrameImage mockVideoFrameImage = new MockVideoFrameImage();
		final NematodeVideoFrame nematodeVideoFrame = new NematodeVideoFrame(
				NullVideoFrameImage.NULL);

		assertSame(NullVideoFrameImage.NULL,
				nematodeVideoFrame.getVideoFrameImage());

		nematodeVideoFrame.setVideoFrameImage(mockVideoFrameImage);

		assertSame(mockVideoFrameImage, nematodeVideoFrame.getVideoFrameImage());
	}
}
