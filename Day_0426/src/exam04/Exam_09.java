package exam04;
interface E_interface extends D_interface {
	void exam_01();
}

class S_class implements E_interface {

	@Override
	public int method_01() {
		
		return 0;
	}

	@Override
	public void method_02(int n, int m) {
		
		
	}

	@Override
	public void exam_01() {
		
		
	}
	
}
public class Exam_09 {
	public static void main(String[] args) {
		S_class sclass = new S_class();
		sclass.exam_01();
		sclass.method_01();
		sclass.method_02(1, 2);
		E_interface e = new S_class();
		e.exam_01();
		e.method_01();
		e.method_02(1, 2);
		D_interface d = new S_class();
		d.method_01();
		d.method_02(1, 10);
	}

}
