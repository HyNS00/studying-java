package sec07.chap02;

public class Ex02 {
    public static void main(String[] args) {
        //  💡 박싱 : 원시값을 래퍼 클래스의 인스턴스로
        // 기본 데이터 타입을 해당하는 래퍼 클래스 객체로 변환하는 과정.
        int intPrim1 = 123;
        Integer intInst1 = Integer.valueOf(intPrim1);

        char chrPrim1 = 'A';
        Character chrInst1 = Character.valueOf(chrPrim1);

        // 언박싱 :래퍼 클래스 객체를 해당하는 기본 데이터 타입으로 변환하는 과정
        // .자료형Value을 사용
        Double dblInst1 = Double.valueOf(3.14);
        double dblPrim1 = dblInst1.doubleValue();

        Boolean blnInst1 = Boolean.valueOf(true);
        boolean blnPrim1 = blnInst1.booleanValue();


        // 오토 언박싱 & 오토 박싱
        // 명시적으로 하지 않아도 컴파일러가 자동으로 처리해준다.
        // 👹 성능상으로 떨어지므로 자주 사용은 하지말자

        // 오토 박싱
        Integer intInst2 = 234;
        Double dblInst2 = 1.414213;

        // 오토 언박싱
        char chrPrim2 = Character.valueOf('B');
        boolean blnPrim2 = Boolean.valueOf(false);

        // 원시값과 래핑 클래스 인스턴스끼리의 연산
        int intPrim2 = intPrim1 + intInst1;
        Integer intInst3 = intPrim2 + intInst2;

        Integer intInst4 = add(3, 5);
    }
    static int add(Integer a, Integer b){
        return a+b;
    }
}
