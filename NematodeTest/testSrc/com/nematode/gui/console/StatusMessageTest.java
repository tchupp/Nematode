package com.nematode.gui.console;

import org.junit.Test;

import com.nematode.gui.console.StatusMessage;
import com.nematode.unittesting.AssertTestCase;

public class StatusMessageTest extends AssertTestCase {

	@Test
	public void testStatusMessages() throws Exception {
		assertEquals("Video correctly loaded.", StatusMessage.VIDEO_LOADED.toString());
		assertEquals("Error loading video.", StatusMessage.VIDEO_LOADED_ERROR.toString());

	}

}
