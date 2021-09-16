package bb;
// import aa.Car;  aa 패키지 안에 있는 Car 라는 클래스를 import
// import aa.*;  aa 안에 있는 모든 클래스를 사용하겠다는 의미
import static java.lang.System.out; // static import

public class Exam_01 {
	public static void main(String[] args) {
		aa.Car car1 = new aa.Car(); // import 하는 대신 이렇게 aa 패키지를 앞에 붙여주면 됨.
		car1.print();
		System.out.println("AAAA"); // static import 를 사용하지 않았을 때
		out.println("bbb"); // static import 를 이용
		
	}
}