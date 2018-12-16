package personFinder;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class PersonFinderByMinimumDateDiff extends PersonFinder{

    public PersonFinderByMinimumDateDiff(List<Person> people) {
        super(people);
    }

    protected PersonPair findPair() {
        List<Person> orderedPeople = this.getOrderedPeopleByBirthDate();
        return IntStream
                .range(1, orderedPeople.size())
                .mapToObj(i -> new PersonPair(orderedPeople.get(i - 1), orderedPeople.get(i)))
                .min(Comparator.comparing(PersonPair::getDateDiff))
                .orElse(new PersonPair());
    }
}
