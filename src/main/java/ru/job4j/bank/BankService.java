package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
	private Map<User, List<Account>> users = new HashMap<>();

	public void addUser(User user) {
		users.putIfAbsent(user, new ArrayList<Account>());
	}

	public void addAccount(String passport, Account account) {
		User user = findByPassport(passport);
		if (user != null) {
			Account res = findByRequisite(passport, account.getRequisite());
			if (res == null) {
				List<Account> accounts = users.get(user);
				accounts.add(account);
				users.put(user, accounts);
			}
		}
	}

	public User findByPassport(String passport) {
		for (User user:users.keySet()) {
			if (user.getPassport().equals(passport)) {
				return  user;
			}
		}
		return null;
	}

	public Account findByRequisite(String passport, String requisite) {
		User user = findByPassport(passport);
		if (user != null && users.get(user).size() > 0) {
			List<Account> accounts = users.get(user);
			int index = accounts.indexOf(new Account(requisite, -1));
			return index != -1 ? accounts.get(index) : null;
		}
		return null;
	}

	public boolean transferMoney(String srcPassport, String srcRequisite,
								 String destPassport, String destRequisite,
								 double amount) {
		boolean rsl = false;
		User userSrc = findByPassport(srcPassport);
		User userDest = findByPassport(destPassport);
		if (userSrc != null && userDest != null) {
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
		}
		return rsl;
	}
}