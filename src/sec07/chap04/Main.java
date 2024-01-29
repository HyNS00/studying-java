package sec07.chap04;

public class Main {
    public static void main(String[] args) {
        NotCloneable notCloneable = new NotCloneable(
                "클릭들 1", 1, new int[] {1, 2, 3},
                new Click(12, 34),
                new Click[] { new Click(12, 34), new Click(56, 78) }
        );

        NotCloneable clone1 = null;

        try { // ❓ try 문 : 오류에 대비하기 섹션에서 배울 것
            clone1 = (NotCloneable) notCloneable.clone();
        } catch (CloneNotSupportedException e) {
            System.out.printf("⚠️ 복제중 오류 발생 : %s%n", notCloneable);
        }
        //  ⚠️ 복사 실패 - CloneNotSupportedException 이라는 오류 발생
    }
}
