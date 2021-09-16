package sawon;
public class Sawon {
	String id;
	int clas;
	int time;
	int pay;
	int weekpay;
	Sawon(){}
	Sawon(String id, int clas, int time) {
		this.id = id;
		this.clas = clas;
		this.time = time;
		if(clas == 1)
			pay = 10000;
		else if (clas == 2)
			pay = 5000;
		else
			pay = 2000;
		if (time > 50)
			time = 50;
		if (time <= 36)
			weekpay = time * pay;
		else if (time > 36)
			weekpay = (int)(36 * pay + ((time-36) * (pay * 1.5)));
	}
}