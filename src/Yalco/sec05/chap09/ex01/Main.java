package Yalco.sec05.chap09.ex01;

public class Main {
    public static void main(String[] args) {
        // 다형성
        PolarBear polarBear = new PolarBear();
        Mamal mamal = polarBear;
        Swimmer swimmer  = polarBear;
        // 북극곰은 Mamal의 하위클래스, Swimmer를 가지고 있으므로 각각의 자료형으로 사용될 수 있다.

        GlidingLizard glidingLizard = new GlidingLizard();
        Eagle eagle = new Eagle();

        Hunter[] hunters = {
                polarBear,glidingLizard,eagle
        };

        // 북극곰, 날도마뱀, 독수리는 Hunter 인터페이스를 구현하고 있다.
        // 따라서 Hunter배열로 함께 묶일 수 있다.
        for (Hunter hunter : hunters){
            hunter.hunt();
        }
    }
}
