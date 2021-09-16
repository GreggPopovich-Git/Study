package mapexam;

public class Student {
	private int sno;
	private String name;
	public Student (int sno, String name) {
		this.sno = sno;
		this.name = name;
	}
	@Override
	public String toString() {
		return sno + ", " + name;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student stu = (Student)obj;
			return (sno == stu.sno) && name.equals(stu.name);
		}
		else
			return false;
	}
	@Override
	public int hashCode() {
		return sno + name.hashCode();
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}