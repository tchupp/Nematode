package com.nematode.gui.console;

import java.util.ArrayList;

import org.junit.Test;

import com.nematode.gui.console.EventMessageStore;
import com.nematode.gui.console.StatusMessage;
import com.nematode.unittesting.AssertTestCase;

public class EventMessageStoreTest extends AssertTestCase {

	@Test
	public void testGetsEmptyMessageList_AfterConstruction() throws Exception {
		final EventMessageStore eventMessageStore = new EventMessageStore();

		final ArrayList<StatusMessage> messageList = eventMessageStore.getMessageList();
		assertTrue(messageList.isEmpty());
	}

	@Test
	public void testAddMessageCorrectlyAddsMessageToMessageList() throws Exception {
		final EventMessageStore eventMessageStore = new EventMessageStore();
		final ArrayList<StatusMessage> messageList = eventMessageStore.getMessageList();
		assertEquals(0, messageList.size());
		eventMessageStore.addMessage(StatusMessage.VIDEO_LOADED);
		assertEquals(1, messageList.size());

		assertEquals(StatusMessage.VIDEO_LOADED, messageList.get(0));

		eventMessageStore.addMessage(StatusMessage.VIDEO_LOADED_ERROR);
		assertEquals(2, messageList.size());

		assertEquals(StatusMessage.VIDEO_LOADED_ERROR, messageList.get(1));

	}

	@Test
	public void testGetLastMessageCorrectlyReturnsLastMessage() throws Exception {
		final EventMessageStore eventMessageStore = new EventMessageStore();
		eventMessageStore.addMessage(StatusMessage.VIDEO_LOADED);

		assertEquals(StatusMessage.VIDEO_LOADED, eventMessageStore.getLastMessage());

		eventMessageStore.addMessage(StatusMessage.VIDEO_LOADED_ERROR);

		assertEquals(StatusMessage.VIDEO_LOADED_ERROR, eventMessageStore.getLastMessage());

	}
}
