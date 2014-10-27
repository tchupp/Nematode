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

		assertEquals(1, videoPanel.getComponentCount());

		assertIsOfTypeAndGet(CompoundBorder.class, videoPanel.getBorder());

		final GridBagLayout videoPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				videoPanel.getLayout());

		final JPanel imagePanel = assertIsOfTypeAndGet(JPanel.class, videoPanel.getComponent(0));
		assertEquals("imagePanel", imagePanel.getName());
		final GridBagConstraints imagePanelConstraints = videoPanelLayout
				.getConstraints(imagePanel);

		assertEquals(GridBagConstraints.NORTH, imagePanelConstraints.anchor);
		assertEquals(new Insets(5, 5, 5, 5), imagePanelConstraints.insets);
	}

	@Test
	public void testImagePanelAndImageLabel() throws Exception {
		final VideoPanel videoPanel = new VideoPanel();
		final JPanel imagePanel = assertIsOfTypeAndGet(JPanel.class, videoPanel.getComponent(0));
		assertEquals("imagePanel", imagePanel.getName());

		assertEquals(1, imagePanel.getComponentCount());
		final JLabel imageLabel = assertIsOfTypeAndGet(JLabel.class, imagePanel.getComponent(0));
		assertEquals("imageLabel", imageLabel.getName());
		final Dimension expectedDimentions = new Dimension(GuiConstants.DISPLAY_WIDTH,
				GuiConstants.DISPLAY_HEIGHT);
		assertEquals(expectedDimentions, imageLabel.getSize());

		final ImageIcon imageIcon = assertIsOfTypeAndGet(ImageIcon.class, imageLabel.getIcon());
		assertIsOfTypeAndGet(NullBufferedImage.class, imageIcon.getImage());

		final GridBagLayout layout = assertIsOfTypeAndGet(GridBagLayout.class,
				imagePanel.getLayout());

		final GridBagConstraints constraints = layout.getConstraints(imageLabel);
		assertEquals(0, constraints.gridy);
		assertEquals(new Insets(5, 5, 5, 5), constraints.insets);
	}

	@Test
	public void testGetImageLabel() throws Exception {
		final VideoPanel videoPanel = new VideoPanel();

		assertEquals(1, videoPanel.getComponentCount());
		final JPanel imagePanel = assertIsOfTypeAndGet(JPanel.class, videoPanel.getComponent(0));

		final JLabel expectedImageLabel = assertIsOfTypeAndGet(JLabel.class,
				imagePanel.getComponent(0));

		final JLabel actualImageLabel = videoPanel.getImageLabel();

		assertSame(expectedImageLabel, actualImageLabel);
	}
}
