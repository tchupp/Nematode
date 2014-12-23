package com.nematode.model;

import java.util.List;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.junit.Test;

import com.nematode.image.NullBufferedImage;
import com.nematode.unittesting.AssertTestCase;

public class VideoMatriarchTest extends AssertTestCase {

	@Override
	protected void setUp() throws Exception {
		Loader.load(org.bytedeco.javacpp.opencv_core.class);
	}

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoMatriarchInterface.class, VideoMatriarch.class);
	}

	@Test
	public void testGetVideoReturnsCorrectVideo() throws Exception {
		final VideoMatriarch videoMatriarch = new VideoMatriarch();

		final VideoInterface initialVideo = videoMatriarch.getVideo();
		assertIsOfTypeAndGet(NullVideo.class, initialVideo);

		final MockVideo mockVideo = new MockVideo();
		videoMatriarch.setVideo(mockVideo);

		assertSame(mockVideo, videoMatriarch.getVideo());
	}

	@Test
	public void testAddObserverCorrectlyUpdatesListOfObservers() throws Exception {
		final VideoMatriarch videoMatriarch = new VideoMatriarch();

		final List<VideoObserverInterface> observerList = videoMatriarch.getObserverList();
		assertEquals(0, observerList.size());

		final MockVideoObserver mockVideoObserverOne = new MockVideoObserver();
		videoMatriarch.addObserver(mockVideoObserverOne);

		assertEquals(1, observerList.size());
		assertSame(mockVideoObserverOne, observerList.get(0));
	}

	@Test
	public void testRemoveObserverRemovesTheCorrectObserver() throws Exception {
		final VideoMatriarch videoMatriarch = new VideoMatriarch();

		final List<VideoObserverInterface> observerList = videoMatriarch.getObserverList();

		final MockVideoObserver mockVideoObserverOne = new MockVideoObserver();
		final MockVideoObserver mockVideoObserverTwo = new MockVideoObserver();

		videoMatriarch.addObserver(mockVideoObserverOne);
		videoMatriarch.addObserver(mockVideoObserverTwo);

		assertEquals(2, observerList.size());

		videoMatriarch.removeObserver(mockVideoObserverOne);

		assertEquals(1, observerList.size());
		assertFalse(observerList.contains(mockVideoObserverOne));
		assertTrue(observerList.contains(mockVideoObserverTwo));
	}

	@Test
	public void testSetVideoNotifiesObserversThatTheVideoHasBeenSet_PassesObserversThumbnail()
			throws Exception {
		final VideoMatriarch videoMatriarch = new VideoMatriarch();
		final MockVideoObserver observer = new MockVideoObserver();
		videoMatriarch.addObserver(observer);

		final MockVideo video = new MockVideo();
		final Mat expectedThumbnail = Mat.createFrom(new NullBufferedImage());
		video.setThumbnailToReturn(expectedThumbnail);

		assertFalse(observer.wasNotifyVideoHasBeenSetCalled());

		videoMatriarch.setVideo(video);

		assertTrue(observer.wasNotifyVideoHasBeenSetCalled());
		assertTrue(video.wasGetThumbnailCalled());
		assertSame(expectedThumbnail, observer.getThumbnailPassedIn());
	}
}
