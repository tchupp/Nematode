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

public class MainWindowViewControllerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(MainWindowControllerInterface.class, MainWindowViewController.class);
	}

	@Test
	public void testConstructionAddsPanelsToViewCorrectly() throws Exception {
		final MainWindowViewController mainWindowViewController = new MainWindowViewController();
		final ExtendableJFrame mainWindow = mainWindowViewController.getMainWindow();

		final Container contentPane = mainWindow.getContentPane();
		final Component[] components = contentPane.getComponents();
		assertEquals(3, components.length);

		assertIsOfTypeAndGet(ProjectPanel.class, components[0]);
		assertIsOfTypeAndGet(VideoPanel.class, components[1]);
		assertIsOfTypeAndGet(TrackingPanel.class, components[2]);
	}

	@Test
	public void testGetVideoFrameHandler() throws Exception {
		final MainWindowViewController mainWindowViewController = new MainWindowViewController();
		final VideoFrameHandler videoFrameHandler = assertIsOfTypeAndGet(VideoFrameHandler.class,
				mainWindowViewController.getVideoFrameHandler());

		assertIsOfTypeAndGet(VideoFrame.class, videoFrameHandler.getVideoFrame());
		assertIsOfTypeAndGet(FrameImageAssembler.class, videoFrameHandler.getFrameImageAssembler());

		final ImageProcessingRunner imageProcessingRunner = assertIsOfTypeAndGet(
				ImageProcessingRunner.class, videoFrameHandler.getImageProcessingRunner());
		assertIsOfTypeAndGet(ImageProcessingHelper.class,
				imageProcessingRunner.getImageProcessingHelper());

		final EdgeDetectionRunner edgeDetectionRunner = assertIsOfTypeAndGet(
				EdgeDetectionRunner.class, videoFrameHandler.getEdgeDetectionRunner());
		assertIsOfTypeAndGet(SquareContourTracer.class, edgeDetectionRunner.getContourTracer());
		final NematodeWormBuilder nematodeWormBuilder = assertIsOfTypeAndGet(
				NematodeWormBuilder.class, edgeDetectionRunner.getNematodeWormBuilder());
		assertIsOfTypeAndGet(ImageProcessingHelper.class,
				edgeDetectionRunner.getImageProcessingHelper());

		assertIsOfTypeAndGet(ContourAreaCalculator.class,
				nematodeWormBuilder.getContourAreaCalculator());
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
	}

	@Test
	public void testProjectPanelViewControllerIsCreatedWithCorrectVideoFrameHandler()
			throws Exception {
		final MainWindowViewController viewController = new MainWindowViewController();
		final ProjectPanelViewController projectPanelViewController = assertIsOfTypeAndGet(
				ProjectPanelViewController.class, viewController.getProjectPanelViewController());

		final VideoFrameHandlerInterface actualVideoFrameHandler = projectPanelViewController
				.getVideoFrameHandler();

		assertSame(viewController.getVideoFrameHandler(), actualVideoFrameHandler);
	}

	@Test
	public void testVideoPanelControllerIsCreatedWithCorrectVideoFrameModel() throws Exception {

		final MainWindowViewController viewController = new MainWindowViewController();
		final VideoPanelViewController videoPanelViewController = assertIsOfTypeAndGet(
				VideoPanelViewController.class, viewController.getVideoPanelViewController());

		final VideoFrameHandler expectedFrameHandler = assertIsOfTypeAndGet(
				VideoFrameHandler.class, viewController.getVideoFrameHandler());
		final VideoFrameHandlerInterface actualFrameHandler = videoPanelViewController
				.getVideoFrameHandler();

		assertSame(expectedFrameHandler, actualFrameHandler);
	}

	@Test
	public void testTrackingPanelControllerIsCreadtedWithCorrectVideoFrameHandler()
			throws Exception {
		final MainWindowViewController viewController = new MainWindowViewController();
		final TrackingPanelViewController trackingPanelViewController = assertIsOfTypeAndGet(
				TrackingPanelViewController.class, viewController.getTrackingPanelViewController());

		final VideoFrameHandler expectedFrameHandler = assertIsOfTypeAndGet(
				VideoFrameHandler.class, viewController.getVideoFrameHandler());
		final VideoFrameHandlerInterface actualFrameHandler = trackingPanelViewController
				.getVideoFrameHandler();

		assertSame(expectedFrameHandler, actualFrameHandler);
	}
}
