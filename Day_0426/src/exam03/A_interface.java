package exam03;

public interface A_interface {
	void method_01();
	void method_02();
	
	default void aa() {
		System.out.println("aa테스트");
	}
	static void bb() {
		System.out.println("bb테스트");
	}

}
