package ru.job4j.poly;

public interface Transport {
	public void run();

	public void addPassengers(int size);

	public float fill(float petrol);
}
