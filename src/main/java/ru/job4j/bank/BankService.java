package ru.job4j.bank;

import java.util.*;

public class BankService {
	private Map<User, List<Account>> users = new HashMap<>();

	public void addUser(User user) {
		users.putIfAbsent(user, new ArrayList<Account>());
	}

	public void addAccount(String passport, Account account) {
		User user = findByPassport(passport);
		if (user != null) {
			List<Account> accounts = users.get(user);
			if (!accounts.contains(account)) {
				accounts.add(account);
				users.put(user, accounts);
			}
		}
	}

	public User findByPassport(String passport) {
		Optional<User> user = users.keySet().stream()
				.filter(e -> e.getPassport().equals(passport))
				.findFirst();
		return user.orElse(null);
	}

	public Account findByRequisite(String passport, String requisite) {
		User user = findByPassport(passport);
		if (user != null) {
			Optional<Account> res = users.get(user).stream()
					.filter(e -> e.equals(new Account(requisite, -1)))
					.findFirst();
			return res.orElse(null);
		}
		return null;
	}

	public boolean transferMoney(String srcPassport, String srcRequisite,
							String destPassport, String destRequisite,
							double amount) {
		boolean rsl = false;
		Account accountSrc = findByRequisite(srcPassport, srcRequisite);
		Account accountDest = findByRequisite(destPassport, destRequisite);
		if (accountSrc != null
			&& accountDest != null
			&& accountSrc.getBalance() >= amount
			) {
			accountSrc.setBalance(accountSrc.getBalance() - amount);
			accountDest.setBalance(accountDest.getBalance() + amount);
			rsl = true;
		}
		return rsl;
	}
}