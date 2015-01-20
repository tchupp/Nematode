package com.nematode.gui.main;

import java.io.File;

import javax.swing.JFileChooser;

import org.junit.Test;

import com.nematode.fileIO.MockFileChooser;
import com.nematode.gui.MockMainWindowViewController;
import com.nematode.model.LoadedVideo;
import com.nematode.model.NullVideo;
import com.nematode.unittesting.AssertTestCase;

public class OpenVideoButtonListenerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(MainWindowActionListener.class, OpenVideoButtonListener.class);
	}

	@Test
	public void testGetsMainWindowViewControllerPassedIn() throws Exception {
		final MockMainWindowViewController mockMainWindowViewController = new MockMainWindowViewController();

		final OpenVideoButtonListener openVideoButtonListener = new OpenVideoButtonListener(
				mockMainWindowViewController, new MockFileChooser());

		assertSame(mockMainWindowViewController, openVideoButtonListener.getViewController());
	}

	@Test
	public void testGetsFileChooserPassedIn() throws Exception {
		final MockFileChooser mockFileChooser = new MockFileChooser();

		final OpenVideoButtonListener openVideoButtonListener = new OpenVideoButtonListener(
				new MockMainWindowViewController(), mockFileChooser);

		assertSame(mockFileChooser, openVideoButtonListener.getFileChooser());
	}

	@Test
	public void testActionPerformedCallsShowDialog() throws Exception {
		final MockFileChooser mockFileChooser = new MockFileChooser();

		final OpenVideoButtonListener openVideoButtonListener = new OpenVideoButtonListener(
				new MockMainWindowViewController(), mockFileChooser);

		assertFalse(mockFileChooser.wasShowDialogCalled());
		openVideoButtonListener.actionPerformed(null);
		assertTrue(mockFileChooser.wasShowDialogCalled());
	}

	@Test
	public void testActionPerformedCallsSetVideoOnViewController_ValidChoice() throws Exception {
		final MockFileChooser mockFileChooser = new MockFileChooser();
		mockFileChooser.setShowDialogValueToReturn(JFileChooser.APPROVE_OPTION);
		final File validFile = new File("testResources/Videos/shortNematode_10.avi");
		mockFileChooser.setSelectedFile(validFile);

		final MockMainWindowViewController viewController = new MockMainWindowViewController();
		final OpenVideoButtonListener openVideoButtonListener = new OpenVideoButtonListener(
				viewController, mockFileChooser);

		assertFalse(viewController.wasSetVideoCalled());
		openVideoButtonListener.actionPerformed(null);
		assertTrue(viewController.wasSetVideoCalled());

		assertIsOfTypeAndGet(LoadedVideo.class, viewController.getVideoToSet());
	}

	@Test
	public void testActionPerformedCallsSetVideoOnViewController_InvalidChoice() throws Exception {
		final MockFileChooser mockFileChooser = new MockFileChooser();
		mockFileChooser.setShowDialogValueToReturn(JFileChooser.APPROVE_OPTION);
		final File invalidFile = new File("");
		mockFileChooser.setSelectedFile(invalidFile);

		final MockMainWindowViewController viewController = new MockMainWindowViewController();
		final OpenVideoButtonListener openVideoButtonListener = new OpenVideoButtonListener(
				viewController, mockFileChooser);

		assertFalse(viewController.wasSetVideoCalled());
		openVideoButtonListener.actionPerformed(null);
		assertTrue(viewController.wasSetVideoCalled());

		assertIsOfTypeAndGet(NullVideo.class, viewController.getVideoToSet());
	}

	@Test
	public void testActionPerformedDoesntCallSetVideoIfTheDialogReturnsCancelOption()
			throws Exception {
		final MockFileChooser mockFileChooser = new MockFileChooser();
		mockFileChooser.setShowDialogValueToReturn(JFileChooser.CANCEL_OPTION);

		final MockMainWindowViewController viewController = new MockMainWindowViewController();
		final OpenVideoButtonListener openVideoButtonListener = new OpenVideoButtonListener(
				viewController, mockFileChooser);

		assertFalse(viewController.wasSetVideoCalled());
		openVideoButtonListener.actionPerformed(null);
		assertFalse(viewController.wasSetVideoCalled());
	}
}
