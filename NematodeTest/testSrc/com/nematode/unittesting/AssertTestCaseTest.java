package com.nematode.unittesting;

import junit.framework.TestCase;

import org.junit.Test;

public class AssertTestCaseTest extends AssertTestCase {

	@Test
	public void testExtendsTestCase() throws Exception {
		assertExtends(TestCase.class, AssertTestCase.class);
	}
}
