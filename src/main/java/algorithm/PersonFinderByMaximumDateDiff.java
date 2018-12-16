package algorithm;

import java.util.List;

/**
 * Created by juan on 16/12/18.
 */
public class PersonFinderByMaximumDateDiff extends PersonFinder {

    public PersonFinderByMaximumDateDiff(List<Person> people) {
        super(people);
    }

    protected PersonPair calculatePairAccordingType(SearchType searchType, List<PersonPair> personPairList) {
        PersonPair answer = personPairList.get(0);
        for (PersonPair result : personPairList) {
            if (result.dateDiff > answer.dateDiff) {
                answer = result;
            }
        }
        return answer;
    }
}
