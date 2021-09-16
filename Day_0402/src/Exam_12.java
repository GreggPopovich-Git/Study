
public class Exam_12 {
	public static void main(String[] args) {
		int cnt = 0;
		for(int x=1; x<=5; x++) {
	    	  for(int k=4; k>=x; k--) {
	    		  System.out.print("\t");
	    	  }
	          for(int y=1; y<=x; y++) {
	        	 cnt++;
	             System.out.print(cnt + "\t");
	          }
	          System.out.println();
	       }

	}

}
