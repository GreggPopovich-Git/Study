package exam02;

public class SuperInterfaceExam implements Superinterface { // implements : 구현

	@Override // 어노테이션
	public void exam() {
		System.out.println("AAA");
	}

	@Override // 어노테이션
	public void sum(int x) {
		int tot = 0;
		for (int i = x; i <= MAX; i++) {
			tot += i;
		}
		System.out.println(tot);
	}

}