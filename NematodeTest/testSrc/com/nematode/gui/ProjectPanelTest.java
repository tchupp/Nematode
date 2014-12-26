package com.nematode.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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

		assertEquals("projectPanel", projectPanel.getName());

		assertEquals(GuiConstants.backgroundColor, projectPanel.getBackground());
		assertEquals(2, projectPanel.getComponentCount());
		assertIsOfTypeAndGet(CompoundBorder.class, projectPanel.getBorder());

		assertIsOfTypeAndGet(GridBagLayout.class, projectPanel.getLayout());

	}

	@Test
	public void testOpenImageButtonCorrectlySetup() throws Exception {
		final ProjectPanel projectPanel = new ProjectPanel();

		final GridBagLayout projectPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				projectPanel.getLayout());

		final JButton openImageButton = assertIsOfTypeAndGet(JButton.class,
				projectPanel.getComponent(0));
		assertEquals("openImageButton", openImageButton.getName());
		assertEquals("Open Image", openImageButton.getText());

		final GridBagConstraints openImageButtonConstraints = projectPanelLayout
				.getConstraints(openImageButton);

		assertEquals(0, openImageButtonConstraints.gridx);
		assertEquals(0, openImageButtonConstraints.gridy);
		assertEquals(0.0, openImageButtonConstraints.weighty);
		assertEquals(GridBagConstraints.NORTH, openImageButtonConstraints.anchor);
		assertEquals(GridBagConstraints.HORIZONTAL, openImageButtonConstraints.fill);
		assertEquals(new Insets(5, 5, 5, 5), openImageButtonConstraints.insets);
	}

	@Test
	public void testGetOpenImageButton() throws Exception {
		final ProjectPanel projectPanel = new ProjectPanel();

		final JButton openImageButtonFromIOTAG = assertIsOfTypeAndGet(JButton.class,
				projectPanel.getComponent(0));
		final JButton openImageButtonFromGetter = projectPanel.getOpenImageButton();
		assertSame(openImageButtonFromGetter, openImageButtonFromIOTAG);
	}

	@Test
	public void testOpenVideoButtonCorrectlySetup() throws Exception {
		final ProjectPanel projectPanel = new ProjectPanel();

		final GridBagLayout projectPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				projectPanel.getLayout());

		final JButton openVideoButton = assertIsOfTypeAndGet(JButton.class,
				projectPanel.getComponent(1));
		assertEquals("openVideoButton", openVideoButton.getName());
		assertEquals("Open Video", openVideoButton.getText());

		final GridBagConstraints openVideoButtonConstraints = projectPanelLayout
				.getConstraints(openVideoButton);

		assertEquals(0, openVideoButtonConstraints.gridx);
		assertEquals(1, openVideoButtonConstraints.gridy);
		assertEquals(1.0, openVideoButtonConstraints.weighty);
		assertEquals(GridBagConstraints.NORTH, openVideoButtonConstraints.anchor);
		assertEquals(GridBagConstraints.HORIZONTAL, openVideoButtonConstraints.fill);
		assertEquals(new Insets(5, 5, 5, 5), openVideoButtonConstraints.insets);
	}

	@Test
	public void testGetOpenVideoButton() throws Exception {
		final ProjectPanel projectPanel = new ProjectPanel();

		final JButton openVideoButtonFromIOTAG = assertIsOfTypeAndGet(JButton.class,
				projectPanel.getComponent(1));
		final JButton openVideoButtonFromGetter = projectPanel.getOpenVideoButton();
		assertSame(openVideoButtonFromGetter, openVideoButtonFromIOTAG);
	}
}
