package ru.job4j.oop;

public class OutputVehicle {
	public static void main(String[] args) {
		Vehicle aircraft = new Aircraft();
		Vehicle bus = new Bus();
		Vehicle train = new Train();
		Vehicle[] vehicles = {aircraft, bus, train};
		for (Vehicle value:vehicles) {
			value.move();
		}
	}
}
