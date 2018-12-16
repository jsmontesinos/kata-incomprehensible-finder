package personFinder;
public class PersonPair {

	public PersonPair() {}

	public PersonPair(Person person1, Person person2) {
		this.person1 = person1;
		this.person2 = person2;
		this.dateDiff = person2.getBirthDate().getTime() - person1.getBirthDate().getTime();
	}

	public Person person1;
	public Person person2;

	public long getDateDiff() {
		return dateDiff;
	}

	public long dateDiff;
}
