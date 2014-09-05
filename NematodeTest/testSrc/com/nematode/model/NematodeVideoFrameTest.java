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

	@Test
	public void testAddObservers() throws Exception {
		final MockVideoFrameObserver mockVideoFrameObserver1 = new MockVideoFrameObserver();
		final MockVideoFrameObserver mockVideoFrameObserver2 = new MockVideoFrameObserver();

		final NematodeVideoFrame nematodeVideoFrame = new NematodeVideoFrame(
				new MockVideoFrameImage());
		assertEquals(0, nematodeVideoFrame.getListOfObservers().size());
		nematodeVideoFrame.addObserver(mockVideoFrameObserver1);
		nematodeVideoFrame.addObserver(mockVideoFrameObserver2);
		assertEquals(2, nematodeVideoFrame.getListOfObservers().size());

	}

	@Test
	public void testRemoveObservers() throws Exception {
		final MockVideoFrameObserver mockVideoFrameObserver1 = new MockVideoFrameObserver();
		final MockVideoFrameObserver mockVideoFrameObserver2 = new MockVideoFrameObserver();

		final NematodeVideoFrame nematodeVideoFrame = new NematodeVideoFrame(
				new MockVideoFrameImage());
		nematodeVideoFrame.addObserver(mockVideoFrameObserver1);
		nematodeVideoFrame.addObserver(mockVideoFrameObserver2);
		assertEquals(2, nematodeVideoFrame.getListOfObservers().size());
		nematodeVideoFrame.removeObserver(mockVideoFrameObserver1);
		nematodeVideoFrame.removeObserver(mockVideoFrameObserver2);
		assertEquals(0, nematodeVideoFrame.getListOfObservers().size());
	}

	@Test
	public void testDisposeRemovesAllObservers() throws Exception {
		final MockVideoFrameObserver mockVideoFrameObserver1 = new MockVideoFrameObserver();
		final MockVideoFrameObserver mockVideoFrameObserver2 = new MockVideoFrameObserver();

		final NematodeVideoFrame nematodeVideoFrame = new NematodeVideoFrame(
				new MockVideoFrameImage());

		nematodeVideoFrame.addObserver(mockVideoFrameObserver1);
		nematodeVideoFrame.addObserver(mockVideoFrameObserver2);
		assertEquals(2, nematodeVideoFrame.getListOfObservers().size());
		nematodeVideoFrame.dispose();
		assertEquals(0, nematodeVideoFrame.getListOfObservers().size());
	}

	@Test
	public void testObserverIsNotifiedWhenImageIsSet() throws Exception {
		final MockVideoFrameObserver mockVideoFrameObserver = new MockVideoFrameObserver();

		final NematodeVideoFrame nematodeVideoFrame = new NematodeVideoFrame(
				new MockVideoFrameImage());
		nematodeVideoFrame.addObserver(mockVideoFrameObserver);
		assertFalse(mockVideoFrameObserver.wasNotifyFrameHasBeenSetCalled());
		nematodeVideoFrame.setVideoFrameImage(new MockVideoFrameImage());
		assertTrue(mockVideoFrameObserver.wasNotifyFrameHasBeenSetCalled());

	}
}
