package com.nematode.gui.main;

import java.awt.event.ActionListener;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class MainWindowActionListenerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ActionListener.class, MainWindowActionListener.class);
	}

}
