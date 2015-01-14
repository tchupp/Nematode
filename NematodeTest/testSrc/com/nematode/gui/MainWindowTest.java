package com.nematode.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class MainWindowTest extends AssertTestCase {

	private BufferedImage expectedBackgroundImage;

	@Override
	protected void setUp() throws Exception {
		this.expectedBackgroundImage = ImageIO.read(new File(
				GuiConstants.MAIN_WINDOW_BACKGROUND_IMAGE_PATH));
	}

	@Test
	public void testExtendsJFrame() throws Exception {
		final MainWindow mainWindow = new MainWindow();
		assertExtends(ExtendableJFrame.class, mainWindow.getClass());

		mainWindow.dispose();
	}

	@Test
	public void testConstructorSetsUpPanelCorrectly() throws Exception {
		final MainWindow mainWindow = new MainWindow();

		assertEquals(JFrame.DISPOSE_ON_CLOSE, mainWindow.getDefaultCloseOperation());

		assertEquals(GuiConstants.VIDEO_FRAME_HEIGHT, mainWindow.getHeight());
		assertEquals(GuiConstants.VIDEO_FRAME_WIDTH, mainWindow.getWidth());
		assertTrue(mainWindow.isResizable());

		final Container contentPane = mainWindow.getContentPane();
		assertIsOfTypeAndGet(GridBagLayout.class, contentPane.getLayout());

		mainWindow.dispose();
	}

	@Test
	public void testConstructorCorrectlySetsUpContentPane() throws Exception {
		final MainWindow mainWindow = new MainWindow();

		final ImagePanel imageContentPane = assertIsOfTypeAndGet(ImagePanel.class,
				mainWindow.getContentPane());

		assertImagesAreEqual(this.expectedBackgroundImage, imageContentPane.getImage());
	}

	@Test
	public void testHasCorrectNumberOfComponents_AndLayout() throws Exception {
		final MainWindow mainWindow = new MainWindow();

		final Container contentPane = mainWindow.getContentPane();
		assertEquals(2, contentPane.getComponentCount());
		assertIsOfTypeAndGet(GridBagLayout.class, contentPane.getLayout());
	}

	@Test
	public void testControlPanelIsCorrectlyPlaced() throws Exception {
		final MainWindow mainWindow = new MainWindow();

		final Container contentPane = mainWindow.getContentPane();

		final GridBagLayout mainWindowLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				contentPane.getLayout());
		final ExtendableJPanel controlPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(0));

		assertEquals("controlPanel", controlPanel.getName());
		assertEquals(2, controlPanel.getComponentCount());
		assertFalse(controlPanel.isOpaque());
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
	public void testScanningPanelIsCorrectlyPlaced() throws Exception {
		final MainWindow mainWindow = new MainWindow();

		final Container contentPane = mainWindow.getContentPane();

		final GridBagLayout mainWindowLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				contentPane.getLayout());
		final ExtendableJPanel scanningPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(1));

		assertEquals("scanningPanel", scanningPanel.getName());
		assertEquals(3, scanningPanel.getComponentCount());
		assertFalse(scanningPanel.isOpaque());
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
		final MainWindow mainWindow = new MainWindow();

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
		final MainWindow mainWindow = new MainWindow();

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
		final MainWindow mainWindow = new MainWindow();

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
		final MainWindow mainWindow = new MainWindow();

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
		final MainWindow mainWindow = new MainWindow();

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

}
