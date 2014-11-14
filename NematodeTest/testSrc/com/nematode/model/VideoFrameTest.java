package com.nematode.model;

import org.junit.Test;

import com.nematode.image.MockDisplayFrameImage;
import com.nematode.image.MockVideoFrameImage;
import com.nematode.image.NullFrameImage;
import com.nematode.unittesting.AssertTestCase;

public class VideoFrameTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoFrameInterface.class, VideoFrame.class);
	}

	@Test
	public void testGetsNullFrameImageAtConstruction() throws Exception {
		final VideoFrame videoFrame = new VideoFrame();

		assertIsOfTypeAndGet(NullFrameImage.class, videoFrame.getVideoFrameImage());
		assertIsOfTypeAndGet(NullFrameImage.class, videoFrame.getDisplayFrameImage());
	}

	@Test
	public void testGetsVideoFrameImagePassedIn_NullFrameForDisplayImage() throws Exception {
		final MockVideoFrameImage videoFrameImage = new MockVideoFrameImage();
		final VideoFrame videoFrame = new VideoFrame(videoFrameImage);
		assertSame(videoFrameImage, videoFrame.getVideoFrameImage());
	}

	@Test
	public void testGetsVideoFrameImageSet() throws Exception {
		final MockVideoFrameImage mockVideoFrameImage = new MockVideoFrameImage();
		final VideoFrame videoFrame = new VideoFrame();

		assertSame(NullFrameImage.NULL, videoFrame.getVideoFrameImage());

		videoFrame.setVideoFrameImage(mockVideoFrameImage);

		assertSame(mockVideoFrameImage, videoFrame.getVideoFrameImage());
	}

	@Test
	public void testGetsDisplayFrameImageSet() throws Exception {
		final MockDisplayFrameImage mockDisplayFrameImage = new MockDisplayFrameImage();

		final VideoFrame videoFrame = new VideoFrame();

		assertSame(NullFrameImage.NULL, videoFrame.getDisplayFrameImage());

		videoFrame.setDisplayFrameImage(mockDisplayFrameImage);

		assertSame(mockDisplayFrameImage, videoFrame.getDisplayFrameImage());
	}

	@Test
	public void testAddObservers() throws Exception {
		final MockVideoFrameObserver mockVideoFrameObserver1 = new MockVideoFrameObserver();
		final MockVideoFrameObserver mockVideoFrameObserver2 = new MockVideoFrameObserver();

		final VideoFrame videoFrame = new VideoFrame();
		assertEquals(0, videoFrame.getListOfObservers().size());
		videoFrame.addObserver(mockVideoFrameObserver1);
		videoFrame.addObserver(mockVideoFrameObserver2);
		assertEquals(2, videoFrame.getListOfObservers().size());

	}

	@Test
	public void testRemoveObservers() throws Exception {
		final MockVideoFrameObserver mockVideoFrameObserver1 = new MockVideoFrameObserver();
		final MockVideoFrameObserver mockVideoFrameObserver2 = new MockVideoFrameObserver();

		final VideoFrame videoFrame = new VideoFrame();
		videoFrame.addObserver(mockVideoFrameObserver1);
		videoFrame.addObserver(mockVideoFrameObserver2);
		assertEquals(2, videoFrame.getListOfObservers().size());
		videoFrame.removeObserver(mockVideoFrameObserver1);
		videoFrame.removeObserver(mockVideoFrameObserver2);
		assertEquals(0, videoFrame.getListOfObservers().size());
	}

	@Test
	public void testDisposeRemovesAllObservers() throws Exception {
		final MockVideoFrameObserver mockVideoFrameObserver1 = new MockVideoFrameObserver();
		final MockVideoFrameObserver mockVideoFrameObserver2 = new MockVideoFrameObserver();

		final VideoFrame videoFrame = new VideoFrame();

		videoFrame.addObserver(mockVideoFrameObserver1);
		videoFrame.addObserver(mockVideoFrameObserver2);
		assertEquals(2, videoFrame.getListOfObservers().size());
		videoFrame.dispose();
		assertEquals(0, videoFrame.getListOfObservers().size());
	}

	@Test
	public void testObserverIsNotifiedWhenImageIsSet() throws Exception {
		final MockVideoFrameObserver mockVideoFrameObserver = new MockVideoFrameObserver();

		final VideoFrame videoFrame = new VideoFrame();
		videoFrame.addObserver(mockVideoFrameObserver);
		assertFalse(mockVideoFrameObserver.wasNotifyDisplayFrameHasBeenSetCalled());
		videoFrame.setDisplayFrameImage(new MockDisplayFrameImage());
		assertTrue(mockVideoFrameObserver.wasNotifyDisplayFrameHasBeenSetCalled());

	}
}
