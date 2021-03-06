package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
	private List<Student> students = new ArrayList<>();

	@Before
	public void setUp() {
		students.add(new Student(10, "Surname1"));
		students.add(new Student(20, "Surname2"));
		students.add(new Student(30, "Surname3"));
		students.add(new Student(40, "Surname4"));
		students.add(new Student(50, "Surname5"));
		students.add(new Student(60, "Surname6"));
		students.add(new Student(70, "Surname7"));
		students.add(new Student(80, "Surname8"));
		students.add(new Student(90, "Surname9"));
	}

	@Test
	public void whenCollectClassA() {
		School sc = new School();
		Predicate<Student> pr = e -> (e.getScore() >= 70) && (e.getScore() <= 100);
		List<Student> rsl = sc.collect(students, pr);
		List<Student> expected = List.of(
			new Student(70, "Surname7"),
			new Student(80, "Surname8"),
			new Student(90, "Surname9"));
		assertThat(rsl, is(expected));
	}

	@Test
	public void whenCollectClassB() {
		School sc = new School();
		Predicate<Student> pr = e -> (e.getScore() >= 50) && (e.getScore() < 70);
		List<Student> rsl = sc.collect(students, pr);
		List<Student> expected = List.of(
			new Student(50, "Surname5"),
			new Student(60, "Surname6"));
		assertThat(rsl, is(expected));
	}

	@Test
	public void whenCollectClassC() {
		School sc = new School();
		Predicate<Student> pr = e -> (e.getScore() > 0) && (e.getScore() < 50);
		List<Student> rsl = sc.collect(students, pr);
		List<Student> expected = List.of(
			new Student(10, "Surname1"),
			new Student(20, "Surname2"),
			new Student(30, "Surname3"),
			new Student(40, "Surname4"));
		assertThat(rsl, is(expected));
	}

	@Test
	public void whenGetMapStudents() {
		School sc = new School();
		Map<String, Student> rsl = sc.getMapStudents(students);
		Map<String, Student> expected = Map.of(
			"Surname1", new Student(10, "Surname1"),
			"Surname2", new Student(20, "Surname2"),
			"Surname3", new Student(30, "Surname3"),
			"Surname4", new Student(40, "Surname4"),
			"Surname5", new Student(50, "Surname5"),
			"Surname6", new Student(60, "Surname6"),
			"Surname7", new Student(70, "Surname7"),
			"Surname8", new Student(80, "Surname8"),
			"Surname9", new Student(90, "Surname9"));
		assertThat(rsl, is(expected));
	}
}