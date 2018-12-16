package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import personFinder.PersonPair;
import personFinder.SearchType;
import personFinder.Finder;
import personFinder.Person;

public class FinderTests {

	Person sue = new Person();
	Person greg = new Person();
	Person sarah = new Person();
	Person mike = new Person();

	@Before
	public void setup() {
		sue.setName("Sue");
		sue.setBirthDate(new Date(50, 0, 1));
		greg.setName("Greg");
		greg.setBirthDate(new Date(52, 5, 1));
		sarah.setName("Sarah");
		sarah.setBirthDate(new Date(82, 0, 1));
		mike.setName("Mike");
		mike.setBirthDate(new Date(79, 0, 1));
	}

	@Test
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> list = new ArrayList<Person>();
		Finder finder = new Finder(list);

		PersonPair result = finder.Find(SearchType.Minimum);
		assertEquals(null, result.getPerson1());

		assertEquals(null, result.getPerson2());
	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);

		Finder finder = new Finder(list);

		PersonPair result = finder.Find(SearchType.Minimum);

		assertEquals(null, result.getPerson1());
		assertEquals(null, result.getPerson2());
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(greg);
		Finder finder = new Finder(list);

		PersonPair result = finder.Find(SearchType.Minimum);

		assertEquals(sue, result.getPerson1());
		assertEquals(greg, result.getPerson2());
	}

	@Test
	public void Returns_Furthest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		PersonPair result = finder.Find(SearchType.Maximum);

		assertEquals(greg, result.getPerson1());
		assertEquals(mike, result.getPerson2());
	}

	@Test
	public void Returns_Furthest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);
		Finder finder = new Finder(list);

		PersonPair result = finder.Find(SearchType.Maximum);

		assertEquals(sue, result.getPerson1());
		assertEquals(sarah, result.getPerson2());
	}

	@Test
	public void Returns_Closest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		PersonPair result = finder.Find(SearchType.Minimum);

		assertEquals(sue, result.getPerson1());
		assertEquals(greg, result.getPerson2());
	}

}
