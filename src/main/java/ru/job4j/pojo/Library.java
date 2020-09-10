package ru.job4j.pojo;

public class Library {
	public static void main(String[] args) {
		Book warAndPeace = new Book("Война и мир", 1200);
		Book tolkienHobbit = new Book("The Hobbit", 1200);
		Book orwell1984 = new Book("1984", 452);
		Book cleanCode = new Book("Clean code", 450);
		Book[] books = new Book[4];
		books[0] = warAndPeace;
		books[1] = tolkienHobbit;
		books[2] = orwell1984;
		books[3] = cleanCode;
		for (int index = 0; index < books.length; index++) {
			System.out.println(books[index].getName() + " - "
			+ books[index].getSize());
		}
		System.out.println("---- Замена в массиве ----");
		Book temporary = books[0];
		books[0] = books[3];
		books[3] = temporary;
		for (int index = 0; index < books.length; index++) {
			System.out.println(books[index].getName() + " - "
					+ books[index].getSize());
		}
		System.out.println("---- Вывод только 'Clean code'----");
		for (Book book: books) {
			if (book.getName().equals("Clean code")) {
				System.out.println("Книга: " + book.getName() + System.lineSeparator()
				+ "Страниц: " + book.getSize());
			}
		}
	}
}
