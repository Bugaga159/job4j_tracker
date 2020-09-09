package ru.job4j.tracker;

public class Plan {
	private static int id = 0;
	private String date;
	private String comment;

	public Plan(String date, String comment) {
		id++;
		this.date = date;
		this.comment = comment;
	}

	public static int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getComment() {
		return comment;
	}
}
