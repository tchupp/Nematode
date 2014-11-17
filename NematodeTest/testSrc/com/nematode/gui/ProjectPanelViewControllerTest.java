package com.nematode.gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.junit.Test;

import com.nematode.fileIO.ImageFileChooser;
import com.nematode.fileIO.MockVideoFrameAssembler;
import com.nematode.fileIO.VideoFileChooser;
import com.nematode.model.MockVideoInfoMatriarch;
import com.nematode.unittesting.AssertTestCase;

public class ProjectPanelViewControllerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ProjectPanelViewControllerInterface.class,
				ProjectPanelViewController.class);
	}

	@Test
	public void testGetsNematodeProjectPanel() throws Exception {
		final ProjectPanelViewController projectViewController = new ProjectPanelViewController(
				new MockVideoInfoMatriarch());

		assertIsOfTypeAndGet(ProjectPanel.class, projectViewController.getProjectPanel());
	}

	@Test
	public void testGetsVideoInfoMatriarch() throws Exception {
		final MockVideoInfoMatriarch videoInfoMatriarch = new MockVideoInfoMatriarch();
		final ProjectPanelViewController projectPanelViewController = new ProjectPanelViewController(
				videoInfoMatriarch);

		assertSame(videoInfoMatriarch, projectPanelViewController.getVideoInfoMatriarch());
	}

	@Test
	public void testConstructionAddsCorrectListener_OpenImageButtonOnPanel() throws Exception {
		final MockVideoFrameAssembler mockVideoFrameAssembler = new MockVideoFrameAssembler();
		final MockVideoInfoMatriarch videoInfoMatriarch = new MockVideoInfoMatriarch();
		videoInfoMatriarch.setVideoFrameSequence(mockVideoFrameAssembler);

		final ProjectPanelViewController projectPanelViewController = new ProjectPanelViewController(
				videoInfoMatriarch);

		final ProjectPanel projectPanel = assertIsOfTypeAndGet(ProjectPanel.class,
				projectPanelViewController.getProjectPanel());

		final JButton openImageButton = projectPanel.getOpenImageButton();

		final ActionListener[] actionListeners = openImageButton.getActionListeners();
		assertEquals(1, actionListeners.length);

		final OpenImageButtonActionListener openImageActionListener = assertIsOfTypeAndGet(
				OpenImageButtonActionListener.class, actionListeners[0]);

		assertSame(mockVideoFrameAssembler, openImageActionListener.getVideoFrameAssembler());

		assertIsOfTypeAndGet(ImageFileChooser.class, openImageActionListener.getFileChooser());
	}

	@Test
	public void testConstructionAddsCorrectListener_OpenVideoButtonOnPanel() throws Exception {
		final ProjectPanelViewController projectPanelViewController = new ProjectPanelViewController(
				new MockVideoInfoMatriarch());

		final ProjectPanel projectPanel = assertIsOfTypeAndGet(ProjectPanel.class,
				projectPanelViewController.getProjectPanel());

		final JButton openVideoButton = projectPanel.getOpenVideoButton();

		final ActionListener[] actionListeners = openVideoButton.getActionListeners();
		assertEquals(1, actionListeners.length);

		final OpenVideoButtonActionListener openVideoActionListener = assertIsOfTypeAndGet(
				OpenVideoButtonActionListener.class, actionListeners[0]);

		assertIsOfTypeAndGet(VideoFileChooser.class, openVideoActionListener.getFileChooser());
	}
}
