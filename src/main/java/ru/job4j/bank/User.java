package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель юзера
 * @author Andrey Panin
 * @version 1.0
 */
public class User {
	/**
	 * Паспорт юзера
	 */
	private String passport;
	/**
	 * Наименование юзера
	 */
	private String username;

	/**
	 * Конструктор юзера с входными параметрами
	 * паспорт и наименования юзера
	 * @param passport паспорт юзера
	 * @param username наименование юзера
	 */
	public User(String passport, String username) {
		this.passport = passport;
		this.username = username;
	}

	/**
	 * Метод возвращает паспорт юзера
	 * @return паспорт юзера
	 */
	public String getPassport() {
		return passport;
	}

	/**
	 * Метод обновляет паспорт юзера
	 * @param passport новый паспорт юзера
	 */
	public void setPassport(String passport) {
		this.passport = passport;
	}

	/**
	 * Метод возвращает наименование юзера
	 * @return наименование юзера
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Метод обновляет наименование юзера
	 * @param username новое значение юзера
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(passport, user.passport);
	}

	@Override
	public int hashCode() {
		return Objects.hash(passport);
	}
}