package exam01;

public class SubClass {
	int num;
	int age;
	int data[][] = new int[11][9];
	
	public SubClass(){}
	public SubClass(int num, int age){
		this.num = num;
		this.age = age;
		agecount();
	}
	
	private void agecount() {
		for (int i = 0; i < data.length-1; i++)
			data[i][0] = i + 1;
		
	}
}
