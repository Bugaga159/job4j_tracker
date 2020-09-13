package ru.job4j.io;

import java.util.Scanner;

public class Matches {
	private static int size = 11;
	private static int player = 1;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean user = false;
		while (size != 0) {
			user = !user;
			player = user ? 1 : 2;
			takeUser(player, input);
			System.out.println("Осталось " + size + " спичек");
		}
		System.out.println("Игрок " + player + " WIN!");
	}

	private static void takeUser(int numberUser, Scanner input) {
		System.out.println("Игрок " + numberUser + " возьмите от 1 до 3 спичек");
		int playerInput = Integer.valueOf(input.nextLine());
		if (playerInput > 3 || playerInput < 0 || playerInput > size) {
			System.out.println("Игрок " + numberUser
					+ " взял не правильное количество спичек: " + playerInput);
			System.out.println("Возврат спичек и пропуск хода");
		} else {
			size -= playerInput;
		}
	}
}
