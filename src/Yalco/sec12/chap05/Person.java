package Yalco.sec12.chap05;

import java.io.Serializable;
// 직렬화
/*직렬화(serialization)는 프로그래밍에서 데이터 구조나 객체를 파일이나 네트워크를 통해 전송 가능한 형태로 변환하는 과정을 말합니다.
 이는 데이터를 저장하거나 전송하기 위해 메모리 상에 있는 객체나 데이터를 바이트 스트림으로 변환하는 것을 의미합니다.
 직렬화된 데이터는 반대 과정인 역직렬화(deserialization)를 통해 다시 원래의 데이터 구조나 객체로 복원할 수 있습니다.
 역직렬화는 직렬화된 데이터를 읽어와서 메모리에 객체나 데이터를 재구성하는 과정을 의미합니다.*/

public class Person implements Serializable {
    //  💡 serialVersionUID : 클래스의 버전 번호로 사용
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    private double height;
    private boolean married;

    // transient : 직렬화에서 제외
    transient private String bloodType;
    transient private double weight;

    // 직렬화에 포함되려면 해당 클래스도 Serializable을 구현해야한다.
    private Career career;

    public Person(String name, int age, double height, boolean married, String bloodType, double weight, Career career) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.married = married;
        this.bloodType = bloodType;
        this.weight = weight;
        this.career = career;
    }


}
