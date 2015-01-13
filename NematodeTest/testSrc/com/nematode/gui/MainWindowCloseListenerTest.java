package com.nematode.gui;

import java.awt.event.WindowListener;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class MainWindowCloseListenerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(WindowListener.class, MainWindowCloseListener.class);
	}

	@Test
	public void testGetsMainWindowViewController() throws Exception {
		final MockMainWindowViewController mockViewController = new MockMainWindowViewController();
		final MainWindowCloseListener mainWindowCloseListener = new MainWindowCloseListener(
				mockViewController);

		assertSame(mockViewController, mainWindowCloseListener.getViewController());
	}

	@Test
	public void testWindowClosingCallsDisposeOnViewController() throws Exception {
		final MockMainWindowViewController mockViewController = new MockMainWindowViewController();
		final MainWindowCloseListener mainWindowCloseListener = new MainWindowCloseListener(
				mockViewController);

		assertFalse(mockViewController.wasDisposeCalled());

		mainWindowCloseListener.windowClosing(null);

		assertTrue(mockViewController.wasDisposeCalled());
	}
}
