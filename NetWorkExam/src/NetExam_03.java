import java.net.URL;

public class NetExam_03 {

	public static void main(String[] args) throws Exception {
		URL oracle  = new URL("https://docs.oracle.com/javase/8/docs/api/");
		System.out.println("Host : " + oracle.getHost());
		System.out.println("Protocol : " + oracle.getProtocol());
		System.out.println("Port : " + oracle.getPort());
		System.out.println("File : " + oracle.getFile());
		System.out.println("URL : " + oracle.toExternalForm());
		
	}

}
