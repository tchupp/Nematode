package com.nematode.gui.main;

import org.junit.Test;

import com.nematode.gui.MockMainWindowViewController;
import com.nematode.unittesting.AssertTestCase;

public class PlayButtonListenerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(MainWindowActionListener.class, PlayButtonListener.class);
	}

	@Test
	public void testGetsMainWindowViewControllerPassedIn() throws Exception {
		final MockMainWindowViewController mockMainWindowViewController = new MockMainWindowViewController();

		final PlayButtonListener playButtonListener = new PlayButtonListener(
				mockMainWindowViewController);

		assertSame(mockMainWindowViewController, playButtonListener.getViewController());
	}

	@Test
	public void testActionPerformedCallsPlayButtonPressedOnViewController() throws Exception {
		final MockMainWindowViewController mockMainWindowViewController = new MockMainWindowViewController();

		final PlayButtonListener playButtonListener = new PlayButtonListener(
				mockMainWindowViewController);

		assertFalse(mockMainWindowViewController.wasPlayButtonPressedCalled());

		playButtonListener.actionPerformed(null);

		assertTrue(mockMainWindowViewController.wasPlayButtonPressedCalled());
	}

}
