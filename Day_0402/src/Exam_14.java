
public class Exam_14 {
	public static void main(String[] args) {
		for(int x=1; x<=5; x++) {
	        for(int y=1; y<=x-1; y++) {
		          System.out.print(" ");
		      }
			for(int k=5; k>=x; k--) {
	    		  System.out.print("*");
	    	  }
	          System.out.println();
	       }

	}

}
