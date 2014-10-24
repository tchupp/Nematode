package com.nematode.gui;

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

		assertEquals(1, trackingPanel.getComponentCount());
		assertIsOfTypeAndGet(CompoundBorder.class, trackingPanel.getBorder());
	}

	@Test
	public void testScanButton() throws Exception {
		final TrackingPanel trackingPanel = new TrackingPanel();

		final JButton scanButtonFromIOTAG = assertIsOfTypeAndGet(JButton.class,
				trackingPanel.getComponent(0));
		final JButton scanButtonFromGetter = trackingPanel.getScanButton();
		assertSame(scanButtonFromGetter, scanButtonFromIOTAG);
		assertEquals("scanButton", scanButtonFromIOTAG.getName());
		assertEquals("Scan Image", scanButtonFromIOTAG.getText());
	}
}
