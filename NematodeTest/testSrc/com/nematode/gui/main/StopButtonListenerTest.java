package com.nematode.gui.main;

import org.junit.Test;

import com.nematode.gui.MockMainWindowViewController;
import com.nematode.unittesting.AssertTestCase;

public class StopButtonListenerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(MainWindowActionListener.class, StopButtonListener.class);
	}

	@Test
	public void testGetsMainWindowControllerPassedIn() throws Exception {
		final MockMainWindowViewController mockMainWindowViewController = new MockMainWindowViewController();
		final StopButtonListener stopButtonListener = new StopButtonListener(
				mockMainWindowViewController);

		assertSame(mockMainWindowViewController, stopButtonListener.getViewController());
	}

	@Test
	public void testActionPerformedCallsStopButtonPressedOnMainWindowController() throws Exception {
		final MockMainWindowViewController mockMainWindowViewController = new MockMainWindowViewController();
		final StopButtonListener stopButtonListener = new StopButtonListener(
				mockMainWindowViewController);

		assertFalse(mockMainWindowViewController.wasStopButtonPressedCalled());
		stopButtonListener.actionPerformed(null);
		assertTrue(mockMainWindowViewController.wasStopButtonPressedCalled());
	}
}
