package com.nematode.gui.main;

import java.awt.event.ActionListener;

import org.junit.Test;

import com.nematode.gui.MockMainWindowViewController;
import com.nematode.unittesting.AssertTestCase;

public class PlayVideoTimerListenerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ActionListener.class, PlayVideoTimerListener.class);
	}

	@Test
	public void testGetsMainWindowViewControllerPassedIn() throws Exception {
		final MockMainWindowViewController mockMainWindowViewController = new MockMainWindowViewController();
		final PlayVideoTimerListener playVideoTimerListener = new PlayVideoTimerListener(
				mockMainWindowViewController);

		assertSame(mockMainWindowViewController, playVideoTimerListener.getViewController());
	}

	@Test
	public void testActionPerformedCallsShowNextFrameOnViewController() throws Exception {
		final MockMainWindowViewController mockMainWindowViewController = new MockMainWindowViewController();
		final PlayVideoTimerListener playVideoTimerListener = new PlayVideoTimerListener(
				mockMainWindowViewController);

		assertFalse(mockMainWindowViewController.wasShowNextFrameCalled());
		playVideoTimerListener.actionPerformed(null);
		assertTrue(mockMainWindowViewController.wasShowNextFrameCalled());
	}
}
