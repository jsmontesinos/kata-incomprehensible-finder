package personFinder;
public class PersonPair {

	private Person person1;
	private Person person2;
	private long dateDiff;

	public PersonPair() {}

	public PersonPair(Person person1, Person person2) {
		this.person1 = person1;
		this.person2 = person2;
		this.dateDiff = person2.getBirthDate().getTime() - person1.getBirthDate().getTime();
	}

	public long getDateDiff() {
		return dateDiff;
	}

	public Person getPerson1() {
		return person1;
	}

	public Person getPerson2() {
		return person2;
	}
}
