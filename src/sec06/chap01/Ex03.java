package sec06.chap01;

public class Ex03 {
    public static void main(String[] args) {
        String str = "바깥쪽";
        {
//            String str = "안쪽"; // ⚠️ 불가
        }

        while (true) {
//            String str = "안쪽"; // ⚠️ 불가
        }

        // 밖에 있는 것을 안쪽으로 같은 이름으로 덮어쓰는것이 불가능

    }
}
