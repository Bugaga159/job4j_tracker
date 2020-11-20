package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
	private ArrayList<Person> persons = new ArrayList<Person>();

	public void add(Person person) {
		this.persons.add(person);
	}

	/**
	 * Вернуть список всех пользователей, который содержат key в любых полях.
	 * @param key Ключ поиска.
	 * @return Список подощедщих пользователей.
	 */
	public ArrayList<Person> find(String key) {
		Predicate<Person> surnameInclude = person -> person.getSurname().contains(key);
		Predicate<Person> addressInclude = person -> person.getAddress().contains(key);
		Predicate<Person> nameInclude = person -> person.getName().contains(key);
		Predicate<Person> phoneInclude = person -> person.getPhone().contains(key);
		Predicate<Person> combine = surnameInclude
									.or(addressInclude)
									.or(nameInclude)
									.or(phoneInclude);
		var result = new ArrayList<Person>();
		for (var person : persons) {
			if (combine.test(person)) {
				result.add(person);
			}
		}
		return result;
	}
}
