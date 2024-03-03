package sec07.chap03.ex02;

public class Main {
    public static void main(String[] args) {
        // 선언시 자료형에 각 타입변수의 자료형을 명시
        // 제네릭에는 원시값이 아닌 클래스만 가능
        Pocket<Double, Double, Double> size3d1 =
                new Pocket<>(123.45,234.56,345.67);

        double width = size3d1.getFieldA();
        double height = size3d1.getFieldB();
        double depth = size3d1.getFieldC();

        Pocket<String, Integer, Boolean> person =
                new Pocket<>("홍길동", 20,false);

        //  제네릭 클래스는 배열 생성시 new로 초기화 필수
        Pocket<String, Integer, Boolean>[] people = new Pocket[] {
                new Pocket<>("홍길동", 20, false),
                new Pocket<>("전우치", 30, true),
                new Pocket<>("임꺽정", 27, true),
        };
    }
}
