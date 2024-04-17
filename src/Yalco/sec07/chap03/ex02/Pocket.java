package Yalco.sec07.chap03.ex02;

public class Pocket<T1,T2,T3> { // 서로 다른 자료형 3개가 들어간다.
    private T1 fieldA; // 각각의 자료형을 가지는 필드 3개
    private T2 fieldB;
    private T3 fieldC;

    public Pocket(T1 fieldA, T2 fieldB, T3 fieldC){
        this.fieldA = fieldA;
        this.fieldB = fieldB;
        this.fieldC = fieldC;

    }

    public T1 getFieldA(){
        return fieldA;
    }

    public T2 getFieldB(){
        return fieldB;
    }

    public T3 getFieldC(){
        return fieldC;
    }

}
