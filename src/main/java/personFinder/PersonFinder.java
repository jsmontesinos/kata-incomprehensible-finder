package personFinder;

import java.util.ArrayList;
import java.util.List;

public abstract class PersonFinder {
    private List<Person> people;

    public PersonFinder(List<Person> people) {
        this.people = people;
    }

    public PersonPair Find(SearchType searchType) {
        List<PersonPair> personPairList = getPersonPairs();

        return personPairList.isEmpty() ? new PersonPair() : findPair(searchType, personPairList);
    }

    protected abstract PersonPair findPair(SearchType searchType, List<PersonPair> personPairList);

    private List<PersonPair> getPersonPairs() {
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
        return personPairList;
    }
}