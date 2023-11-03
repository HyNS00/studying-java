package sec03.chap06;

public class Ex03 {
    public static void main(String[] args) {
        // 문자열 반환
        String str1 = "아야 슬슬 오함마 준비해야 쓰것다";
        // charAt -> ~번 째 문자 반환 , 인덱스사용 + 문자열아님 문자반환
        char ch1 = str1.charAt(0);
        char ch2 = str1.charAt(4);

        // 문자의 위치 반환
        String str2 = "얄리 얄리 얄라셩 얄라리 얄라";
        //  💡 indexOf/lastIndexOf : 일치하는 첫/마지막 문자열의 위치
        //  앞에서부터 카운트해서 int로 반환

        //  두 번째 인자 : ~번째 이후/이전부터 셈

        int int1 = str2.indexOf("얄");
        int int2 = str2.indexOf("얄",4);
        // int2는 인덱스 값으로 4 이후 "얄"이 나오는 인덱스반환

        int  int3 = str2.indexOf("얄라");
        int  int4 = str2.lastIndexOf("얄라");
        // lastIndexOf니까 마지막으로부터세는데 , 숫자가있으니 그 숫자 이전으로부터 마지막
        // 12의 전의  "얄라"는 10
        int  int5 = str2.lastIndexOf("얄라", 12);

        //  💡 포함되지 않은 문자는 -1 반환
        int int6 = str2.indexOf('욜');
    }
}
