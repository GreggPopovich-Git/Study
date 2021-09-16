package friendexam;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FriendsMethod {
	
	// 친구등록
	public void insert() throws Exception {
		Scanner scn = new Scanner(System.in);
		File file = new File("friends.dat");
		List<Friends> fList = new ArrayList<Friends>();
		System.out.print("친구정보 입력 : ");
		String[] friend = scn.next().split(",");
		Friends frd = new Friends(friend[0], friend[1], friend[2]);
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			fList = (List) ois.readObject();
		}
		if (!fList.contains(frd)) {
			fList.add(frd);
			System.out.println("등록되었습니다.");
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(file)));
			oos.writeObject(fList);
			oos.close();
		} else
			System.out.println("중복된 친구가 있습니다.");
	}
	// 전체출력
	public void print() throws Exception {
		File file = new File("friends.dat");
		List<Friends> fList = new ArrayList<Friends>();
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			fList = (List) ois.readObject();
		}
		System.out.println("이름\t생년월일\t\t전화번호\t\t등록일자");
		for (int x = 0; x < fList.size(); x++) {
			System.out.println(fList.get(x));
		}
	}
	// 친구찾기
	public void search() throws Exception {
		Scanner scn = new Scanner(System.in);
		File file = new File("friends.dat");
		List<Friends> fList = new ArrayList<Friends>();
		System.out.print("친구의 이름이나 전화번호 뒷자리를 입력해 주세요 : ");
		String search = scn.next();
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			fList = (List) ois.readObject();
		}
		boolean flag = true;
		System.out.println("이름\t생년월일\t\t전화번호\t\t등록일자");
		for (int x = 0; x < fList.size(); x++) {
			if (fList.get(x).name.equalsIgnoreCase(search) || fList.get(x).tel.contains(search)) {
				System.out.println(fList.get(x));
				flag = false;
			}
		}
		if (flag)
			System.out.println("등록된 친구가 없습니다.");
	}
	// 친구수정
	public void modify() throws Exception {
		Scanner scn = new Scanner(System.in);
		File file = new File("friends.dat");
		List<Friends> fList = new ArrayList<Friends>();
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			fList = (List) ois.readObject();
		}
		System.out.print("수정 또는 삭제 할 친구이름이나 전화번호 뒷자리를 입력해 주세요 : ");
		String search = scn.next();
		boolean flag = true;
		for (int x = 0; x < fList.size(); x++) {
			if (fList.get(x).name.equalsIgnoreCase(search) || fList.get(x).tel.contains(search))
				flag = false;
		}
		if (flag)
			System.out.println("등록된 친구가 없습니다.");
		else {
			System.out.print("[1]수정 [2]삭제 : ");
			int temp2 = scn.nextInt();
			if (temp2 == 1) {
				for (int x = 0; x < fList.size(); x++) {
					if (fList.get(x).name.equalsIgnoreCase(search) || fList.get(x).tel.contains(search)) {
						fList.remove(x);
					}
				}
				System.out.print("친구정보 입력 : ");
				String[] friend = scn.next().split(",");
				Friends frd = new Friends(friend[0], friend[1], friend[2]);
				fList.add(frd);
				System.out.println("수정되었습니다.");
				ObjectOutputStream oos = new ObjectOutputStream(
						new BufferedOutputStream(new FileOutputStream(file)));
				oos.writeObject(fList);
				oos.close();
			} else if (temp2 == 2) {
				delete(search);
			} else
				System.out.println("잘못 입력 하셨습니다.");
		}
	}
	// 친구손절
	public void delete(String search) throws Exception {
		File file = new File("friends.dat");
		List<Friends> fList = new ArrayList<Friends>();
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			fList = (List) ois.readObject();
		}
		for (int x = 0; x < fList.size(); x++) {
			if (fList.get(x).name.equalsIgnoreCase(search) || fList.get(x).tel.contains(search)) {
				fList.remove(x);
				System.out.println("삭제되었습니다.");
			}
		}
		ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file)));
		oos.writeObject(fList);
		oos.close();
	}
}