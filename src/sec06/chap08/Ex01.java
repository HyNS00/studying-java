package sec06.chap08;

public class Ex01 {
    public static void main(String[] args) {
        // Math 클래스
        // 인스턴스를 만들 수 없다.
        // 생성자가 private

        // 정적 필드
        double e = Math.E;
        double pi = Math.PI;

        // 정적 메소드

        // 절대값. 숫자 자료형마다 오버로드
        int absInt = Math.abs(-5);
        double absDbl = Math.abs(-3.14);

        // 올림,내림,반올림
        double ceil = Math.ceil(2.34);
        double floor = Math.floor(4.56);
        double round = Math.round(2.34);
        double round2 = Math.round(4.56);

        // 큰 수 작은수 반환, 자료형마다 오버로드
        int largeInt = Math.max(2,3);
        double smallerInt = Math.min(1.2,3.4);

        // 제곱
        double pow1 = Math.pow(4,3);
        // .pow의 자료형은 double int로 표현하고 싶다면 캐스팅(casting)사용
        int pow3 = (int) Math.pow(4,3);
        double pow2 = Math.pow(4,0.5);

        // 0.0 이상 1.0미만 무작위 수
        double rand1 = Math.random();
        double rand2 = Math.random();
        double rand3 = Math.random();

        // 1에서 10사이의 무작위 수
        int rand4 = (int) Math.ceil(Math.random() * 10);
        int rand5 = (int) Math.floor(Math.random() * 10) +1;

        // ~Exact 메소드 : 자료형의 범위를 넘기면 오류 발생
        int add1 = Math.addExact(2_147_483_645,2); // 2147483645 에 2를 더한 값이 int자료형의 범위를 벗어나면 오류발생
//        int add2 = 2_147_483_645 + 3;
//        int add3 = Math.addExact(2_147_483_645, 3);
    }
}
