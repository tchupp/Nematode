package com.nematode.model;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.junit.Test;

import com.nematode.gui.MockVideoPanelViewController;
import com.nematode.image.NullBufferedImage;
import com.nematode.unittesting.AssertTestCase;

public class VideoSetObserverTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoObserverInterface.class, VideoSetObserver.class);
	}

	@Test
	public void testGetViewController() throws Exception {
		final MockVideoPanelViewController mockVideoPanelViewController = new MockVideoPanelViewController();
		final VideoSetObserver imageChangeObserver = new VideoSetObserver(
				mockVideoPanelViewController);
		assertSame(mockVideoPanelViewController, imageChangeObserver.getVideoPanelViewController());
	}

	@Test
	public void testNotifyVideoHasBeenSetCallsShowImageOnViewControllerWithCorrectMat()
			throws Exception {
		final MockVideoPanelViewController videoPanelViewController = new MockVideoPanelViewController();
		final VideoSetObserver videoSetObserver = new VideoSetObserver(videoPanelViewController);
		final Mat expectedMat = Mat.createFrom(new NullBufferedImage());

		assertFalse(videoPanelViewController.wasShowImageCalled());

		videoSetObserver.notifyVideoHasBeenSet(expectedMat);

		assertTrue(videoPanelViewController.wasShowImageCalled());
		assertSame(expectedMat, videoPanelViewController.getDisplayImagePassedIn());
	}
}
