package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
	@Test
	public void whenExit() {
		Output out = new StubOutput();
		Input in = new StubInput(
				new String[]{"0"}
		);
		Tracker tracker = new Tracker();
		UserAction[] actions = {
				new ExitAppAction(out)
		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(out.toString(), is(
				"Menu." + System.lineSeparator()
				+ "0. Exit Program" + System.lineSeparator()
				+ "--- Goodbye!---" + System.lineSeparator()
		));
	}

	@Test
	public void whenCreate() {
		Output out = new StubOutput();
		Input in = new StubInput(
				new String[]{"0", "Andrey", "1"}
		);
		Tracker tracker = new Tracker();
		UserAction[] actions = {
				new CreateAction(out),
				new ExitAppAction(out)
		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(out.toString(), is(
				"Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Exit Program" + System.lineSeparator()
						+ "=== Create a new Item ====" + System.lineSeparator()
						+ "Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Exit Program" + System.lineSeparator()
						+ "--- Goodbye!---" + System.lineSeparator()
		));
	}

	@Test
	public void whenFindAllAction() {
		Output out = new StubOutput();
		Input in = new StubInput(
				new String[]{"0", "Andrey", "1", "2"}
		);
		Tracker tracker = new Tracker();
		UserAction[] actions = {
				new CreateAction(out),
				new ShowAllAction(out),
				new ExitAppAction(out)
		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(out.toString(), is(
				"Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Show all items" + System.lineSeparator()
						+ "2. Exit Program" + System.lineSeparator()
						+ "=== Create a new Item ====" + System.lineSeparator()
						+ "Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Show all items" + System.lineSeparator()
						+ "2. Exit Program" + System.lineSeparator()
						+ "1 - Andrey" + System.lineSeparator()
						+ "Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Show all items" + System.lineSeparator()
						+ "2. Exit Program" + System.lineSeparator()
						+ "--- Goodbye!---" + System.lineSeparator()
		));
	}

	@Test
	public void whenFindByNameAction() {
		Output out = new StubOutput();
		Input in = new StubInput(
				new String[]{"0", "Andrey", "1", "Andrey", "2"}
		);
		Tracker tracker = new Tracker();
		UserAction[] actions = {
				new CreateAction(out),
				new FindByNameAction(out),
				new ExitAppAction(out)
		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(out.toString(), is(
				"Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Find items by name" + System.lineSeparator()
						+ "2. Exit Program" + System.lineSeparator()
						+ "=== Create a new Item ====" + System.lineSeparator()
						+ "Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Find items by name" + System.lineSeparator()
						+ "2. Exit Program" + System.lineSeparator()
						+ "1 - Andrey" + System.lineSeparator()
						+ "Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Find items by name" + System.lineSeparator()
						+ "2. Exit Program" + System.lineSeparator()
						+ "--- Goodbye!---" + System.lineSeparator()
		));
	}

	@Test
	public void whenFindByNameActionFail() {
		Output out = new StubOutput();
		Input in = new StubInput(
				new String[]{"0", "Andrey", "1", "Andre", "2"}
		);
		Tracker tracker = new Tracker();
		UserAction[] actions = {
				new CreateAction(out),
				new FindByNameAction(out),
				new ExitAppAction(out)
		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(out.toString(), is(
				"Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Find items by name" + System.lineSeparator()
						+ "2. Exit Program" + System.lineSeparator()
						+ "=== Create a new Item ====" + System.lineSeparator()
						+ "Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Find items by name" + System.lineSeparator()
						+ "2. Exit Program" + System.lineSeparator()
						+ "Заявки с таким именем не найдены" + System.lineSeparator()
						+ "Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Find items by name" + System.lineSeparator()
						+ "2. Exit Program" + System.lineSeparator()
						+ "--- Goodbye!---" + System.lineSeparator()
		));
	}

	@Test
	public void whenFindByIdAction() {
		Output out = new StubOutput();
		Input in = new StubInput(
				new String[]{"0", "Andrey", "1", "1", "2"}
		);
		Tracker tracker = new Tracker();
		UserAction[] actions = {
				new CreateAction(out),
				new FindByIdAction(out),
				new ExitAppAction(out)
		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(out.toString(), is(
				"Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Find item by Id" + System.lineSeparator()
						+ "2. Exit Program" + System.lineSeparator()
						+ "=== Create a new Item ====" + System.lineSeparator()
						+ "Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Find item by Id" + System.lineSeparator()
						+ "2. Exit Program" + System.lineSeparator()
						+ "1 - Andrey" + System.lineSeparator()
						+ "Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Find item by Id" + System.lineSeparator()
						+ "2. Exit Program" + System.lineSeparator()
						+ "--- Goodbye!---" + System.lineSeparator()
		));
	}

	@Test
	public void whenFindByIdActionFail() {
		Output out = new StubOutput();
		Input in = new StubInput(
				new String[]{"0", "Andrey", "1", "2", "2"}
		);
		Tracker tracker = new Tracker();
		UserAction[] actions = {
				new CreateAction(out),
				new FindByIdAction(out),
				new ExitAppAction(out)
		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(out.toString(), is(
				"Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Find item by Id" + System.lineSeparator()
						+ "2. Exit Program" + System.lineSeparator()
						+ "=== Create a new Item ====" + System.lineSeparator()
						+ "Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Find item by Id" + System.lineSeparator()
						+ "2. Exit Program" + System.lineSeparator()
						+ "Заявка с таким id не найдена" + System.lineSeparator()
						+ "Menu." + System.lineSeparator()
						+ "0. Add new Item" + System.lineSeparator()
						+ "1. Find item by Id" + System.lineSeparator()
						+ "2. Exit Program" + System.lineSeparator()
						+ "--- Goodbye!---" + System.lineSeparator()
		));
	}

	@Test
	public void whenInvalidExit() {
		Output out = new StubOutput();
		Input in = new StubInput(
				new String[]{"1", "0"}
		);
		Tracker tracker = new Tracker();
		UserAction[] actions = {
				new ExitAppAction(out)
		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(out.toString(), is(
				String.format(
						"Menu.%n"
								+ "0. Exit Program%n"
								+ "Wrong input, you can select: 0 .. 0%n"
								+ "Menu.%n"
								+ "0. Exit Program%n"
								+ "--- Goodbye!---%n"
				)
		));
	}
}
