package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель счета юзера
 * @author Andrey Panin
 * @version 1.0
 */
public class Account {
	/**
	 * Реквизиты счета
	 */
	private String requisite;
	/**
	 * Баланс счета
	 */
	private double balance;

	/**
	 * Конструктор счета с параметрами:
	 * реквизит и баланс
	 * @param requisite реквизит счета
	 * @param balance  начальный баланс счета
	 */
	public Account(String requisite, double balance) {
		this.requisite = requisite;
		this.balance = balance;
	}

	/**
	 * Метод возвращает реквизиты счета
	 * @return реквизит счета
	 */
	public String getRequisite() {
		return requisite;
	}

	/**
	 * Метод обновляет реквизиты счета
	 * @param requisite новые реквизиты счета
	 */
	public void setRequisite(String requisite) {
		this.requisite = requisite;
	}

	/**
	 * Метод возвращает баланс счета
	 * @return баланс счета
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Метод обновляет баланс счета
	 * @param balance новый баланс счета
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Account account = (Account) o;
		return Objects.equals(requisite, account.requisite);
	}

	@Override
	public int hashCode() {
		return Objects.hash(requisite);
	}
}