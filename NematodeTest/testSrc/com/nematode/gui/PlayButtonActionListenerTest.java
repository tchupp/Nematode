package com.nematode.gui;

import java.awt.event.ActionListener;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class PlayButtonActionListenerTest extends AssertTestCase {

	@Test
	public void testImplementsActionListener() throws Exception {
		assertImplementsInterface(ActionListener.class, PlayButtonActionListener.class);
	}

	@Test
	public void testGetsToolbarPanelViewControllerPassedIn() throws Exception {
		final MockToolbarPanelViewController viewController = new MockToolbarPanelViewController();
		final PlayButtonActionListener playActionListener = new PlayButtonActionListener(
				viewController);

		assertSame(viewController, playActionListener.getViewController());
	}

	@Test
	public void testActionPerformedCallsPlayButtonPressedOnViewController() throws Exception {
		final MockToolbarPanelViewController viewController = new MockToolbarPanelViewController();
		final PlayButtonActionListener playActionListener = new PlayButtonActionListener(
				viewController);

		assertFalse(viewController.wasPlayButtonPressedCalled());

		playActionListener.actionPerformed(null);

		assertTrue(viewController.wasPlayButtonPressedCalled());
	}
}
