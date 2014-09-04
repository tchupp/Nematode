package com.nematode.gui;

import javax.swing.JButton;
import javax.swing.border.CompoundBorder;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeProjectPanelTest extends AssertTestCase {

	@Test
	public void testExtendsJPanel() throws Exception {
		assertExtends(NematodePanel.class, NematodeProjectPanel.class);
	}

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final NematodeProjectPanel nematodeProjectPanel = new NematodeProjectPanel();

		assertEquals(1, nematodeProjectPanel.getComponents().length);
		assertIsOfTypeAndGet(CompoundBorder.class,
				nematodeProjectPanel.getBorder());
	}

	@Test
	public void testGetOpenImageButton() throws Exception {
		final NematodeProjectPanel nematodeProjectPanel = new NematodeProjectPanel();

		final JButton openImageButtonFromIOTAG = assertIsOfTypeAndGet(
				JButton.class, nematodeProjectPanel.getComponent(0));
		final JButton openImageButtonFromGetter = nematodeProjectPanel
				.getOpenImageButton();
		assertSame(openImageButtonFromGetter, openImageButtonFromIOTAG);
		assertEquals("openImageButton", openImageButtonFromIOTAG.getName());
		assertEquals("Open Image", openImageButtonFromIOTAG.getText());
	}
}
