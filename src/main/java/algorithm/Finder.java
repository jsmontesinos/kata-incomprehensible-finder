package algorithm;
import java.util.List;

public class Finder {
	private List<Person> people;
	private PersonFinder personFinder;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public PersonPair Find(SearchType searchType) {
		this.personFinder = getPersonFinderAccordingType(searchType);
		return personFinder.Find(searchType);
	}

	private PersonFinder getPersonFinderAccordingType(SearchType searchType) {
		switch (searchType) {
			case Minimum:
				return new PersonFinderByMinimumDateDiff(people);
			case Maximum:
				return new PersonFinderByMaximumDateDiff(people);
		}

		return null;
	}
}
