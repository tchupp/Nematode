package com.nematode.gui;

import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nematode.image.processing.ImageResizer;
import com.nematode.model.NullVideo;
import com.nematode.model.VideoMatriarch;
import com.nematode.model.VideoObserverInterface;
import com.nematode.model.VideoSetObserver;
import com.nematode.unittesting.AssertTestCase;

public class MainWindowViewControllerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(MainWindowControllerInterface.class,
				MainWindowViewController.class);
	}

	@Test
	public void testConstructionAddsCorrectWindowListenerToMainWindow() throws Exception {
		final MainWindowViewController mainWindowViewController = new MainWindowViewController();

		final MainWindow mainWindow = assertIsOfTypeAndGet(MainWindow.class,
				mainWindowViewController.getMainWindow());
		final WindowListener[] windowListeners = mainWindow.getWindowListeners();
		assertEquals(1, windowListeners.length);

		final MainWindowCloseListener mainWindowCloseListener = assertIsOfTypeAndGet(
				MainWindowCloseListener.class, windowListeners[0]);
		assertSame(mainWindowViewController, mainWindowCloseListener.getViewController());
	}

	@Test
	public void testGetsVideoMatriarch_WithNullVideoJustAfterConstruction() throws Exception {
		final MainWindowViewController viewController = new MainWindowViewController();
		final VideoMatriarch videoMatriarch = assertIsOfTypeAndGet(VideoMatriarch.class,
				viewController.getVideoMatriarch());

		assertIsOfTypeAndGet(NullVideo.class, videoMatriarch.getVideo());
	}

	@Test
	public void testGetsMainWindow() throws Exception {
		final MainWindowViewController mainWindowViewController = new MainWindowViewController();
		assertIsOfTypeAndGet(MainWindow.class, mainWindowViewController.getMainWindow());
	}

	@Test
	public void testGetPanelViewControllers() throws Exception {
		final MainWindowViewController viewController = new MainWindowViewController();

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
		final MainWindowViewController viewController = new MainWindowViewController();

		final VideoPanelViewController videoViewController = assertIsOfTypeAndGet(
				VideoPanelViewController.class, viewController.getVideoPanelViewController());

		assertIsOfTypeAndGet(ImageResizer.class, videoViewController.getImageResizer());
	}

	@Test
	public void testProjectPanelViewControllerHasCorrectArguments_VideoMatriarch() throws Exception {
		final MainWindowViewController viewController = new MainWindowViewController();

		final ProjectPanelViewController projectViewController = assertIsOfTypeAndGet(
				ProjectPanelViewController.class, viewController.getProjectPanelViewController());

		assertSame(viewController.getVideoMatriarch(), projectViewController.getVideoMatriarch());
	}

	@Test
	public void testVideoSetObserverIsAddedToVideoMatriarch() throws Exception {
		final MainWindowViewController viewController = new MainWindowViewController();

		final VideoMatriarch videoMatriarch = assertIsOfTypeAndGet(VideoMatriarch.class,
				viewController.getVideoMatriarch());
		final List<VideoObserverInterface> observerList = videoMatriarch.getObserverList();
		assertEquals(1, observerList.size());

		final VideoSetObserver videoSetObserver = assertIsOfTypeAndGet(VideoSetObserver.class,
				observerList.get(0));
		assertSame(viewController.getVideoSetObserver(), videoSetObserver);

		final VideoPanelViewControllerInterface actualVideoViewController = videoSetObserver
				.getVideoPanelViewController();
		assertSame(viewController.getVideoPanelViewController(), actualVideoViewController);
	}

	@Test
	public void testDisposeRemovesVideoSetObserverFromVideoMatriarch() throws Exception {
		final MainWindowViewController viewController = new MainWindowViewController();

		final VideoMatriarch videoMatriarch = assertIsOfTypeAndGet(VideoMatriarch.class,
				viewController.getVideoMatriarch());

		final List<VideoObserverInterface> observerList = videoMatriarch.getObserverList();
		assertEquals(1, observerList.size());

		viewController.dispose();

		assertEquals(0, observerList.size());
	}

	@Test
	public void testPlayButtonObserverIsAddedToToolbarPanelViewController() throws Exception {
		final MainWindowViewController viewController = new MainWindowViewController();

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
		final MainWindowViewController viewController = new MainWindowViewController();

		final ToolbarPanelViewController toolbarPanelViewController = assertIsOfTypeAndGet(
				ToolbarPanelViewController.class, viewController.getToolbarPanelViewController());

		final ArrayList<ToolbarObserverInterface> observerList = toolbarPanelViewController
				.getObserverList();
		assertEquals(1, observerList.size());

		viewController.dispose();

		assertEquals(0, observerList.size());
	}
}
