package algorithm;
import java.util.List;

public class Finder {
	private PersonFinder personFinder;

	public Finder(List<Person> people) {
		this.personFinder = new PersonFinder(people);
	}

	public PersonPair Find(SearchType searchType) {

		return personFinder.Find(searchType);
	}
}
