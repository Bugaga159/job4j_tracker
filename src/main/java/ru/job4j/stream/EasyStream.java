package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
	private List<Integer> list;

	private EasyStream(List<Integer> source) {
		list = source;
	}

	public static EasyStream of(List<Integer> source) {
		return new EasyStream(source);
	}

	public EasyStream map(Function<Integer, Integer> fun) {
		List<Integer> res = new ArrayList<>();
		for (var i:list) {
			res.add(fun.apply(i));
		}
		list = res;
		return this;
	}

	public EasyStream filter(Predicate<Integer> fun) {
		List<Integer> res = new ArrayList<>();
		for (var i:list) {
			if (fun.test(i)) {
				res.add(i);
			}
		}
		list = res;
		return this;
	}

	public List<Integer> collect() {
		return list;
	}
}