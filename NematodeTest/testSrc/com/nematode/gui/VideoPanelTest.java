package com.nematode.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class VideoPanelTest extends AssertTestCase {

	@Test
	public void testExtendsNematodePanel() throws Exception {
		assertExtends(ExtendableJPanel.class, VideoPanel.class);
	}

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final VideoPanel videoPanel = new VideoPanel();

		assertEquals(1, videoPanel.getComponentCount());

		assertIsOfTypeAndGet(CompoundBorder.class, videoPanel.getBorder());

		assertIsOfTypeAndGet(GridBagLayout.class, videoPanel.getLayout());
	}

	@Test
	public void testImageLabel() throws Exception {
		final VideoPanel videoPanel = new VideoPanel();

		final JLabel imageLabel = assertIsOfTypeAndGet(JLabel.class, videoPanel.getComponent(0));
		assertEquals("imageLabel", imageLabel.getName());

		final Dimension expectedDimentions = new Dimension(GuiConstants.DISPLAY_WIDTH,
				GuiConstants.DISPLAY_HEIGHT);
		assertEquals(expectedDimentions, imageLabel.getSize());

		final ImageIcon imageIcon = assertIsOfTypeAndGet(ImageIcon.class, imageLabel.getIcon());
		final BufferedImage defaultIconImage = assertIsOfTypeAndGet(BufferedImage.class,
				imageIcon.getImage());
		assertEquals(GuiConstants.DISPLAY_WIDTH, defaultIconImage.getWidth());
		assertEquals(GuiConstants.DISPLAY_HEIGHT, defaultIconImage.getHeight());

		final GridBagLayout videoPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				videoPanel.getLayout());
		final GridBagConstraints imageLabelConstraints = videoPanelLayout
				.getConstraints(imageLabel);
		assertEquals(GridBagConstraints.CENTER, imageLabelConstraints.anchor);
		assertEquals(new Insets(1, 1, 1, 1), imageLabelConstraints.insets);
	}

	@Test
	public void testGetImageLabel() throws Exception {
		final VideoPanel videoPanel = new VideoPanel();

		assertEquals(1, videoPanel.getComponentCount());
		final JLabel imageLabel = assertIsOfTypeAndGet(JLabel.class, videoPanel.getComponent(0));

		final JLabel actualImageLabel = videoPanel.getImageLabel();

		assertSame(imageLabel, actualImageLabel);
	}
}
