package com.nematode.gui;

import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class StatusPanelTest extends AssertTestCase {

	@Test
	public void testExtendsJPanel() throws Exception {
		assertExtends(ExtendableJPanel.class, StatusPanel.class);
	}

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final StatusPanel statusPanel = new StatusPanel();

		assertEquals("statusPanel", statusPanel.getName());

		assertEquals(GuiConstants.backgroundColor, statusPanel.getBackground());
		assertEquals(1, statusPanel.getComponentCount());
		assertTrue(statusPanel.isOpaque());

		assertIsOfTypeAndGet(CompoundBorder.class, statusPanel.getBorder());
	}

	@Test
	public void testStatusLabelIsSetupCorrectly() throws Exception {
		final StatusPanel statusPanel = new StatusPanel();

		final JLabel statusLabelFromIOTAG = assertIsOfTypeAndGet(JLabel.class,
				statusPanel.getComponent(0));
		final JLabel statusLabelFromGetter = statusPanel.getStatusLabel();

		assertSame(statusLabelFromGetter, statusLabelFromIOTAG);
		assertEquals("statusLabel", statusLabelFromIOTAG.getName());
		assertEquals("", statusLabelFromIOTAG.getText());
	}
}
