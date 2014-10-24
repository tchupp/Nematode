package com.nematode.gui;

import java.awt.Component;
import java.awt.Container;

import org.junit.Test;

import com.nematode.image.detection.ContourAreaCalculator;
import com.nematode.image.detection.EdgeDetectionRunner;
import com.nematode.image.detection.SquareContourTracer;
import com.nematode.image.processing.ImageProcessingHelper;
import com.nematode.image.processing.ImageProcessingRunner;
import com.nematode.model.VideoFrame;
import com.nematode.model.VideoFrameHandler;
import com.nematode.model.VideoFrameHandlerInterface;
import com.nematode.model.factory.FrameImageAssembler;
import com.nematode.model.factory.NematodeWormBuilder;
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
		final ExtendableJFrame nematodeMainView = nematodeMainViewController
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

		assertIsOfTypeAndGet(VideoFrame.class,
				videoFrameHandler.getVideoFrame());
		assertIsOfTypeAndGet(FrameImageAssembler.class,
				videoFrameHandler.getFrameImageAssembler());

		final ImageProcessingRunner imageProcessingRunner = assertIsOfTypeAndGet(
				ImageProcessingRunner.class,
				videoFrameHandler.getImageProcessingRunner());
		assertIsOfTypeAndGet(ImageProcessingHelper.class,
				imageProcessingRunner.getImageProcessingHelper());

		final EdgeDetectionRunner edgeDetectionRunner = assertIsOfTypeAndGet(
				EdgeDetectionRunner.class,
				videoFrameHandler.getEdgeDetectionRunner());
		assertIsOfTypeAndGet(SquareContourTracer.class,
				edgeDetectionRunner.getContourTracer());
		final NematodeWormBuilder nematodeWormBuilder = assertIsOfTypeAndGet(
				NematodeWormBuilder.class,
				edgeDetectionRunner.getNematodeWormBuilder());
		assertIsOfTypeAndGet(ImageProcessingHelper.class,
				edgeDetectionRunner.getImageProcessingHelper());

		assertIsOfTypeAndGet(ContourAreaCalculator.class,
				nematodeWormBuilder.getContourAreaCalculator());
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

		final VideoFrameHandler expectedFrameHandler = assertIsOfTypeAndGet(
				VideoFrameHandler.class, viewController.getVideoFrameHandler());
		final VideoFrameHandlerInterface actualFrameHandler = videoPanelViewController
				.getVideoFrameHandler();

		assertSame(expectedFrameHandler, actualFrameHandler);
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
