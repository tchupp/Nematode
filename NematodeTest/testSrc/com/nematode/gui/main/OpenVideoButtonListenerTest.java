package com.nematode.gui.main;

import org.junit.Test;

import com.nematode.fileIO.MockFileChooser;
import com.nematode.gui.MockMainWindowViewController;
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

}
