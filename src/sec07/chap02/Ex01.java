package sec07.chap02;

public class Ex01 {
    public static void main(String[] args) {
        // 원시자료형
        int int1 = 123;
        double dbl1 = 3.14;
        char chr1 = 'A';
        boolean bln1 = true;


        //  ⭐ 해당 래퍼 클래스의 인스턴스
        //  기존의 생성자 방식
        //  ⚠️ 오늘날에는 deprecated - 성능상 좋지 않음
        // 권장되지 않는 방식
        Integer int2= new Integer(123);
        Double  dbl2 = new Double(3.14);
        Character chr2 = new Character('A');
        Boolean bln2 = new Boolean(true);

        // 권장되는 방식
        Integer int3 = Integer.valueOf(123);
        Double dbl3 = Double.valueOf(3.14);
        Character chr3 = Character.valueOf('A');
        Boolean bln3 = Boolean.valueOf(true);
    }
}
