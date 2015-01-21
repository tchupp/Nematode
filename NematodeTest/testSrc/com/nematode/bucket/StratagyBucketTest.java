package com.nematode.bucket;

import org.junit.Test;

import com.nematode.gui.console.EventMessageStoreInterface;
import com.nematode.gui.console.MockEventMessageStore;
import com.nematode.unittesting.AssertTestCase;

public class StratagyBucketTest extends AssertTestCase {

	@Test
	public void testConstructorIsPrivate() throws Exception {
		assertConstructorIsPrivate(StratagyBucket.class);
	}

	@Test
	public void testGetEventMessageStoreAlwaysReturnsTheSameObject() throws Exception {
		final EventMessageStoreInterface eventMessageStoreOne = StratagyBucket
				.getEventMessageStore();
		final EventMessageStoreInterface eventMessageStoreTwo = StratagyBucket
				.getEventMessageStore();

		assertSame(eventMessageStoreOne, eventMessageStoreTwo);
	}

	@Test
	public void testSetEventMessageStoreSetsCorrectObject() throws Exception {
		final MockEventMessageStore mockEventMessageStore = new MockEventMessageStore();

		assertNotSame(mockEventMessageStore, StratagyBucket.getEventMessageStore());
		StratagyBucket.setEventMessageStore(mockEventMessageStore);
		assertSame(mockEventMessageStore, StratagyBucket.getEventMessageStore());
	}
}
