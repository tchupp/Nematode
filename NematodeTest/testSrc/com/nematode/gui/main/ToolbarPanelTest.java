package com.nematode.gui.main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;

import org.junit.Test;

import com.nematode.bucket.StrategyBucket;
import com.nematode.gui.ExtendableJPanel;
import com.nematode.gui.GuiConstants;
import com.nematode.gui.ImageStore;
import com.nematode.gui.ImageStoreInterface;
import com.nematode.unittesting.AssertTestCase;

public class ToolbarPanelTest extends AssertTestCase {

	@Override
	protected void setUp() throws Exception {
		final ImageStore imageStore = new ImageStore();
		StrategyBucket.setImageStore(imageStore);
	}

	@Test
	public void testExtendsJPranel() throws Exception {
		assertExtends(ExtendableJPanel.class, ToolbarPanel.class);
	}

	@Test
	public void testPanelIsCorrectlySetUp() throws Exception {
		final ToolbarPanel toolbarPanel = new ToolbarPanel();

		assertEquals("toolbarPanel", toolbarPanel.getName());

		assertEquals(GuiConstants.backgroundColor, toolbarPanel.getBackground());
		assertEquals(3, toolbarPanel.getComponentCount());
		assertTrue(toolbarPanel.isOpaque());

		assertIsOfTypeAndGet(CompoundBorder.class, toolbarPanel.getBorder());
		assertIsOfTypeAndGet(GridBagLayout.class, toolbarPanel.getLayout());
	}

	@Test
	public void testPlayButtonCorrectlySetupOnPanel() throws Exception {
		final ToolbarPanel toolbarPanel = new ToolbarPanel();

		final GridBagLayout toolbarPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				toolbarPanel.getLayout());

		final JButton playButton = assertIsOfTypeAndGet(JButton.class, toolbarPanel.getComponent(0));
		assertSame(playButton, toolbarPanel.getPlayButton());
		assertEquals("playButton", playButton.getName());
		assertEquals(new Dimension(20, 20), playButton.getPreferredSize());

		final GridBagConstraints constraints = toolbarPanelLayout.getConstraints(playButton);
		assertEquals(0, constraints.gridx);
		assertEquals(0, constraints.gridy);
		assertEquals(0.0, constraints.weightx);
		assertEquals(GridBagConstraints.WEST, constraints.anchor);
		assertEquals(new Insets(5, 5, 5, 5), constraints.insets);

		final ImageIcon imageIcon = assertIsOfTypeAndGet(ImageIcon.class, playButton.getIcon());
		final BufferedImage actualImage = assertIsOfTypeAndGet(BufferedImage.class,
				imageIcon.getImage());

		final ImageStoreInterface imageStore = StrategyBucket.getImageStore();
		assertSame(imageStore.getPlayButtonImage(), actualImage);
	}

	@Test
	public void testPauseButtonCorrectlySetupOnPanel() throws Exception {
		final ToolbarPanel toolbarPanel = new ToolbarPanel();

		final GridBagLayout toolbarPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				toolbarPanel.getLayout());

		final JButton pauseButton = assertIsOfTypeAndGet(JButton.class,
				toolbarPanel.getComponent(1));
		assertSame(toolbarPanel.getPauseButton(), pauseButton);
		assertEquals("pauseButton", pauseButton.getName());
		assertEquals(new Dimension(20, 20), pauseButton.getPreferredSize());

		final GridBagConstraints constraints = toolbarPanelLayout.getConstraints(pauseButton);
		assertEquals(1, constraints.gridx);
		assertEquals(0, constraints.gridy);
		assertEquals(0.0, constraints.weightx);
		assertEquals(GridBagConstraints.WEST, constraints.anchor);
		assertEquals(new Insets(5, 5, 5, 5), constraints.insets);

		final ImageIcon imageIcon = assertIsOfTypeAndGet(ImageIcon.class, pauseButton.getIcon());
		final BufferedImage actualImage = assertIsOfTypeAndGet(BufferedImage.class,
				imageIcon.getImage());

		final ImageStoreInterface imageStore = StrategyBucket.getImageStore();
		assertSame(imageStore.getPauseButtonImage(), actualImage);
	}

	@Test
	public void testStopButtonCorrectlySetupOnPanel() throws Exception {
		final ToolbarPanel toolbarPanel = new ToolbarPanel();

		final GridBagLayout toolbarPanelLayout = assertIsOfTypeAndGet(GridBagLayout.class,
				toolbarPanel.getLayout());

		final JButton stopButton = assertIsOfTypeAndGet(JButton.class, toolbarPanel.getComponent(2));
		assertSame(toolbarPanel.getStopButton(), stopButton);
		assertEquals("stopButton", stopButton.getName());
		assertEquals(new Dimension(20, 20), stopButton.getPreferredSize());

		final GridBagConstraints constraints = toolbarPanelLayout.getConstraints(stopButton);
		assertEquals(2, constraints.gridx);
		assertEquals(0, constraints.gridy);
		assertEquals(1.0, constraints.weightx);
		assertEquals(GridBagConstraints.WEST, constraints.anchor);
		assertEquals(new Insets(5, 5, 5, 5), constraints.insets);

		final ImageIcon imageIcon = assertIsOfTypeAndGet(ImageIcon.class, stopButton.getIcon());
		final BufferedImage actualImage = assertIsOfTypeAndGet(BufferedImage.class,
				imageIcon.getImage());

		final ImageStoreInterface imageStore = StrategyBucket.getImageStore();
		assertSame(imageStore.getStopButtonImage(), actualImage);
	}
}
