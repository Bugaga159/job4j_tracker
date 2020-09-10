package ru.job4j.pojo;

public class Book {
	private String name;
	private int size;

	public Book(String name, int size) {
		this.name = name;
		this.size = size;
	}

	@Override
	public String toString() {
		return "Book{" +
				"name='" + name + '\'' +
				", size=" + size +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
