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
		final JButton scanButton = assertIsOfTypeAndGet(JButton.class,
				nematodeTrackingPanel.getComponent(0));
		assertEquals("scanButton", scanButton.getName());
		assertEquals("Scan Image", scanButton.getText());
	}
}
