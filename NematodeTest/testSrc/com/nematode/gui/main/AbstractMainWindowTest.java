package com.nematode.gui.main;

import org.junit.Test;

import com.nematode.gui.ExtendableJFrame;
import com.nematode.unittesting.AssertTestCase;

public class AbstractMainWindowTest extends AssertTestCase {

	@Test
	public void testExtendsClass() throws Exception {
		assertExtends(ExtendableJFrame.class, AbstractMainWindow.class);
	}

}
