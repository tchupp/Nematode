package com.nematode.bucket;

import org.junit.Test;

import com.nematode.gui.MockImageStore;
import com.nematode.gui.console.EventMessageStoreInterface;
import com.nematode.gui.console.MockEventMessageStore;
import com.nematode.unittesting.AssertTestCase;

public class StrategyBucketTest extends AssertTestCase {

	@Override
	protected void setUp() throws Exception {
		StrategyBucket.setImageStore(null);
	}

	@Test
	public void testConstructorIsPrivate() throws Exception {
		assertConstructorIsPrivate(StrategyBucket.class);
	}

	@Test
	public void testGetEventMessageStoreAlwaysReturnsTheSameObject() throws Exception {
		final EventMessageStoreInterface eventMessageStoreOne = StrategyBucket
				.getEventMessageStore();
		final EventMessageStoreInterface eventMessageStoreTwo = StrategyBucket
				.getEventMessageStore();

		assertSame(eventMessageStoreOne, eventMessageStoreTwo);
	}

	@Test
	public void testSetEventMessageStoreSetsCorrectObject() throws Exception {
		final MockEventMessageStore mockEventMessageStore = new MockEventMessageStore();

		assertNotSame(mockEventMessageStore, StrategyBucket.getEventMessageStore());
		StrategyBucket.setEventMessageStore(mockEventMessageStore);
		assertSame(mockEventMessageStore, StrategyBucket.getEventMessageStore());
	}

	@Test
	public void testImageStoreStartsNull_GetImageStoreReturnsSetObject() throws Exception {
		final MockImageStore mockImageStore = new MockImageStore();

		assertNull(StrategyBucket.getImageStore());

		StrategyBucket.setImageStore(mockImageStore);

		assertSame(mockImageStore, StrategyBucket.getImageStore());
	}
}
