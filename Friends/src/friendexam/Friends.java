package friendexam;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Friends implements Serializable {
	String name, birth, tel, date;
	Friends(){}
	Friends(String name, String birth, String tel) {
		Date dt = new Date();
		SimpleDateFormat df = new SimpleDateFormat("YYYY년MM월dd일");
		this.name = name;
		this.birth = birth.substring(0, 4) + "년" + birth.substring(4, 6) + "월" + birth.substring(6) + "일";
		this.tel = tel.substring(0, 3) + "-" + tel.substring(3, 7) + "-" + tel.substring(7);
		this.date = df.format(dt);
	}
	@Override
	public String toString() {
		return name + "\t" + birth + "\t" + tel + "\t" + date;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Friends)
			return tel.equalsIgnoreCase(((Friends)obj).tel);
		else return false;
	}
}
