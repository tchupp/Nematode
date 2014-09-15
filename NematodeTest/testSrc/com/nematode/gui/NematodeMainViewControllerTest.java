package com.nematode.gui;

import java.awt.Component;
import java.awt.Container;

import org.junit.Test;

import com.nematode.imaging.FrameImageAssembler;
import com.nematode.imaging.ImageProcessingRunner;
import com.nematode.imaging.VideoFrameHandler;
import com.nematode.imaging.VideoFrameHandlerInterface;
import com.nematode.model.NematodeVideoFrame;
import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.unittesting.AssertTestCase;

public class NematodeMainViewControllerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(MainViewControllerInterface.class,
				NematodeMainViewController.class);
	}

	@Test
	public void testConstructionAddsPanelsToViewCorrectly() throws Exception {
		final NematodeMainViewController nematodeMainViewController = new NematodeMainViewController();
		final NematodeFrame nematodeMainView = nematodeMainViewController
				.getNematodeMainView();

		final Container contentPane = nematodeMainView.getContentPane();
		final Component[] components = contentPane.getComponents();
		assertEquals(3, components.length);

		assertIsOfTypeAndGet(NematodeProjectPanel.class, components[0]);
		assertIsOfTypeAndGet(NematodeVideoPanel.class, components[1]);
		assertIsOfTypeAndGet(NematodeTrackingPanel.class, components[2]);
	}

	@Test
	public void testGetVideoFrameHandler() throws Exception {
		final NematodeMainViewController nematodeMainViewController = new NematodeMainViewController();
		final VideoFrameHandler videoFrameHandler = assertIsOfTypeAndGet(
				VideoFrameHandler.class,
				nematodeMainViewController.getVideoFrameHandler());

		assertIsOfTypeAndGet(NematodeVideoFrame.class,
				videoFrameHandler.getNematodeVideoFrame());
		assertIsOfTypeAndGet(FrameImageAssembler.class,
				videoFrameHandler.getFrameImageAssembler());
		assertIsOfTypeAndGet(ImageProcessingRunner.class,
				videoFrameHandler.getImageProcessingRunner());
	}

	@Test
	public void testGetsNematodeMainView() throws Exception {
		final NematodeMainViewController nematodeMainViewController = new NematodeMainViewController();
		assertIsOfTypeAndGet(NematodeMainView.class,
				nematodeMainViewController.getNematodeMainView());
	}

	@Test
	public void testGetPanelViewControllers() throws Exception {
		final NematodeMainViewController viewController = new NematodeMainViewController();

		assertIsOfTypeAndGet(NematodeProjectPanelViewController.class,
				viewController.getNematodeProjectPanelViewController());

		assertIsOfTypeAndGet(NematodeTrackingPanelViewController.class,
				viewController.getNematodeTrackingPanelViewController());

		assertIsOfTypeAndGet(NematodeVideoPanelViewController.class,
				viewController.getNematodeVideoPanelViewController());
	}

	@Test
	public void testProjectPanelViewControllerIsCreatedWithCorrectVideoFrameHandler()
			throws Exception {
		final NematodeMainViewController viewController = new NematodeMainViewController();
		final NematodeProjectPanelViewController projectPanelViewController = assertIsOfTypeAndGet(
				NematodeProjectPanelViewController.class,
				viewController.getNematodeProjectPanelViewController());

		final VideoFrameHandlerInterface actualVideoFrameHandler = projectPanelViewController
				.getVideoFrameHandler();

		assertSame(viewController.getVideoFrameHandler(),
				actualVideoFrameHandler);
	}

	@Test
	public void testVideoPanelControllerIsCreatedWithCorrectVideoFrameModel()
			throws Exception {

		final NematodeMainViewController viewController = new NematodeMainViewController();
		final NematodeVideoPanelViewController videoPanelViewController = assertIsOfTypeAndGet(
				NematodeVideoPanelViewController.class,
				viewController.getNematodeVideoPanelViewController());

		final VideoFrameHandler videoFrameHandler = assertIsOfTypeAndGet(
				VideoFrameHandler.class, viewController.getVideoFrameHandler());
		final NematodeVideoFrameInterface expectedNematodeVideoFrame = videoFrameHandler
				.getNematodeVideoFrame();
		final NematodeVideoFrameInterface actualNematodeVideoFrame = videoPanelViewController
				.getNematodeVideoFrame();

		assertSame(expectedNematodeVideoFrame, actualNematodeVideoFrame);
	}

	@Test
	public void testTrackingPanelControllerIsCreadtedWithCorrectVideoFrameHandler()
			throws Exception {
		final NematodeMainViewController viewController = new NematodeMainViewController();
		final NematodeTrackingPanelViewController trackingPanelViewController = assertIsOfTypeAndGet(
				NematodeTrackingPanelViewController.class,
				viewController.getNematodeTrackingPanelViewController());

		final VideoFrameHandler expectedFrameHandler = assertIsOfTypeAndGet(
				VideoFrameHandler.class, viewController.getVideoFrameHandler());
		final VideoFrameHandlerInterface actualFrameHandler = trackingPanelViewController
				.getVideoFrameHandler();

		assertSame(expectedFrameHandler, actualFrameHandler);
	}
}
