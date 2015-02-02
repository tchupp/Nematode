package com.nematode.gui.main;

import java.awt.event.ActionListener;

import org.junit.Test;

import com.nematode.gui.AbstractTimer;
import com.nematode.gui.MockActionListener;
import com.nematode.unittesting.AssertTestCase;

public class PlayVideoTimerTest extends AssertTestCase {

	@Test
	public void testExtendsTimer() throws Exception {
		assertExtends(AbstractTimer.class, PlayVideoTimer.class);
	}

	@Test
	public void testGetsDelayPassedIn() throws Exception {
		final PlayVideoTimer playVideoTimerOne = new PlayVideoTimer(100, new MockActionListener());
		assertEquals(100, playVideoTimerOne.getDelay());

		final PlayVideoTimer playVideoTimerTwo = new PlayVideoTimer(200, new MockActionListener());
		assertEquals(200, playVideoTimerTwo.getDelay());
	}

	@Test
	public void testGetsActionListenerPassedIn() throws Exception {
		final MockActionListener mockActionListener = new MockActionListener();
		final PlayVideoTimer playVideoTimer = new PlayVideoTimer(100, mockActionListener);

		final ActionListener[] actionListeners = playVideoTimer.getActionListeners();
		assertEquals(1, actionListeners.length);
		assertSame(mockActionListener, actionListeners[0]);
	}
}
