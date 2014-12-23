package com.nematode.model;

import org.junit.Test;

import com.nematode.gui.MockVideoPanelViewController;
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
		assertSame(mockVideoPanelViewController, imageChangeObserver.getPanelViewController());
	}
}
