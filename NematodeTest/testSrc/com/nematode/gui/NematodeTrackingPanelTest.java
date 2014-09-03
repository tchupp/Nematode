package com.nematode.gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeTrackingPanelTest extends AssertTestCase {

	@Test
	public void testExtendsJFrame() throws Exception {
		final NematodeTrackingPanel nematodeTrackingPanel = new NematodeTrackingPanel();
		assertExtends(JPanel.class, nematodeTrackingPanel.getClass());
	}

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final NematodeTrackingPanel nematodeTrackingPanel = new NematodeTrackingPanel();
		assertEquals(1, nematodeTrackingPanel.getComponentCount());
		assertIsOfTypeAndGet(CompoundBorder.class,
				nematodeTrackingPanel.getBorder());
	}

	@Test
	public void testScanButton() throws Exception {
		final NematodeTrackingPanel nematodeTrackingPanel = new NematodeTrackingPanel();
		final JButton scanButtonFromIOTAG = assertIsOfTypeAndGet(JButton.class,
				nematodeTrackingPanel.getComponent(0));
		final JButton scanButtonFromGetter = nematodeTrackingPanel
				.getScanButton();
		assertSame(scanButtonFromGetter, scanButtonFromIOTAG);
		assertEquals("scanButton", scanButtonFromIOTAG.getName());
		assertEquals("Scan Image", scanButtonFromIOTAG.getText());
	}
}
