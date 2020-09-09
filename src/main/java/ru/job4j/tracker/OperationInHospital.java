package ru.job4j.tracker;

import java.util.UUID;

public class OperationInHospital {
	private UUID id;
	private String name;
	private Doctor doctor;
	private String date;

	public OperationInHospital(UUID id, String name, Doctor doctor, String date) {
		this.id = id;
		this.name = name;
		this.doctor = doctor;
		this.date = date;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public String getDate() {
		return date;
	}
}
