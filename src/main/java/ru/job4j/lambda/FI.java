package ru.job4j.lambda;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class FI {
	public static void main(String[] args) {
		Attachment[] atts = {
				new Attachment("image 1", 20),
				new Attachment("image 3", 120),
				new Attachment("image 2", 23)
		};
		Comparator<Attachment> comparator = new Comparator<Attachment>() {
			@Override
			public int compare(Attachment left, Attachment right) {
				return left.getSize() - right.getSize();
			}
		};
		Arrays.sort(atts, comparator);

		raw(Arrays.asList(atts), new Function<Attachment, InputStream>() {
			@Override
			public InputStream apply(Attachment att) {
				return new ByteArrayInputStream(att.toString().getBytes());
			}
		});

		Comparator<Student> compStudent = new Comparator<Student>() {
			@Override
			public int compare(Student st1, Student st2) {
				return st1.getName().compareTo(st2.getName());
			}
		};
		Function<Student, Mark> func = new Function<Student, Mark>() {
			@Override
			public Mark apply(Student student) {
				return (Mark) student;
			}
		};

	}

	public static void raw(List<Attachment> list, Function<Attachment, InputStream> func) {
		for (Attachment att : list) {
			func.apply(att);
		}
	}

}