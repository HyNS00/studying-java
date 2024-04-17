package Yalco.sec03.chap08;

public class Ex07 {
    public static void main(String[] args) {
        String[] strings = {"한놈", "두시기", "석삼", "너구리"};

        // join 문자열의 배열의 사이를 붙임(연결)
        // split과는 반대 느낌
        String join1 = String.join(", ", strings);
        String join2 = String.join("-",strings);
        String join3 = String.join(" 그리고 ", strings);
        String join4 = String.join("",strings);
    }
}
