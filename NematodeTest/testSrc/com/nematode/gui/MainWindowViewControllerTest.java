package com.nematode.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
		assertImplementsInterface(MainWindowControllerInterface.class,
				MainWindowViewController.class);
	}

	@Test
	public void testConstructionAddsCorrectNumberOfComponentsToMainWindow() throws Exception {
		final MainWindowViewController mainWindowViewController = new MainWindowViewController();
		final ExtendableJFrame mainWindow = mainWindowViewController.getMainWindow();

		final Container contentPane = mainWindow.getContentPane();
		assertEquals(2, contentPane.getComponentCount());
	}

	@Test
	public void testControlPanelIsCorrectlyOnMainWindow() throws Exception {
		final MainWindowViewController mainWindowViewController = new MainWindowViewController();
		final ExtendableJFrame mainWindow = mainWindowViewController.getMainWindow();

		final Container contentPane = mainWindow.getContentPane();

		final GridBagLayout mainWindowLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				contentPane.getLayout());
		final ExtendableJPanel controlPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(0));

		assertEquals("controlPanel", controlPanel.getName());
		assertEquals(2, controlPanel.getComponentCount());
		assertIsOfTypeAndGet(GridBagLayout.class, controlPanel.getLayout());

		final GridBagConstraints controlPanelContraints = mainWindowLayout
				.getConstraints(controlPanel);
		assertEquals(0, controlPanelContraints.gridx);
		assertEquals(0, controlPanelContraints.gridy);
		assertEquals(0.0, controlPanelContraints.weightx);
		assertEquals(1.0, controlPanelContraints.weighty);
		assertEquals(GridBagConstraints.VERTICAL, controlPanelContraints.fill);
		assertEquals(GridBagConstraints.LINE_START, controlPanelContraints.anchor);
	}

	@Test
	public void testScanningPanelIsCorrectlyOnMainWindow() throws Exception {
		final MainWindowViewController mainWindowViewController = new MainWindowViewController();
		final ExtendableJFrame mainWindow = mainWindowViewController.getMainWindow();

		final Container contentPane = mainWindow.getContentPane();

		final GridBagLayout mainWindowLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				contentPane.getLayout());
		final ExtendableJPanel scanningPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(1));

		assertEquals("scanningPanel", scanningPanel.getName());
		assertEquals(3, scanningPanel.getComponentCount());
		assertIsOfTypeAndGet(GridBagLayout.class, scanningPanel.getLayout());

		final GridBagConstraints scanningPanelConstraints = mainWindowLayout
				.getConstraints(scanningPanel);
		assertEquals(1, scanningPanelConstraints.gridx);
		assertEquals(0, scanningPanelConstraints.gridy);
		assertEquals(0.8, scanningPanelConstraints.weightx);
		assertEquals(1.0, scanningPanelConstraints.weighty);
		assertEquals(GridBagConstraints.BOTH, scanningPanelConstraints.fill);
		assertEquals(GridBagConstraints.LINE_END, scanningPanelConstraints.anchor);

	}

	@Test
	public void testProjectPanelIsCorrectlyAddedToControlPanel() throws Exception {
		final MainWindowViewController mainWindowViewController = new MainWindowViewController();
		final ExtendableJFrame mainWindow = mainWindowViewController.getMainWindow();

		final Container contentPane = mainWindow.getContentPane();

		final ExtendableJPanel controlPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(0));
		final GridBagLayout controlPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				controlPanel.getLayout());

		final ProjectPanel projectPanel = assertIsOfTypeAndGet(ProjectPanel.class,
				controlPanel.getComponent(0));

		final GridBagConstraints projectPanelConstraints = controlPanelLayout
				.getConstraints(projectPanel);
		assertEquals(0, projectPanelConstraints.gridx);
		assertEquals(0, projectPanelConstraints.gridy);
		assertEquals(1, projectPanelConstraints.gridheight);
		assertEquals(0.5, projectPanelConstraints.weighty);
		assertEquals(GridBagConstraints.BOTH, projectPanelConstraints.fill);
	}

	@Test
	public void testTrackingPanelIsCorrectlyAddedToControlPanel() throws Exception {
		final MainWindowViewController mainWindowViewController = new MainWindowViewController();
		final ExtendableJFrame mainWindow = mainWindowViewController.getMainWindow();

		final Container contentPane = mainWindow.getContentPane();

		final ExtendableJPanel controlPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(0));
		final GridBagLayout controlPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				controlPanel.getLayout());

		final TrackingPanel trackingPanel = assertIsOfTypeAndGet(TrackingPanel.class,
				controlPanel.getComponent(1));

		final GridBagConstraints trackingPanelConstraints = controlPanelLayout
				.getConstraints(trackingPanel);
		assertEquals(0, trackingPanelConstraints.gridx);
		assertEquals(1, trackingPanelConstraints.gridy);
		assertEquals(1, trackingPanelConstraints.gridheight);
		assertEquals(0.5, trackingPanelConstraints.weighty);
		assertEquals(GridBagConstraints.BOTH, trackingPanelConstraints.fill);
	}

	@Test
	public void testVideoPanelIsCorrectlyAddedToScanningPanel() throws Exception {
		final MainWindowViewController mainWindowViewController = new MainWindowViewController();
		final ExtendableJFrame mainWindow = mainWindowViewController.getMainWindow();

		final Container contentPane = mainWindow.getContentPane();
		final ExtendableJPanel scanningPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(1));
		final GridBagLayout scanningPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				scanningPanel.getLayout());

		final VideoPanel videoPanel = assertIsOfTypeAndGet(VideoPanel.class,
				scanningPanel.getComponent(0));

		final GridBagConstraints videoPanelConstraints = scanningPanelLayout
				.getConstraints(videoPanel);
		assertEquals(1, videoPanelConstraints.gridx);
		assertEquals(1, videoPanelConstraints.gridy);
		assertEquals(4, videoPanelConstraints.gridheight);
		assertEquals(1.0, videoPanelConstraints.weightx);
		assertEquals(0.1, videoPanelConstraints.weighty);
		assertEquals(GridBagConstraints.BOTH, videoPanelConstraints.fill);
	}

	@Test
	public void testToolbarPanelIsCorrectlyAddedToScanningPanel() throws Exception {
		final MainWindowViewController mainWindowViewController = new MainWindowViewController();
		final ExtendableJFrame mainWindow = mainWindowViewController.getMainWindow();

		final Container contentPane = mainWindow.getContentPane();
		final ExtendableJPanel scanningPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(1));
		final GridBagLayout scanningPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				scanningPanel.getLayout());

		final ToolbarPanel toolbarPanel = assertIsOfTypeAndGet(ToolbarPanel.class,
				scanningPanel.getComponent(1));

		final GridBagConstraints toolbarPanelConstraints = scanningPanelLayout
				.getConstraints(toolbarPanel);
		assertEquals(1, toolbarPanelConstraints.gridx);
		assertEquals(0, toolbarPanelConstraints.gridy);
		assertEquals(1.0, toolbarPanelConstraints.weightx);
		assertEquals(0.1, toolbarPanelConstraints.weighty);
		assertEquals(GridBagConstraints.PAGE_START, toolbarPanelConstraints.anchor);
		assertEquals(GridBagConstraints.BOTH, toolbarPanelConstraints.fill);
	}

	@Test
	public void testStatusPanelIsCorrectlyAddedToScanningPanel() throws Exception {
		final MainWindowViewController mainWindowViewController = new MainWindowViewController();
		final ExtendableJFrame mainWindow = mainWindowViewController.getMainWindow();

		final Container contentPane = mainWindow.getContentPane();
		final ExtendableJPanel scanningPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(1));
		final GridBagLayout scanningPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				scanningPanel.getLayout());

		final StatusPanel statusPanel = assertIsOfTypeAndGet(StatusPanel.class,
				scanningPanel.getComponent(2));

		final GridBagConstraints statusPanelConstraints = scanningPanelLayout
				.getConstraints(statusPanel);
		assertEquals(1, statusPanelConstraints.gridx);
		assertEquals(5, statusPanelConstraints.gridy);
		assertEquals(1.0, statusPanelConstraints.weightx);
		assertEquals(0.5, statusPanelConstraints.weighty);
		assertEquals(GridBagConstraints.PAGE_END, statusPanelConstraints.anchor);
		assertEquals(GridBagConstraints.BOTH, statusPanelConstraints.fill);
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

		assertIsOfTypeAndGet(ToolbarPanelViewController.class,
				viewController.getToolbarPanelViewController());

		assertIsOfTypeAndGet(StatusPanelViewController.class,
				viewController.getStatusPanelViewController());
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
	public void testVideoPanelControllerIsCreatedWithCorrectVideoFrameHander() throws Exception {

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
