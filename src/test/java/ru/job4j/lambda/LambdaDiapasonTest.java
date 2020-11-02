package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LambdaDiapasonTest {
	@Test
	public void whenLinearFunctionThenLinearResults() {
		List<Double> result = LambdaDiapason.diapason(5, 8, x -> 2 * x + 1);
		List<Double> expected = Arrays.asList(11D, 13D, 15D, 17D);
		assertThat(result, is(expected));
	}

	@Test
	public void whenQuadraticFunctionQuadraticResults() {
		List<Double> result = LambdaDiapason.diapason(2, 5, x -> x * x);
		List<Double> expected = Arrays.asList(4D, 9D, 16D, 25D);
		assertThat(result, is(expected));
	}

	@Test
	public void whenExponentiaFunctionExponentialResults() {
		List<Double> result = LambdaDiapason.diapason(1, 3, x -> Math.pow(5,x) );
		List<Double> expected = Arrays.asList(5D, 25D, 125D) ;
		assertThat(result, is(expected));
	}

}