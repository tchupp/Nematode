package com.nematode.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;

import org.junit.Test;

import com.nematode.nullmodel.NullBufferedImage;
import com.nematode.unittesting.AssertTestCase;

public class NematodeVideoPanelTest extends AssertTestCase {

	@Test
	public void testExtendsJFrame() throws Exception {
		assertExtends(NematodePanel.class, NematodeVideoPanel.class);
	}

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final NematodeVideoPanel videoPanel = new NematodeVideoPanel();

		assertIsOfTypeAndGet(CompoundBorder.class, videoPanel.getBorder());

		assertIsOfTypeAndGet(GridBagLayout.class, videoPanel.getLayout());
	}

	@Test
	public void testImageLabelIsCorrectlyOnPanel() throws Exception {
		final NematodeVideoPanel videoPanel = new NematodeVideoPanel();
		assertEquals(1, videoPanel.getComponentCount());
		final JLabel imageLabel = assertIsOfTypeAndGet(JLabel.class,
				videoPanel.getComponent(0));
		assertEquals("imageLabel", imageLabel.getName());
		final Dimension expectedDimentions = new Dimension(
				NematodeVideoPanel.ICON_WIDTH, NematodeVideoPanel.ICON_HEIGHT);
		assertEquals(expectedDimentions, imageLabel.getSize());
		final ImageIcon imageIcon = assertIsOfTypeAndGet(ImageIcon.class,
				imageLabel.getIcon());
		assertIsOfTypeAndGet(NullBufferedImage.class, imageIcon.getImage());

		final GridBagLayout gridBagLayout = assertIsOfTypeAndGet(
				GridBagLayout.class, videoPanel.getLayout());
		final GridBagConstraints constraints = gridBagLayout
				.getConstraints(imageLabel);
		assertEquals(0, constraints.gridy);
		assertEquals(new Insets(5, 5, 5, 5), constraints.insets);
	}

	@Test
	public void testGetImageLabel() throws Exception {
		final NematodeVideoPanel videoPanel = new NematodeVideoPanel();

		assertEquals(1, videoPanel.getComponentCount());
		final JLabel expectedImageLabel = assertIsOfTypeAndGet(JLabel.class,
				videoPanel.getComponent(0));

		final JLabel actualImageLabel = videoPanel.getImageLabel();

		assertSame(expectedImageLabel, actualImageLabel);
	}

	@Test
	public void testIconWidthAndHeightConstants() throws Exception {
		assertEquals(900, NematodeVideoPanel.ICON_HEIGHT);
		assertEquals(1200, NematodeVideoPanel.ICON_WIDTH);
	}
}