package com.nematode.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class MainWindowTest extends AssertTestCase {

	private BufferedImage expectedBackgroundImage;
	private BufferedImage expectedPlayButtonImage;
	private BufferedImage expectedPauseButtonImage;

	@Override
	protected void setUp() throws Exception {
		this.expectedBackgroundImage = ImageIO.read(new File(
				GuiConstants.MAIN_WINDOW_BACKGROUND_IMAGE_PATH));

		this.expectedPlayButtonImage = ImageIO.read(new File(GuiConstants.PLAY_BUTTON_IMAGE_PATH));

		this.expectedPauseButtonImage = ImageIO
				.read(new File(GuiConstants.PAUSE_BUTTON_IMAGE_PATH));
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
		assertNull(controlPanel.getBorder());

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
		assertNull(scanningPanel.getBorder());

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
	public void testVideoPanelIsCorrectlySetUp() throws Exception {
		final MainWindow mainWindow = new MainWindow();

		final Container contentPane = mainWindow.getContentPane();
		final ExtendableJPanel scanningPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(1));

		final ExtendableJPanel videoPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				scanningPanel.getComponent(0));

		assertEquals("videoPanel", videoPanel.getName());

		assertEquals(GuiConstants.backgroundColor, videoPanel.getBackground());
		assertEquals(1, videoPanel.getComponentCount());
		assertTrue(videoPanel.isOpaque());

		assertIsOfTypeAndGet(CompoundBorder.class, videoPanel.getBorder());
		assertIsOfTypeAndGet(GridBagLayout.class, videoPanel.getLayout());
	}

	@Test
	public void testVideoLabelIsCorrectlyAddedToVideoPanel() throws Exception {
		final MainWindow mainWindow = new MainWindow();

		final Container contentPane = mainWindow.getContentPane();
		final ExtendableJPanel scanningPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(1));

		final ExtendableJPanel videoPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				scanningPanel.getComponent(0));

		final JLabel videoLabel = assertIsOfTypeAndGet(JLabel.class, videoPanel.getComponent(0));
		assertEquals("videoLabel", videoLabel.getName());
		assertSame(mainWindow.getVideoLabel(), videoLabel);

		final Dimension expectedDimentions = new Dimension(GuiConstants.DISPLAY_WIDTH,
				GuiConstants.DISPLAY_HEIGHT);
		assertEquals(expectedDimentions, videoLabel.getSize());

		final ImageIcon imageIcon = assertIsOfTypeAndGet(ImageIcon.class, videoLabel.getIcon());
		final BufferedImage defaultIconImage = assertIsOfTypeAndGet(BufferedImage.class,
				imageIcon.getImage());
		assertEquals(GuiConstants.DISPLAY_WIDTH, defaultIconImage.getWidth());
		assertEquals(GuiConstants.DISPLAY_HEIGHT, defaultIconImage.getHeight());

		final GridBagLayout videoPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				videoPanel.getLayout());
		final GridBagConstraints videoLabelConstraints = videoPanelLayout
				.getConstraints(videoLabel);
		assertEquals(GridBagConstraints.CENTER, videoLabelConstraints.anchor);
		assertEquals(new Insets(1, 1, 1, 1), videoLabelConstraints.insets);
	}

	@Test
	public void testVideoPanelIsCorrectlyAddedToScanningPanel() throws Exception {
		final MainWindow mainWindow = new MainWindow();

		final Container contentPane = mainWindow.getContentPane();
		final ExtendableJPanel scanningPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(1));
		final GridBagLayout scanningPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				scanningPanel.getLayout());

		final ExtendableJPanel videoPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
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
	public void testToolbarPanelIsCorrectlySetUp() throws Exception {
		final MainWindow mainWindow = new MainWindow();

		final Container contentPane = mainWindow.getContentPane();
		final ExtendableJPanel scanningPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(1));

		final ExtendableJPanel toolbarPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				scanningPanel.getComponent(1));

		assertEquals("toolbarPanel", toolbarPanel.getName());

		assertEquals(GuiConstants.backgroundColor, toolbarPanel.getBackground());
		assertEquals(2, toolbarPanel.getComponentCount());
		assertTrue(toolbarPanel.isOpaque());

		assertIsOfTypeAndGet(CompoundBorder.class, toolbarPanel.getBorder());
		assertIsOfTypeAndGet(GridBagLayout.class, toolbarPanel.getLayout());
	}

	@Test
	public void testPlayButtonIsCorrectlySetUpAndAddedToToolbarPanel() throws Exception {
		final MainWindow mainWindow = new MainWindow();

		final Container contentPane = mainWindow.getContentPane();
		final ExtendableJPanel scanningPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(1));

		final ExtendableJPanel toolbarPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				scanningPanel.getComponent(1));
		final GridBagLayout toolbarPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				toolbarPanel.getLayout());

		final JButton playButton = assertIsOfTypeAndGet(JButton.class, toolbarPanel.getComponent(0));
		assertSame(mainWindow.getPlayButton(), playButton);
		assertEquals("playButton", playButton.getName());
		assertEquals(new Dimension(20, 20), playButton.getPreferredSize());

		final GridBagConstraints constraints = toolbarPanelLayout.getConstraints(playButton);
		assertEquals(0, constraints.gridx);
		assertEquals(0, constraints.gridy);
		assertEquals(0.0, constraints.weightx);
		assertEquals(GridBagConstraints.WEST, constraints.anchor);
		assertEquals(new Insets(5, 5, 5, 5), constraints.insets);

		final ImageIcon buttonImageIcon = assertIsOfTypeAndGet(ImageIcon.class,
				playButton.getIcon());

		assertEquals(MediaTracker.COMPLETE, buttonImageIcon.getImageLoadStatus());
		assertEquals(this.expectedPlayButtonImage.getWidth(), buttonImageIcon.getIconWidth());
		assertEquals(this.expectedPlayButtonImage.getHeight(), buttonImageIcon.getIconHeight());
	}

	@Test
	public void testPauseButtonIsCorrectlySetUpAndAddedToToolbarPanel() throws Exception {
		final MainWindow mainWindow = new MainWindow();

		final Container contentPane = mainWindow.getContentPane();
		final ExtendableJPanel scanningPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(1));

		final ExtendableJPanel toolbarPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				scanningPanel.getComponent(1));
		final GridBagLayout toolbarPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				toolbarPanel.getLayout());

		final JButton pauseButton = assertIsOfTypeAndGet(JButton.class,
				toolbarPanel.getComponent(1));
		assertSame(mainWindow.getPauseButton(), pauseButton);
		assertEquals("pauseButton", pauseButton.getName());
		assertEquals(new Dimension(20, 20), pauseButton.getPreferredSize());

		final GridBagConstraints constraints = toolbarPanelLayout.getConstraints(pauseButton);
		assertEquals(1, constraints.gridx);
		assertEquals(0, constraints.gridy);
		assertEquals(1.0, constraints.weightx);
		assertEquals(GridBagConstraints.WEST, constraints.anchor);
		assertEquals(new Insets(5, 5, 5, 5), constraints.insets);

		final ImageIcon buttonImageIcon = assertIsOfTypeAndGet(ImageIcon.class,
				pauseButton.getIcon());

		assertEquals(MediaTracker.COMPLETE, buttonImageIcon.getImageLoadStatus());
		assertEquals(this.expectedPauseButtonImage.getWidth(), buttonImageIcon.getIconWidth());
		assertEquals(this.expectedPauseButtonImage.getHeight(), buttonImageIcon.getIconHeight());
	}

	@Test
	public void testToolbarPanelIsCorrectlyAddedToScanningPanel() throws Exception {
		final MainWindow mainWindow = new MainWindow();

		final Container contentPane = mainWindow.getContentPane();
		final ExtendableJPanel scanningPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(1));
		final GridBagLayout scanningPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				scanningPanel.getLayout());

		final ExtendableJPanel toolbarPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
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
	public void testStatusPanelIsCorrectlySetUp() throws Exception {
		final MainWindow mainWindow = new MainWindow();

		final Container contentPane = mainWindow.getContentPane();
		final ExtendableJPanel scanningPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(1));

		final ExtendableJPanel statusPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				scanningPanel.getComponent(2));

		assertEquals("statusPanel", statusPanel.getName());

		assertEquals(GuiConstants.backgroundColor, statusPanel.getBackground());
		assertEquals(0, statusPanel.getComponentCount());
		assertTrue(statusPanel.isOpaque());

		assertIsOfTypeAndGet(CompoundBorder.class, statusPanel.getBorder());
	}

	@Test
	public void testStatusPanelIsCorrectlyAddedToScanningPanel() throws Exception {
		final MainWindow mainWindow = new MainWindow();

		final Container contentPane = mainWindow.getContentPane();
		final ExtendableJPanel scanningPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
				contentPane.getComponent(1));
		final GridBagLayout scanningPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				scanningPanel.getLayout());

		final ExtendableJPanel statusPanel = assertIsOfTypeAndGet(ExtendableJPanel.class,
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
