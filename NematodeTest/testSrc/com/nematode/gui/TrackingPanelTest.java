package com.nematode.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.border.CompoundBorder;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class TrackingPanelTest extends AssertTestCase {

	@Test
	public void testExtendsJFrame() throws Exception {
		assertExtends(ExtendableJPanel.class, TrackingPanel.class);
	}

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final TrackingPanel trackingPanel = new TrackingPanel();

		assertEquals("trackingPanel", trackingPanel.getName());

		assertEquals(GuiConstants.backgroundColor, trackingPanel.getBackground());
		assertEquals(1, trackingPanel.getComponentCount());
		assertIsOfTypeAndGet(CompoundBorder.class, trackingPanel.getBorder());

		assertIsOfTypeAndGet(GridBagLayout.class, trackingPanel.getLayout());
	}

	@Test
	public void testScanButtonCorrectlySetUp() throws Exception {
		final TrackingPanel trackingPanel = new TrackingPanel();

		final GridBagLayout trackingPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				trackingPanel.getLayout());

		final JButton scanButton = assertIsOfTypeAndGet(JButton.class,
				trackingPanel.getComponent(0));
		assertEquals("beginScanButton", scanButton.getName());
		assertEquals("Begin Scan", scanButton.getText());

		final GridBagConstraints scanButtonConstraints = trackingPanelLayout
				.getConstraints(scanButton);
		assertEquals(0, scanButtonConstraints.gridx);
		assertEquals(0, scanButtonConstraints.gridy);
		assertEquals(1.0, scanButtonConstraints.weighty);
		assertEquals(GridBagConstraints.HORIZONTAL, scanButtonConstraints.fill);
		assertEquals(GridBagConstraints.NORTH, scanButtonConstraints.anchor);
		assertEquals(new Insets(5, 5, 5, 5), scanButtonConstraints.insets);
	}

	@Test
	public void testGetBeginScanButton() throws Exception {
		final TrackingPanel trackingPanel = new TrackingPanel();

		final JButton scanButtonFromIOTAG = assertIsOfTypeAndGet(JButton.class,
				trackingPanel.getComponent(0));
		final JButton scanButtonFromGetter = trackingPanel.getBeginScanButton();

		assertSame(scanButtonFromGetter, scanButtonFromIOTAG);
	}
}
