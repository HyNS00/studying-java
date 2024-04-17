package Yalco.sec03.chap06;

public class Ex08 {
    public static void main(String[] args) {
        String str_a1 = "덜컹";

        // repeat : 문자열을 주어진 정수만큼 반복한다
        String str_a2 = str_a1.repeat(2);
        String str_a3 = str_a1
                .concat(" ") // 공백과 합침 "덜컹 "
                .repeat(3) // 3번 반복
                .trim();
        // trim은 양끝의 공백을 제거해주는 역할을 한다.


        String str_b1 = "대한민국 다 job 구하라 그래";

        // substring: ~번 째 문자부터 (~번 째 문자까지) 잘라서 반환
        String str_b2 = str_b1.substring(7);
        String str_b3 = str_b1.substring(7,10);
        String str_b4 = str_b1.substring(11,14);

        String piece1 = "다 ";
        String piece2 = "구하라";
        int test = str_b1.indexOf(piece1);
        String str_b5 = str_b1.substring(
                str_b1.indexOf(piece1),
                str_b1.indexOf(piece2)+piece2.length()
        );
        // indexOf : 해당 문자열에 인덱스를 반환


        // replace : 주어진 앞의 문자(열)을 뒤에 문자(열)로 치환
        String str_c1 = "점심에 보쌈집에 가서 수육을 먹었다.";
        String str_c2 = str_c1.replace("보쌈", "중국");

        //  여럿 포함시 모두 치환
        String str_c3 = "밥 좀 먹자, 응? 야, 밥 좀 먹자고 밥 밥 밥";
        String str_c4 = str_c3.replace('밥', '빵');
        // ⭐️ 원본은 바뀌지 않는 점 확인

        //  메서드 체이닝
        String str_d1 = "하여튼 호의가 반복되면 권리인 줄 알아";
        String str_d2 = str_d1
                .replace("하여튼" ,"아무튼")
                .replace("호의","호이.repeat(2)")
                .replace("권리","둘리");
        // 메서드 안에 들어가는 문자열도 .repeat을 통해 반복
        // 메서드안에 메서드 + 메서드 체이닝



        String str_e1 = "02=123.4567_8900";

        // replaceAll : 전부치환
        // replaceFirst : 첫 번째 일치부분만 치환 -> 처음으로 만난 기존문자만 변경되고 나머지는 그대로
        String str_e2 = str_e1
                .replaceAll("[=._]","-")
                .replaceFirst("[-@#]",")");

    }
}
