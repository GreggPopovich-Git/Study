import java.net.InetAddress;

public class NetExam_02 {

	public static void main(String[] args) throws Exception {
		InetAddress google = InetAddress.getByName("www.google.com");
		System.out.println(google);
		System.out.println(google.getHostName());
		System.out.println(google.getHostAddress());
		
		InetAddress[] daum = InetAddress.getAllByName("www.daum.net");
		for(int x = 0; x < daum.length; x++) {
			System.out.println(daum[x]);
		}
	}

}
