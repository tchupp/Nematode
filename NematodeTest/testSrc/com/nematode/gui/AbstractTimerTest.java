package com.nematode.gui;

import javax.swing.Timer;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class AbstractTimerTest extends AssertTestCase {

	@Test
	public void testExtendsTimer() throws Exception {
		assertExtends(Timer.class, AbstractTimer.class);
	}
}
