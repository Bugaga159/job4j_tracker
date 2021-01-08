package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу с юзерами и их счетами
 * @author Andrey Panin
 * @version 1.0
 */
public class BankService {
	/**
	 * Хранение юзеров со счетами осуществляется в коллекции типа HashMap
	 */
	private Map<User, List<Account>> users = new HashMap<>();

	/**
	 * Метод позволяет создать нового юзера
	 * @param user новый юзер
	 */
	public void addUser(User user) {
		users.putIfAbsent(user, new ArrayList<Account>());
	}

	/**
	 * Метод добавляет юзеру новый счет
	 * через поиск по паспорту юзера
	 * @param passport паспорт юзера
	 * @param account счет юзера
	 */
	public void addAccount(String passport, Account account) {
		Optional<User> user = findByPassport(passport);
		if (user.isPresent()) {
			List<Account> accounts = users.get(user.get());
			if (!accounts.contains(account)) {
				accounts.add(account);
				users.put(user.get(), accounts);
			}
		}
	}

	/**
	 * Метод осуществляет поиск юзера по паспорту и
	 * возвращает первого найденного
	 * @param passport паспорт юзера
	 * @return an {@code Optional} describing the first element of this stream,
	 * or an empty {@code Optional} if the stream is empty
	 */
	public Optional<User> findByPassport(String passport) {
		return users.keySet().stream()
				.filter(e -> e.getPassport().equals(passport))
				.findFirst();
	}

	/**
	 * Метод осуществляет поиск юзера по паспорту и реквизитам счета
	 * @param passport паспорт юзера
	 * @param requisite реквизиты счета
	 * @return an {@code Optional} describing the first element of this stream,
	 * or an empty {@code Optional} if the stream is empty
	 */
	public Optional<Account> findByRequisite(String passport, String requisite) {
		Optional<User> user = findByPassport(passport);
		Optional<Account> res = Optional.empty();
		if (user.isPresent()) {
			res = users.get(user.get()).stream()
					.filter(e -> e.equals(new Account(requisite, -1)))
					.findFirst();
		}
		return res;
	}

	/**
	 * Метод осуществляет перевод денег с одного счета на другой
	 * по паспортным данным и счетам
	 * @param srcPassport паспорт юзера для списания
	 * @param srcRequisite реквизиты счета для списания
	 * @param destPassport паспорт юзера для поступления
	 * @param destRequisite реквизиты счета для поступления
	 * @param amount сумма
	 * @return результат транзакции true/false
	 */
	public boolean transferMoney(String srcPassport, String srcRequisite,
							String destPassport, String destRequisite,
							double amount) {
		boolean rsl = false;
		Optional<Account> accountSrc = findByRequisite(srcPassport, srcRequisite);
		Optional<Account> accountDest = findByRequisite(destPassport, destRequisite);
		if (accountSrc.isPresent()
			&& accountDest.isPresent()
			&& accountSrc.get().getBalance() >= amount
			) {
			accountSrc.get().setBalance(accountSrc.get().getBalance() - amount);
			accountDest.get().setBalance(accountDest.get().getBalance() + amount);
			rsl = true;
		}
		return rsl;
	}

	public static void main(String[] args) {
		BankService bank = new BankService();
		bank.addUser(new User("321", "Petr Arsentev"));
		Optional<User> opt = bank.findByPassport("3211");
		if (opt.isPresent()) {
			System.out.println(opt.get().getUsername());
		}
	}
}