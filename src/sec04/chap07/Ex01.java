
package sec04.chap07;
import java.util.Scanner;
public class Ex01 {
    public static void main(String[] args) {
        // Scanner는 키보드 입력이나 파일등으로부터 텍스트 값을 받아오기 위한 것
        // System.in : InputSystem의 인스턴스 , 입력받은 값들의 흐름
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        String str3 = sc.nextLine();


        System.out.println("str1" + str1);
        System.out.println("str2" + str2);
        System.out.println("str3" + str3);
        // next : 스페이스를 비롯한 공백단위로 끊어서 (토큰으로)문자열을 받음
        // nextLine : 줄바꿈 단위로 끊어서 문자열을 받음
    }
}
