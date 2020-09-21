package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

	@Test
	public void whenInvalidInput() {
		Output out = new StubOutput();
		Input in = new StubInput(
				new String[] {"one", "1"}
		);
		ValidateInput input = new ValidateInput(out, in);
		int selected = input.askInt("Enter menu:");
		assertThat(selected, is(1));
	}

	@Test
	public void whenValidInput() {
		Output out = new StubOutput();
		Input in = new StubInput(
				new String[] {"1", "2"}
		);
		ValidateInput input = new ValidateInput(out, in);
		int selected = input.askInt("Enter menu:");
		assertThat(selected, is(1));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void whenInvalidInputException() {
		Output output = new StubOutput();
		Input in = new StubInput(
				new String[] {"one"}
		);
		Input input = new ValidateInput(output, in);
		input.askInt("test");
	}

	@Test
	public void whenInvalidInputThenMessageError() {
		Output output = new StubOutput();
		Input in = new StubInput(
				new String[] {"one", "1"}
		);
		Input input = new ValidateInput(output, in);
		input.askInt("test");
		assertThat(output.toString(), is("Please enter validate data again." + System.lineSeparator()));

	}
}
