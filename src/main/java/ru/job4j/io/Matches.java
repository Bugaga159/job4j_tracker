package ru.job4j.io;

import java.util.Scanner;

public class Matches {
	private static int size = 11;
	private static boolean rsl = true;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (rsl) {
			if (!(takeUser(1, input))) break;
			if (!(takeUser(2, input))) break;
		}
	}

	private static boolean takeUser(int numberUser, Scanner input) {
		System.out.println("Игрок " + numberUser + " возьмите от 1 до 3 спичек");
		int player = Integer.valueOf(input.nextLine());
		if (player > 3 || player < 0) {
			System.out.println("Игрок " + numberUser
					+ " взял не правильное количество спичек: " + player);
			System.out.println("Возврат спичек и пропуск хода");
		} else {
			size -= player;
			System.out.println("Осталось " + size + " спичек");
			if (size == 0) {
				System.out.println("Игрок " + numberUser + " WIN!");
				rsl = false;
			}
		}
		return rsl;
	}
}
