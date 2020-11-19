package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
	private List<Profile> profilesList = new ArrayList<>();

	@Before
	public void setUp() {
		profilesList.add(new Profile(new Address("Moscow", "Lenina", 12, 2)));
		profilesList.add(new Profile(new Address("Moscow", "Pushkina", 28, 6)));
		profilesList.add(new Profile(new Address("Sochi", "Lenina", 12, 2)));
		profilesList.add(new Profile(new Address("Moscow", "Lenina", 12, 2)));
		profilesList.add(new Profile(new Address("Moscow", "Chehova", 3, 7)));
		profilesList.add(new Profile(new Address("Kiev", "Lenina", 45, 9)));
	}

	@SuppressWarnings("checkstyle:WhitespaceAfter")
	@Test
	public void whenProfileToMapAddressListTest() {
		Profiles profiles = new Profiles();
		List<Address> rsl = profiles.collect(profilesList);
		List<Address> expected = new ArrayList<>();
		expected.add(new Address("Kiev", "Lenina", 45, 9));
		expected.add(new Address("Moscow", "Lenina", 12, 2));
		expected.add(new Address("Moscow", "Pushkina", 28, 6));
		expected.add(new Address("Moscow", "Chehova", 3, 7));
		expected.add(new Address("Sochi", "Lenina", 12, 2));
		assertThat(rsl, is(expected));
	}
}