package ru.job4j.io;

import java.util.Scanner;

public class Matches {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size = 11;
		while (true) {
			System.out.println("Игрок 1 возьмите от 1 до 3 спичек");
			int playerFirst = Integer.valueOf(input.nextLine());
			size -= playerFirst;
			System.out.println("Осталось " + size + " спичек");
			if (size == 0) {
				System.out.println("Игрок 1 WIN!");
				break;
			}
			System.out.println("Игрок 2 возьмите от 1 до 3 спичек");
			int playerSecond = Integer.valueOf(input.nextLine());
			size -= playerSecond;
			System.out.println("Осталось " + size  + " спичек");
			if (size == 0) {
				System.out.println("Игрок 2 WIN!");
				break;
			}
		}
	}
}
