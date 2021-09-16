public class Exam_10 {

   public static void main(String[] args) {
      
      
      for(int x=1; x<=5; x++) {   //줄수
         for(int y=1; y<=5; y++) { //줄당 칸수
            System.out.print("*");
         }
         System.out.println();
      }
      System.out.println("----------------------");
      int cnt=0;
      
      for(int x=1; x<=5; x++) {   //줄수
         
         for(int y=1; y<=5; y++) { //줄당 칸수
            cnt++;
            System.out.print(cnt+"\t");
         }
         System.out.println();
      }
   }
}
