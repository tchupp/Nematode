package com.nematode.model;

import java.util.ArrayList;

import org.junit.Test;

import com.nematode.image.MockVideoFrameImage;
import com.nematode.unittesting.AssertTestCase;

public class VideoFrameTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoFrameInterface.class, VideoFrame.class);
	}

	@Test
	public void testGetsVideoFrameImagePassedIn_NullFrameForDisplayImage() throws Exception {
		final MockVideoFrameImage videoFrameImage = new MockVideoFrameImage();
		final VideoFrame videoFrame = new VideoFrame(videoFrameImage);
		assertSame(videoFrameImage, videoFrame.getVideoFrameImage());
	}

	@Test
	public void testGetsListOfObjects_Construction_AndSet() throws Exception {
		final VideoFrame videoFrame = new VideoFrame(new MockVideoFrameImage());

		assertEquals(0, videoFrame.getObjectsOnImage().size());

		final ArrayList<NematodeWormInterface> objectInImageList = new ArrayList<NematodeWormInterface>();
		videoFrame.setObjectsOnImage(objectInImageList);

		assertSame(objectInImageList, videoFrame.getObjectsOnImage());
	}
}
