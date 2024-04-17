package Yalco.sec04.chap06;

public class Ex02 {
    public static void main(String[] args) {
        // 원시값은 복사해서 가져옴
        // 메소드 내부에서 값을 변형해도 원본에 영향을 주지 않는다
        int intNum = 3;
        modifyingIntArg(intNum);

        int[] intNums = {1, 2, 3};

        //  배열은 참조형이지만 그 안의 값들은 원시형
        modifyingIntArg(intNums[0]);

        //  참조형인 배열 자체를 인자로 사용
        modifyingAryElem(intNums);

    }
    static void modifyingIntArg(int num){
        System.out.printf("수정 전 :%d%n", num++);
        System.out.printf("수정 후 :%d%n", num);
    }
    // 참조값은 주소값이므로 원본 그 자체를 가리킴
    static void modifyingAryElem (int [] ary){
        System.out.printf("수정 전 : %d%n", ary[1]++);
        System.out.printf("수정 후 :%d%n", ary[1]);
    }
}
