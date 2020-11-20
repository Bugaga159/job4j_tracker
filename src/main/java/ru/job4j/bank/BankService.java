package ru.job4j.bank;

import java.util.*;

public class BankService {
	private Map<User, List<Account>> users = new HashMap<>();

	public void addUser(User user) {
		users.putIfAbsent(user, new ArrayList<Account>());
	}

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

	public Optional<User> findByPassport(String passport) {
		Optional<User> rsl = Optional.empty();
		for (User user : users.keySet()) {
			if (user.getPassport().equals(passport)) {
				rsl = Optional.of(user);
				break;
			}
		}
		return rsl;
	}

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