package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
	public List<Address> collect(List<Profile> profiles) {
		return profiles.stream()
				.map(Profile::getAddress)
				.sorted((e1, e2) -> e1.getCity().compareTo(e2.getCity()))
				.distinct()
				.collect(Collectors.toList());
	}
}
