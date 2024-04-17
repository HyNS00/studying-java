package Yalco.sec11.chap03;

public class Test {
    public static void main(String[] args) {
        int no = 0;
        String kk = "쿵ㅁ짝";
        for (int i = 0; i < 21; i++){
            System.out.print(kk.charAt(no++) + " ");
            no %= kk.length();
            /*
            % <- a를 b로 나누다
             a가 분자 b가 분모

             no가 처음에 0이니까 쿵
             no++로 1이 되고, 1 % 3 = 1 -> ㅁ
             no++로 2가 되고, 2%3 = 2 -> 짝
             no ++로 3이 되어도 나머지는 0이니까
             인덱스를 넘어가지 않는다.
             */
        }
    }
}
