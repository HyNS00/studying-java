package sec03.chap08;

public class Ex03 {
    public static void main(String[] args) {
        // 이중배열
        boolean[][] dblBoolAry = new boolean[3][3];
        int[][] dblIntAry = new int[][] {
                //  ⭐️ 요소 배열의 크기가 다를 수 있음
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9},
        };
        // 그냥 숫자를 써주지말고 일단 그냥 선언으로 가능
        // 그리고 표시는 int[3][] 3개는 변하지 않고 그 외는 따로 이미 저장되어잇다.
        // C언어에서와 같다
        //  삼중 배열
        char[][][] trpChrAry = {
                {{'자', '축'}, {'인', '묘'}},
                {{'진', '사'}, {'오', '미'}},
                {{'신', '유'}, {'술', '해'}},
        };

        int int1 = dblIntAry[0][1];
        int int2 = dblIntAry[2][3];
        int[] intAry = dblIntAry[1];

        char[][] dblChrAry = trpChrAry[0];
        char[] chrAry = dblChrAry[0];
        char chr1 = chrAry[1];
        char chr2 = trpChrAry[2][0][1];
    }
}
