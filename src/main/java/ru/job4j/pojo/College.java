package ru.job4j.pojo;

import java.util.Date;

public class College {
	public static void main(String[] args) {
		Student andrey = new Student();
		andrey.setOwner("Panin Andrey");
		andrey.setGroup("MX20IT4");
		andrey.setCreated(new Date());
		System.out.println("ФИО: " + andrey.getOwner() + System.lineSeparator()
				+ "Группа: " + andrey.getGroup() + System.lineSeparator()
				+ "Дата приема: " + andrey.getCreated());
	}
}
