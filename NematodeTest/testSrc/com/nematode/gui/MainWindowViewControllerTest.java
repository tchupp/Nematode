package com.nematode.gui;

import java.awt.event.WindowListener;
import java.util.ArrayList;

import org.bytedeco.javacpp.Loader;
import org.junit.Test;

import com.nematode.image.processing.ImageResizer;
import com.nematode.model.MockVideoMatriarch;
import com.nematode.model.VideoSetObserver;
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

	@Test
	public void testGetPanelViewControllers() throws Exception {
		final MainWindowViewController viewController = new MainWindowViewController(
				new MockExtendableFrame(), new MockVideoMatriarch());

		assertIsOfTypeAndGet(ProjectPanelViewController.class,
				viewController.getProjectPanelViewController());

		assertIsOfTypeAndGet(TrackingPanelViewController.class,
				viewController.getTrackingPanelViewController());

		assertIsOfTypeAndGet(VideoPanelViewController.class,
				viewController.getVideoPanelViewController());

		assertIsOfTypeAndGet(ToolbarPanelViewController.class,
				viewController.getToolbarPanelViewController());

		assertIsOfTypeAndGet(StatusPanelViewController.class,
				viewController.getStatusPanelViewController());
	}

	@Test
	public void testVideoPanelViewControllerHasCorrectArguments_ImageResizer() throws Exception {
		final MainWindowViewController viewController = new MainWindowViewController(
				new MockExtendableFrame(), new MockVideoMatriarch());

		final VideoPanelViewController videoViewController = assertIsOfTypeAndGet(
				VideoPanelViewController.class, viewController.getVideoPanelViewController());

		assertIsOfTypeAndGet(ImageResizer.class, videoViewController.getImageResizer());
	}

	@Test
	public void testProjectPanelViewControllerHasCorrectArguments_VideoMatriarch() throws Exception {
		final MainWindowViewController viewController = new MainWindowViewController(
				new MockExtendableFrame(), new MockVideoMatriarch());

		final ProjectPanelViewController projectViewController = assertIsOfTypeAndGet(
				ProjectPanelViewController.class, viewController.getProjectPanelViewController());

		assertSame(viewController.getVideoMatriarch(), projectViewController.getVideoMatriarch());
	}

	@Test
	public void testVideoSetObserverIsAddedToVideoMatriarch() throws Exception {
		final MockVideoMatriarch videoMatriarch = new MockVideoMatriarch();
		final MainWindowViewController viewController = new MainWindowViewController(
				new MockExtendableFrame(), videoMatriarch);

		assertEquals(1, videoMatriarch.getNumberOfObservers());

		final VideoSetObserver videoSetObserver = assertIsOfTypeAndGet(VideoSetObserver.class,
				videoMatriarch.getObserverToAdd());
		assertSame(videoSetObserver, viewController.getVideoSetObserver());
	}

	@Test
	public void testDisposeRemovesVideoSetObserverFromVideoMatriarch() throws Exception {
		final MockVideoMatriarch videoMatriarch = new MockVideoMatriarch();
		final MainWindowViewController viewController = new MainWindowViewController(
				new MockExtendableFrame(), videoMatriarch);

		assertEquals(1, videoMatriarch.getNumberOfObservers());
		assertSame(viewController.getVideoSetObserver(), videoMatriarch.getObserverToAdd());

		viewController.dispose();

		assertEquals(0, videoMatriarch.getNumberOfObservers());
		assertSame(viewController.getVideoSetObserver(), videoMatriarch.getObserverToRemove());
	}

	@Test
	public void testPlayButtonObserverIsAddedToToolbarPanelViewController() throws Exception {
		final MainWindowViewController viewController = new MainWindowViewController(
				new MockExtendableFrame(), new MockVideoMatriarch());

		final ToolbarPanelViewController toolbarPanelViewController = assertIsOfTypeAndGet(
				ToolbarPanelViewController.class, viewController.getToolbarPanelViewController());

		final ArrayList<ToolbarObserverInterface> observerList = toolbarPanelViewController
				.getObserverList();
		assertEquals(1, observerList.size());

		final PlayButtonObserver playButtonObserver = assertIsOfTypeAndGet(
				PlayButtonObserver.class, observerList.get(0));
		assertSame(viewController.getPlayButtonObserver(), playButtonObserver);
	}

	@Test
	public void testDisposeRemovedPlayButtonObserverFromToolbarPanelViewController()
			throws Exception {
		final MainWindowViewController viewController = new MainWindowViewController(
				new MockExtendableFrame(), new MockVideoMatriarch());

		final ToolbarPanelViewController toolbarPanelViewController = assertIsOfTypeAndGet(
				ToolbarPanelViewController.class, viewController.getToolbarPanelViewController());

		final ArrayList<ToolbarObserverInterface> observerList = toolbarPanelViewController
				.getObserverList();
		assertEquals(1, observerList.size());

		viewController.dispose();

		assertEquals(0, observerList.size());
	}
}
