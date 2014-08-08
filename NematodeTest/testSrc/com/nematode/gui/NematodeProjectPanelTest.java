package com.nematode.gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeProjectPanelTest extends AssertTestCase {

	@Test
	public void testExtendsJPanel() throws Exception {
		final NematodeProjectPanel nematodeProjectPanel = new NematodeProjectPanel();
		assertExtends(JPanel.class, nematodeProjectPanel.getClass());
	}

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final NematodeProjectPanel nematodeProjectPanel = new NematodeProjectPanel();

		assertIsOfTypeAndGet(CompoundBorder.class,
				nematodeProjectPanel.getBorder());

		assertEquals(1, nematodeProjectPanel.getComponents().length);

		final JButton openImageButton = assertIsOfTypeAndGet(JButton.class,
				nematodeProjectPanel.getComponent(0));
		assertEquals("openImageButton", openImageButton.getName());
		assertEquals("Open Image", openImageButton.getText());
	}

}
