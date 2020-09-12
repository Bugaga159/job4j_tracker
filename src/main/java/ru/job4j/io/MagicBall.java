package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
		String question = input.nextLine();
		int answer = new Random().nextInt(3);
		String rsl = switch (answer) {
			case 0 -> question + " - Да";
			case 1 -> question + " - Нет";
			default -> question + " - Может быть";
		};
		System.out.println(rsl);
	}
}
