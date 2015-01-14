package com.nematode.bucket;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class BucketTest extends AssertTestCase {

	@Test
	public void testNoPublicConstructors() throws Exception {
		assertConstructorIsPrivate(Bucket.class);
	}

	@Test
	public void testSingleton() throws Exception {
		final Bucket singletonOne = Bucket.SINGLETON;
		final Bucket singletonTwo = Bucket.SINGLETON;

		assertSame(singletonOne, singletonTwo);
	}
}
