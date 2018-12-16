package personFinder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class PersonFinder {
    private List<Person> people;

    public PersonFinder(List<Person> people) {
        this.people = people;
    }

    public abstract PersonPair findPair();

    protected List<Person> getOrderedPeopleByBirthDate() {
        return people
                .stream()
                .sorted(Comparator.comparing(Person::getBirthDate))
                .collect(Collectors.toList());
    }
}