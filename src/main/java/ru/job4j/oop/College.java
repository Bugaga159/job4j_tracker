package ru.job4j.oop;

public class College {
	public static void main(String[] args) {
		Student student = new Freshman();
		Object object = student;
		// или при создании объекта
		Object oFreshman = new Freshman();
		Object oStudent = new Student();
	}
}
