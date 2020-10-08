package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

	@Test
	public void whenInvalidInput() {
		Output out = new StubOutput();
		List<String> testData = new ArrayList<String>();
		testData.add("one");
		testData.add("1");
		Input in = new StubInput(testData);
		ValidateInput input = new ValidateInput(out, in);
		int selected = input.askInt("Enter menu:");
		assertThat(selected, is(1));
	}

	@Test
	public void whenValidInput() {
		Output out = new StubOutput();
		List<String> testData = new ArrayList<String>();
		testData.add("1");
		testData.add("2");
		Input in = new StubInput(testData);
		ValidateInput input = new ValidateInput(out, in);
		int selected = input.askInt("Enter menu:");
		assertThat(selected, is(1));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void whenInvalidInputException() {
		Output output = new StubOutput();
		List<String> testData = new ArrayList<String>();
		testData.add("one");
		Input in = new StubInput(testData);
		Input input = new ValidateInput(output, in);
		input.askInt("test");
	}

	@Test
	public void whenInvalidInputThenMessageError() {
		Output output = new StubOutput();
		List<String> testData = new ArrayList<String>();
		testData.add("one");
		testData.add("1");
		Input in = new StubInput(testData);
		Input input = new ValidateInput(output, in);
		input.askInt("test");
		assertThat(output.toString(), is("Please enter validate data again."
				+ System.lineSeparator()));

	}
}
