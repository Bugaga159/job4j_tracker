package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

	public Map<String, Student> getMapStudents(List<Student> students) {
		return students.stream().distinct().collect(Collectors.toMap(
				e -> e.getSurname(),
				e -> e
		));
	}
}
