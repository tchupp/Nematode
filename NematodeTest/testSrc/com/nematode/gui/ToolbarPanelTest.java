package com.nematode.gui;

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
import javax.swing.border.CompoundBorder;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ToolbarPanelTest extends AssertTestCase {

	private BufferedImage expectedCropButtonImage;

	@Override
	protected void setUp() throws Exception {
		this.expectedCropButtonImage = ImageIO.read(new File(
				GuiConstants.CROP_AREA_BUTTON_IMAGE_PATH));
	}

	@Test
	public void testExtendsJFrame() throws Exception {
		assertExtends(ExtendableJPanel.class, ToolbarPanel.class);
	}

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final ToolbarPanel toolbarPanel = new ToolbarPanel();

		assertEquals("toolbarPanel", toolbarPanel.getName());

		assertEquals(GuiConstants.backgroundColor, toolbarPanel.getBackground());
		assertEquals(1, toolbarPanel.getComponentCount());
		assertIsOfTypeAndGet(CompoundBorder.class, toolbarPanel.getBorder());

		assertIsOfTypeAndGet(GridBagLayout.class, toolbarPanel.getLayout());
	}

	@Test
	public void testCropScanAreaButtonCorrectlySetupOnPanel() throws Exception {
		final ToolbarPanel toolbarPanel = new ToolbarPanel();

		final GridBagLayout toolbarPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				toolbarPanel.getLayout());

		final JButton cropScanAreaButton = assertIsOfTypeAndGet(JButton.class,
				toolbarPanel.getComponent(0));
		assertEquals("cropScanAreaButton", cropScanAreaButton.getName());
		assertEquals("Select Area To Scan", cropScanAreaButton.getToolTipText());
		assertEquals(new Dimension(20, 20), cropScanAreaButton.getPreferredSize());

		final GridBagConstraints constraints = toolbarPanelLayout
				.getConstraints(cropScanAreaButton);
		assertEquals(0, constraints.gridx);
		assertEquals(0, constraints.gridy);
		assertEquals(1.0, constraints.weightx);
		assertEquals(GridBagConstraints.WEST, constraints.anchor);
		assertEquals(new Insets(5, 5, 5, 5), constraints.insets);
	}

	@Test
	public void testCropScanAreaButtonHasCorrectImageIcon() throws Exception {
		final ToolbarPanel toolbarPanel = new ToolbarPanel();

		final JButton cropScanAreaButton = assertIsOfTypeAndGet(JButton.class,
				toolbarPanel.getComponent(0));
		assertEquals("cropScanAreaButton", cropScanAreaButton.getName());

		final ImageIcon buttonImageIcon = assertIsOfTypeAndGet(ImageIcon.class,
				cropScanAreaButton.getIcon());

		assertEquals(MediaTracker.COMPLETE, buttonImageIcon.getImageLoadStatus());
		assertEquals(this.expectedCropButtonImage.getWidth(), buttonImageIcon.getIconWidth());
		assertEquals(this.expectedCropButtonImage.getHeight(), buttonImageIcon.getIconHeight());
	}
}
