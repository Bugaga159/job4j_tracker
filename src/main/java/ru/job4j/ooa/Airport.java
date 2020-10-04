package ru.job4j.ooa;

public class Airport {
	public static void main(String[] args) {
		final Airbus airbus = new Airbus("A320");
		System.out.println(airbus);
		airbus.printModel();
		airbus.printCountEngine();

		final Airbus airbusTwo = new Airbus("A380");
		System.out.println(airbus);

		airbusTwo.setName("A380");
		System.out.println(airbus);
	}
}