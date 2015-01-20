package com.nematode.gui.main;

import org.junit.Test;

import com.nematode.gui.MockMainWindowViewController;
import com.nematode.unittesting.AssertTestCase;

public class PauseButtonListenerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(MainWindowActionListener.class, PauseButtonListener.class);
	}

	@Test
	public void testGetsMainWindowViewControllerPassedIn() throws Exception {
		final MockMainWindowViewController mockMainWindowViewController = new MockMainWindowViewController();

		final PauseButtonListener pauseButtonListener = new PauseButtonListener(
				mockMainWindowViewController);

		assertSame(mockMainWindowViewController, pauseButtonListener.getViewController());
	}

	@Test
	public void testActionPerformedCallsPauseButtonPressedOnViewController() throws Exception {
		final MockMainWindowViewController mockMainWindowViewController = new MockMainWindowViewController();

		final PauseButtonListener pauseButtonListener = new PauseButtonListener(
				mockMainWindowViewController);

		assertFalse(mockMainWindowViewController.wasPauseButtonPressedCalled());

		pauseButtonListener.actionPerformed(null);

		assertTrue(mockMainWindowViewController.wasPauseButtonPressedCalled());
	}

}
