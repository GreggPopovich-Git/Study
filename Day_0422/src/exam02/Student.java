package exam02;

public class Student {
   String hakbun;//학번
   String irum;//이름
   String gender;//성별
   int score;//점수
   public Student() {}
   public Student(String hakbun, String irum, String gender,int score) {
      this.hakbun=hakbun;
      this.irum=irum;
      this.gender=gender;
      this.score=score;
   }
   void stuTitle() {
      System.out.println("학번\t이름\t성별\t점수");
   }
   void stuPrint() {
      String imsi="여";
      if(gender.equalsIgnoreCase("m")) {
         imsi="남";
      }
      System.out.println(hakbun+"\t"+irum+"\t"+imsi+"\t"+score);
   }
}