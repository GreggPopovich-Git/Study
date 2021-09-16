import java.net.InetAddress;

public class NetExam_01 {

	public static void main(String[] args) throws Exception {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("LocalHost Name/IP : " + address);
		System.out.println("LocalHost Name : " + address.getHostName());
		System.out.println("LocalHost IP : " + address.getHostAddress());
	}

}
