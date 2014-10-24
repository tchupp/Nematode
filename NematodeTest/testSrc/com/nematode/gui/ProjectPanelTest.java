package com.nematode.gui;

import javax.swing.JButton;
import javax.swing.border.CompoundBorder;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ProjectPanelTest extends AssertTestCase {

	@Test
	public void testExtendsNematodePanel() throws Exception {
		assertExtends(ExtendableJPanel.class, ProjectPanel.class);
	}

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final ProjectPanel projectPanel = new ProjectPanel();

		assertEquals(1, projectPanel.getComponents().length);
		assertIsOfTypeAndGet(CompoundBorder.class,
				projectPanel.getBorder());
	}

	@Test
	public void testGetOpenImageButton() throws Exception {
		final ProjectPanel projectPanel = new ProjectPanel();

		final JButton openImageButtonFromIOTAG = assertIsOfTypeAndGet(
				JButton.class, projectPanel.getComponent(0));
		final JButton openImageButtonFromGetter = projectPanel
				.getOpenImageButton();
		assertSame(openImageButtonFromGetter, openImageButtonFromIOTAG);
		assertEquals("openImageButton", openImageButtonFromIOTAG.getName());
		assertEquals("Open Image", openImageButtonFromIOTAG.getText());
	}
}
