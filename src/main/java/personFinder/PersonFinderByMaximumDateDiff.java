package personFinder;

import java.util.List;

public class PersonFinderByMaximumDateDiff extends PersonFinder {

    public PersonFinderByMaximumDateDiff(List<Person> people) {
        super(people);
    }

    protected PersonPair findPair() {
        List<Person> orderedPeople = this.getOrderedPeopleByBirthDate();
        return orderedPeople.isEmpty() ? new PersonPair() : getPersonPair(orderedPeople);
    }

    private PersonPair getPersonPair(List<Person> orderedPeople) {
        PersonPair pair = new PersonPair();
        pair.person1 = orderedPeople.get(0);
        pair.person2 = orderedPeople.get(orderedPeople.size() - 1);
        pair.dateDiff = pair.person2.getBirthDate().getTime() - pair.person1.getBirthDate().getTime();
        return pair;
    }
}
