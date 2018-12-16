package personFinder;

import java.util.List;

public class PersonFinderByMinimumDateDiff extends PersonFinder{

    public PersonFinderByMinimumDateDiff(List<Person> people) {
        super(people);
    }

    protected PersonPair findPair(SearchType searchType, List<PersonPair> personPairList) {
        PersonPair answer = personPairList.get(0);
        for (PersonPair result : personPairList) {
            if (result.dateDiff < answer.dateDiff) {
                answer = result;
            }
        }
        return answer;
    }
}
