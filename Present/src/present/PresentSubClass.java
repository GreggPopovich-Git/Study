package present;
public class PresentSubClass implements PresentInterface {
	int price[];
	int tot;
	String pricecomma;
	String name[];
	int cnt;
	PresentSubClass(int price[], String name[], int cnt) {
		this.name = name;
		this.cnt = cnt;
		this.price = price;
		for (int i = 0; i < price.length; i++) {
			if (price[i] == 0)
				break;
			tot += price[i];
		}
	}
	@Override
	public String comma(int price) {
		pricecomma = price + "";
		int pricelength = pricecomma.length();
		int commacnt = pricelength / 3;
		int commafirst = pricelength % 3;
		
		StringBuffer pc = new StringBuffer(pricecomma);
		for (int i = 0; i < commacnt; i++) {
			if (i == 0 && commafirst != 0) {
				pricecomma = pc.insert(commafirst, ",").toString();
				commafirst++;
			}
			else if (i != 0)
				pricecomma = pc.insert(commafirst + (3 * i) + i - 1, ",").toString();
		}
		return pricecomma;
	}
	@Override
	public void print() {
		for (int x = 0; x < cnt; x++) {
			if (x == (cnt-1))
				System.out.println("+" + String.format("%9s", comma(price[x])) + "\t" + name[x]);
			else
				System.out.println(String.format("%10s", comma(price[x])) + "\t" + name[x]);
		}
		System.out.println("-------------------------");
		System.out.println(String.format("%10s", comma(tot)) + "\t총합");
	}
}