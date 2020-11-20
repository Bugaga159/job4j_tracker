package ru.job4j.stream;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StreamMatrixToListTest {

	@Test
	public void whenMatrixToListTest() {
		Integer[][] matrix = {{1, 4, 2}, {4, 2, 5}};
		List<Integer> res = StreamMatrixToList.getListFromMatrix(matrix);
		List<Integer> exp = Arrays.asList(1, 4, 2, 4, 2, 5);
		assertThat(res, is(exp));
	}

}