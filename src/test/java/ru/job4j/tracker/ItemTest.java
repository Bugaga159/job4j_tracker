package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ItemTest {
	@Test
	public void sortByNameAsc() {
		List<Item> item = Arrays.asList(
				new Item(1, "Andrey"),
				new Item(3, "Petr"),
				new Item(5, "Ivan")
		);
		Item[] expected = {new Item(1, "Andrey"),
				new Item(5, "Ivan"),
				new Item(3, "Petr")};
		Collections.sort(item, new SortByNameItemASC());
		assertThat(item.toArray(), is(expected));
	}

	@Test
	public void sortByNameDesc() {
		List<Item> item = Arrays.asList(
				new Item(1, "Andrey"),
				new Item(3, "Petr"),
				new Item(5, "Ivan")
		);
		Item[] expected = {new Item(3, "Petr"),
				new Item(5, "Ivan"),
				new Item(1, "Andrey")};
		Collections.sort(item, new SortByNameItemDESC());
		assertThat(item.toArray(), is(expected));
	}
}