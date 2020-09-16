package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
	@Test
	public void whenAddItem() {
		String[] answers = {"Fix PC"};
		Input input = new StubInput(answers);
		Tracker tracker = new Tracker();
		StartUI.createItem(input, tracker);
		Item created = tracker.findAll()[0];
		Item expected = new Item("Fix PC");
		assertThat(created.getName(), is(expected.getName()));
	}

	@Test
	public void whenReplaceItem() {
		String[] answers = {"Fix PC"};
		Input input = new StubInput(answers);
		Tracker tracker = new Tracker();
		StartUI.createItem(input, tracker);
		answers[0] = "New PC";
		StartUI.replaceItem(1, answers[0], tracker);
		Item created = tracker.findAll()[0];
		Item expected = new Item("New PC");
		assertThat(created.getName(), is(expected.getName()));
	}

}
