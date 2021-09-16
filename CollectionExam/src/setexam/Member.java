package setexam;

public class Member {
	private String name;
	private int age;
	public Member() {}
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + " " + age;
	}
	@Override
	public boolean equals(Object obj) { // equals override
		boolean bool = false;
		if (obj != null && obj instanceof Member) {
			if (name.equals(((Member)obj).name) && age == ((Member)obj).age)
				bool = true;
		}
		return bool;
	}
	@Override
	public int hashCode() { // hashCode override
		
		return name.hashCode() + age;
	}
	
}