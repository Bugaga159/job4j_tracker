package ru.job4j.search;

import java.util.ArrayList;

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
		ArrayList<Person> result = new ArrayList<>();
		for (Person person: persons) {
			if (person.getSurname().toLowerCase().contains(key.toLowerCase())
				|| person.getPhone().toLowerCase().contains(key.toLowerCase())
				|| person.getName().toLowerCase().contains(key.toLowerCase())
				|| person.getAddress().toLowerCase().contains(key.toLowerCase())
			) {
				result.add(person);
			}
		}
		return result;
	}
}
