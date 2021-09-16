import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("선수 인원 : ");
		int people = scn.nextInt();
		int[][] score = new int[people*2][22];
		String[] name = new String[people*2];
		int cnt = 0;
		int scoreInput = 0;
		//Data Input
		for (int x = 0; x < people*2; x++) {
			if (x % 2 == 0 && people == 1) {
				System.out.print("선수 이름 : ");
				name[x] = scn.next();
			}
			else if (x % 2 == 0 && people != 1) {
				cnt++;
				System.out.print(cnt + "번째 선수 이름 : ");
				name[x] = scn.next();
			}
			else
				name[x] = "합계";
		}
		cnt = 0;
		for (int y = 0; y < 21; y++) {
			if (y % 2 == 0)
				cnt++;
			for (int x = 0; x < score.length; x += 2) {
				if (y < 20)
					System.out.print(name[x] + " 선수 " + cnt + "프레임 " + (y % 2 + 1) + "번째 시도 : ");
				else
					System.out.print(name[x] + " 선수 10프레임 " + "3번째 시도 : ");
				scoreInput = scn.nextInt();
				if (y % 2 == 0 && scoreInput > 10) {
					System.out.println("입력오류 다시 입력하세요");
					x -= 2;
					continue;
				}
				else if (y % 2 == 1 && (scoreInput+score[x][y-1]) > 10 && y != 19) {
					System.out.println("입력오류 다시 입력하세요");
					x -= 2;
					continue;
				}
				if (y == 18 && (scoreInput+score[x][y-1]) == 10 && scoreInput > 10) {
					System.out.println("입력오류 다시 입력하세요");
					x -= 2;
					continue;
				}
				score[x][y] = scoreInput;
				if (y % 2 == 0 && scoreInput == 10 && y != 18) {
					System.out.println("Strike !");
				}
				else if (y % 2 == 1 && (scoreInput+score[x][y-1]) == 10)
					System.out.println("Spare !");
				else if (y == 19 || y == 18 && scoreInput == 10)
					System.out.println("Strike !");
			}
		}
		//출력시 합계&총점 하나만 나와야함. 스트라이크/스페어/거터 메세지 출력.
		
		
		
		
		//Data Output
		System.out.println("선수\t1프레임\t\t2프레임\t\t3프레임\t\t4프레임\t\t5프레임\t\t6프레임\t\t7프레임\t\t8프레임\t\t9프레임\t\t10프레임\t\t\t총점");
		for (int x = 0; x < score.length; x++) {
			System.out.print(name[x] + "\t");
			for (int y = 0; y < score[x].length; y++) {
				if (y % 2 == 1 && y != 19 && y !=21 || y == 20)
					System.out.print(score[x][y] + "|" + "\t");
				else if (y % 2 == 0 && y != 20)
					System.out.print("|" + score[x][y] + "\t");
				else if (y == 19 || y == 21)
					System.out.print(score[x][y] + "\t");
			}
			System.out.println();
			if (x % 2 == 1)
				System.out.println();
		}
		scn.close();
	}
}





신준섭 755336
배근호 815618
안중현 954989
최연우 684634

1 신준섭 31
2 배근호 65
3 안중현 43
4 김종주 29
5 홍길동 35
6 이순신 23
7 최연우 52
8 박길영 12
9 강감찬 5
3 김슬기 23
2 배슬기 31
6 연산군 55
10 이완용 99

1 1 62
1 2 85
1 3 49
2 1 65
2 2 70
2 3 94
3 1 54
3 2 66
3 3 71



1101 홍길동 90 85 75
1102 배근호 99 88 77
1103 신준섭 69 79 89
1104 안중현 91 81 71
1105 김지현 16 76 99
1106 이순신 55 55 55
1107 최연우 39 39 39

인사 1101 김사원 654813
인사 1102 박사원 698488
총무 1201 이사원 565485
총무 1202 최사원 984321
총무 1203 배사원 656123
마케팅 1301 안사원 516516
마케팅 1302 신사원 891983

user01 1 25
user02 3 45
user03 2 52
user04 1 55
user05 2 33
user06 3 44
user07 2 50

홍길동,900206-1,010-2242-3810
김자바,071015-4,010-1111-2222
홍자동,890723-1,010-2222-3333
배근호,900506-5,010-1234-1234
신준섭,891212-6,010-4321-4321
안중현,000202-7,010-7890-7890
최연우,000101-8,010-0000-0000
김종주,200202-4,010-3333-3333
박길영,170808-3,010-9999-9999

1103,90,85,99
1105,77,88,85
1104,75,81,71
1101,65,65,65
1102,46,64,55

1101,이학생,F,91,80,77,66,78,89,88,87,68,99
1102,박학생,F,92,82,72,62,72,82,82,82,62,92
1103,김학생,M,93,82,73,63,73,83,83,83,63,93
1104,강학생,M,94,80,77,66,78,89,88,87,68,99

1103,김학생,90 85 99
1105,박학생,77 88 85
1104,이학생,75 81 71
1101,최학생,65 65 65
1102,배학생,46 64 55


user02,bbb,3056
user03,ccc,3121
user01,fff,2923
user02,bbb,9921
user04,ddd,3432
user01,aaa,2965

// java
// mySQL
// ORACLE DB
// jsp
// spring