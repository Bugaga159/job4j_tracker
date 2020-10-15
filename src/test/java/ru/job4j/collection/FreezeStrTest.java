package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class FreezeStrTest {
	@Test
	public void whenEq() {
		assertThat(FreezeStr.eq("Hello", "Hlloe"), is(true));
	}

	@Test
	public void whenNotEq() {
		assertThat(FreezeStr.eq("Hello", "Halle"), is(false));
	}

	@Test
	public void whenNotMultiEq() {
		assertThat(FreezeStr.eq("heloo", "hello"), is(false));
	}

	@Test
	public void whenEmptyStringEq() {
		assertThat(FreezeStr.eq("", "hello"), is(false));
	}

	@Test
	public void wheneqWithHashMap() {
		assertThat(FreezeStr.eqWithHashMap("Hello", "Hlloe"), is(true));
	}

	@Test
	public void whenNoteqWithHashMap() {
		assertThat(FreezeStr.eqWithHashMap("Hello", "Halle"), is(false));
	}

	@Test
	public void whenNotMultieqWithHashMap() {
		assertThat(FreezeStr.eqWithHashMap("heloo", "hello"), is(false));
	}

	@Test
	public void whenEmptyStringeqWithHashMap() {
		assertThat(FreezeStr.eqWithHashMap("", "hello"), is(false));
	}
}