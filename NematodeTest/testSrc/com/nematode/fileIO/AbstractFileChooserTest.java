package com.nematode.fileIO;

import javax.swing.JFileChooser;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class AbstractFileChooserTest extends AssertTestCase {

	@Test
	public void testExtendsFileChooser() throws Exception {
		assertExtends(JFileChooser.class, AbstractFileChooser.class);
	}

}
