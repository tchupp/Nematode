package com.nematode.gui;

import java.awt.event.WindowListener;

import org.bytedeco.javacpp.Loader;
import org.junit.Test;

import com.nematode.model.MockVideoMatriarch;
import com.nematode.unittesting.AssertTestCase;

public class MainWindowViewControllerTest extends AssertTestCase {

	@Override
	protected void setUp() throws Exception {
		Loader.load(org.bytedeco.javacpp.opencv_core.class);
	}

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(MainWindowControllerInterface.class,
				MainWindowViewController.class);
	}

	@Test
	public void testGetsMainWindowPassedIn() throws Exception {
		final MockExtendableFrame mockExtendableFrame = new MockExtendableFrame();
		final MainWindowViewController mainWindowViewController = new MainWindowViewController(
				mockExtendableFrame, new MockVideoMatriarch());

		assertSame(mockExtendableFrame, mainWindowViewController.getMainWindow());
	}

	@Test
	public void testGetsVideoMatriarchPassedIn() throws Exception {
		final MockVideoMatriarch mockVideoMatriarch = new MockVideoMatriarch();
		final MainWindowViewController mainWindowViewController = new MainWindowViewController(
				new MockExtendableFrame(), mockVideoMatriarch);

		assertSame(mockVideoMatriarch, mainWindowViewController.getVideoMatriarch());
	}

	@Test
	public void testShowViewSetsTheVisabilityOfMainWindowToTrue() throws Exception {
		final MockExtendableFrame mainWindow = new MockExtendableFrame();
		final MainWindowViewController mainWindowViewController = new MainWindowViewController(
				mainWindow, new MockVideoMatriarch());

		assertFalse(mainWindow.isVisible());
		mainWindowViewController.showView();
		assertTrue(mainWindow.isVisible());
	}

	@Test
	public void testConstructionAddsCorrectWindowListenerToMainWindow() throws Exception {
		final MockExtendableFrame mainWindow = new MockExtendableFrame();
		final MainWindowViewController mainWindowViewController = new MainWindowViewController(
				mainWindow, new MockVideoMatriarch());

		final WindowListener[] windowListeners = mainWindow.getWindowListeners();
		assertEquals(1, windowListeners.length);

		final MainWindowCloseListener mainWindowCloseListener = assertIsOfTypeAndGet(
				MainWindowCloseListener.class, windowListeners[0]);
		assertSame(mainWindowViewController, mainWindowCloseListener.getViewController());
	}

}
