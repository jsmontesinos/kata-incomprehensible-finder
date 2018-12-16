package personFinder;

import java.util.List;

public class PersonFinderByMaximumDateDiff extends PersonFinder {

    public PersonFinderByMaximumDateDiff(List<Person> people) {
        super(people);
    }

    public PersonPair findPair() {
        List<Person> orderedPeople = this.getOrderedPeopleByBirthDate();
        return orderedPeople.isEmpty() ?
                new PersonPair() :
                new PersonPair(orderedPeople.get(0), orderedPeople.get(orderedPeople.size() - 1));
    }
}
