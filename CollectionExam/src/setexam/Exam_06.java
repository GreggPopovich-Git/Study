package setexam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/* 키보드로 id, 이름, 전화번호를 입력 Person 객체를 생성 Set에 저장하는 프로그램 작성 (단, id가 같으면 "id 중복" 에러 출력 후 재입력
 * id가 end이면 전체 자료를 출력 후 종료
 */
class Person {
	String id, name, phoneNum;
	
	Person(){}
	Person(String id, String name, String phoneNum) {
		this.id = id;
		this.name = name;
		this.phoneNum = phoneNum;
	}
	@Override
		public String toString() {
			return id + " " + name + " " + phoneNum;
		}
	@Override
	public boolean equals(Object obj) {
		boolean bool = false;
		if (obj != null && obj instanceof Person) {
			if (id.equals(((Person)obj).id))
				bool = true;
		}
		return bool;
	}
	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
public class Exam_06 {

	public static void main(String[] args) {
		Set<Person> pSet = new HashSet<Person>();
		Scanner scn = new Scanner(System.in);
		for(;;) {
			System.out.print("회원정보 등록 : ");
			String[] per = scn.nextLine().split(",");
			if(per[0].equalsIgnoreCase("end"))
				break;
			Person p = new Person(per[0],per[1],per[2]);
			boolean bool = pSet.add(p);
			if (!bool)
				System.out.println("중복");
		}
		List<Person> pList = new ArrayList<Person>(pSet);
		personSort(pList);
		System.out.println(pList);
		scn.close();
		
	}
	
	static void personSort(List<Person> list) {
		for (int x = 0; x < list.size()-1; x++) {
			for(int y = x + 1; y < list.size(); y++) {
				Person per1 = list.get(x);
				Person per2 = list.get(y);
				if (per1.id.hashCode() > per2.id.hashCode()) {
					list.set(y, per1);
					list.set(x, per2);
				}
			}
		}
	}

}
