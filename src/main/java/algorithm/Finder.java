package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public SearchResult Find(SearchType searchType) {
		List<SearchResult> searchResultList = new ArrayList<SearchResult>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				SearchResult r = new SearchResult();
				if (people.get(i).birthDate.getTime() < people.get(j).birthDate.getTime()) {
					r.person1 = people.get(i);
					r.person2 = people.get(j);
				} else {
					r.person1 = people.get(j);
					r.person2 = people.get(i);
				}
				r.dateDiff = r.person2.birthDate.getTime() - r.person1.birthDate.getTime();
				searchResultList.add(r);
			}
		}

		if (searchResultList.size() < 1) {
			return new SearchResult();
		}

		SearchResult answer = searchResultList.get(0);
		for (SearchResult result : searchResultList) {
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
