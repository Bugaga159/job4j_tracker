package ru.job4j.test;

public class GG extends TestFirst{

	public GG(String in) {
		super("fff");
		System.out.println("44444");
	}
	
	public static void getToken() {
		System.out.println(456);
	}

	public static void main(String[] args) {
		GG.getToken();
	}
}
