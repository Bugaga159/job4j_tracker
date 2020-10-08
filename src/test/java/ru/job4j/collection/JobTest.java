package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
	@Test
	public void whenCompatorByNameAndPrority() {
		Comparator<Job> cmpNamePriority = new JobDescByName()
				.thenComparing(new JobDescByPriority());
		int rsl = cmpNamePriority.compare(
				new Job("Impl task", 0),
				new Job("Fix bug", 1)
		);
		assertThat(rsl, lessThan(0));
	}

	@Test
	public void whenCompatorByNameDesc() {
		Comparator<Job> cmpNamePriority = new JobDescByName();
		int rsl = cmpNamePriority.compare(
				new Job("Impl task", 0),
				new Job("Fix bug", 1)
		);
		assertThat(rsl, lessThan(0));
	}

	@Test
	public void whenCompatorByNameAsc() {
		Comparator<Job> cmpNamePriority = new JobAscByName();
		int rsl = cmpNamePriority.compare(
				new Job("End word", 1),
				new Job("Fix bug", 0)
		);
		assertThat(rsl, lessThan(0));
	}

	@Test
	public void whenCompatorByProrityAsc() {
		Comparator<Job> cmpNamePriority = new JobAscByPriority();
		int rsl = cmpNamePriority.compare(
				new Job("End word", 0),
				new Job("Fix bug", 4)
		);
		assertThat(rsl, lessThan(0));
	}

	@Test
	public void whenCompatorByProrityDesc() {
		Comparator<Job> cmpNamePriority = new JobDescByPriority();
		int rsl = cmpNamePriority.compare(
				new Job("End word", 3),
				new Job("Fix bug", 2)
		);
		assertThat(rsl, lessThan(0));
	}

	@Test
	public void whenCompatorByProrityDescAndNameAsc() {
		Comparator<Job> cmpNamePriority = new JobDescByPriority()
				.thenComparing(new JobAscByName());
		int rsl = cmpNamePriority.compare(
				new Job("End word", 3),
				new Job("Fix bug", 2)
		);
		assertThat(rsl, lessThan(0));
	}
}