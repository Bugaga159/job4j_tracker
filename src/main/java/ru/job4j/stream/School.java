package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class School {
	public List<Student> collect(List<Student> students, Predicate<Student> predict) {
		List<Student> res = new ArrayList<>();
		for (Student student: students) {
			if (predict.test(student)) {
				res.add(student);
			}
		}
		return res;
	}
}
