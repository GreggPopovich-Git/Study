import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
// Class 클래스 - 클래스의 정보를 담을 수 있고 정보를 꺼내오는데 사용.
class Person {
	String name;
	int age;
	
	void personPrint() {
		System.out.println("name : " + name + "\nage : " + age);
	}
	@Override
	public String toString() {
		return name + "\t" + age;
	}
}
public class Exam_07 {

	public static void main(String[] args) {
		Person p = new Person();
		//Class 객체를 생성하는 4가지 방법
		Class c = p.getClass();
		/*
		Class c1 = new Person().getClass();
		Class c2 = Person.class;
		try {
		Class c3 = Class.forName("Person");
		}catch(Exception e) {}
		*/
		System.out.println(c.getName());
		System.out.println(c.toString());
		System.out.println("맴버 필드 출력");
		System.out.println(Arrays.toString(c.getDeclaredFields()));
		Field[] field = c.getDeclaredFields();
		System.out.println(Arrays.toString(field));
		System.out.println(Arrays.toString(c.getDeclaredMethods()));
		Method[] methods = c.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println("메소드 명 : " + method.getName());
			System.out.println("리턴타입 : " + method.getReturnType());
			System.out.println("파라미터 : " + method.getParameterCount());
			System.out.println("-------------------------------------");
		}
		
	}

}