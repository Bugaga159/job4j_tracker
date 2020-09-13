package ru.job4j.poly;

public class Bus implements Transport {
	private int passangers = 0;
	private float price = 3.12f;

	@Override
	public void run() {

	}

	@Override
	public void addPassengers(int size) {
		passangers += size;
	}

	@Override
	public float fill(float petrol) {
		return petrol * price;
	}
}
