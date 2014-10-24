package com.nematode.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import org.junit.Test;

import com.nematode.nullmodel.NullBufferedImage;
import com.nematode.unittesting.AssertTestCase;

public class VideoPanelTest extends AssertTestCase {

	@Test
	public void testExtendsNematodePanel() throws Exception {
		assertExtends(ExtendableJPanel.class, VideoPanel.class);
	}

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final VideoPanel videoPanel = new VideoPanel();

		assertEquals(2, videoPanel.getComponentCount());

		assertIsOfTypeAndGet(CompoundBorder.class, videoPanel.getBorder());

		final GridBagLayout videoPanelLayout = assertIsOfTypeAndGet(
				GridBagLayout.class, videoPanel.getLayout());

		final JPanel imagePanel = assertIsOfTypeAndGet(JPanel.class,
				videoPanel.getComponent(0));
		assertEquals("imagePanel", imagePanel.getName());
		final GridBagConstraints imagePanelConstraints = videoPanelLayout
				.getConstraints(imagePanel);
		assertEquals(0, imagePanelConstraints.gridy);
		assertEquals(1d, imagePanelConstraints.weighty);
		assertEquals(GridBagConstraints.NORTH, imagePanelConstraints.anchor);
		assertEquals(new Insets(5, 5, 5, 5), imagePanelConstraints.insets);

		final JPanel controlPanel = assertIsOfTypeAndGet(JPanel.class,
				videoPanel.getComponent(1));
		assertEquals("controlPanel", controlPanel.getName());
		final GridBagConstraints controlPanelConstraints = videoPanelLayout
				.getConstraints(controlPanel);
		assertEquals(1, controlPanelConstraints.gridy);
		assertEquals(GridBagConstraints.SOUTH, controlPanelConstraints.anchor);
		assertEquals(new Insets(5, 5, 5, 5), controlPanelConstraints.insets);
	}

	@Test
	public void testImagePanelAndImageLabel() throws Exception {
		final VideoPanel videoPanel = new VideoPanel();
		final JPanel imagePanel = assertIsOfTypeAndGet(JPanel.class,
				videoPanel.getComponent(0));
		assertEquals("imagePanel", imagePanel.getName());

		assertEquals(1, imagePanel.getComponentCount());
		final JLabel imageLabel = assertIsOfTypeAndGet(JLabel.class,
				imagePanel.getComponent(0));
		assertEquals("imageLabel", imageLabel.getName());
		final Dimension expectedDimentions = new Dimension(
				VideoPanel.ICON_WIDTH, VideoPanel.ICON_HEIGHT);
		assertEquals(expectedDimentions, imageLabel.getSize());

		final ImageIcon imageIcon = assertIsOfTypeAndGet(ImageIcon.class,
				imageLabel.getIcon());
		assertIsOfTypeAndGet(NullBufferedImage.class, imageIcon.getImage());

		final GridBagLayout layout = assertIsOfTypeAndGet(GridBagLayout.class,
				imagePanel.getLayout());

		final GridBagConstraints constraints = layout
				.getConstraints(imageLabel);
		assertEquals(0, constraints.gridy);
		assertEquals(new Insets(5, 5, 5, 5), constraints.insets);
	}

	@Test
	public void testGetImageLabel() throws Exception {
		final VideoPanel videoPanel = new VideoPanel();

		assertEquals(2, videoPanel.getComponentCount());
		final JPanel imagePanel = assertIsOfTypeAndGet(JPanel.class,
				videoPanel.getComponent(0));

		final JLabel expectedImageLabel = assertIsOfTypeAndGet(JLabel.class,
				imagePanel.getComponent(0));

		final JLabel actualImageLabel = videoPanel.getImageLabel();

		assertSame(expectedImageLabel, actualImageLabel);
	}

	@Test
	public void testIconWidthAndHeightConstants() throws Exception {
		assertEquals(1500, VideoPanel.ICON_WIDTH);
		assertEquals(900, VideoPanel.ICON_HEIGHT);
	}
}