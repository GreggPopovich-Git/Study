
public class Student {
	int bun;
	String name;
	int kor;
	int eng;
	int mat;
	int tot;
	double ave;
	//생성자 : 클래스 이름과 같은 이름을 가진 메소드
	//생성자 overloading : 메소드의 이름은 똑같은데 매개변수의 개수나 타입이 다름. (변수이름과는 상관 없음) 
	Student(){}
	Student(int bun, String name){
		this.bun = bun;    //super : 상위(조상)
		this.name = name;
	}
	Student(int bun, String name, int kor, int eng, int mat){
		this.bun = bun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	//기능구현
	public void totAve() {
		tot = kor + eng + mat;
		ave = tot / 3.;
	}
	public void sPrint() {
		System.out.println(bun + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + ave);
	}
}
