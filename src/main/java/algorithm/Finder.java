package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public PersonPair Find(SearchType searchType) {
		List<PersonPair> personPairList = new ArrayList<PersonPair>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				PersonPair personPair = new PersonPair();
				if (people.get(i).birthDate.getTime() < people.get(j).birthDate.getTime()) {
					personPair.person1 = people.get(i);
					personPair.person2 = people.get(j);
				} else {
					personPair.person1 = people.get(j);
					personPair.person2 = people.get(i);
				}
				personPair.dateDiff = personPair.person2.birthDate.getTime() - personPair.person1.birthDate.getTime();
				personPairList.add(personPair);
			}
		}

		if (personPairList.size() < 1) {
			return new PersonPair();
		}

		PersonPair answer = personPairList.get(0);
		for (PersonPair result : personPairList) {
			switch (searchType) {
				case Minimum:
					if (result.dateDiff < answer.dateDiff) {
						answer = result;
					}
					break;

				case Maximum:
					if (result.dateDiff > answer.dateDiff) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}
}
