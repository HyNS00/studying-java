package TIL.복습.생성자;

public class Employee extends Normal{
    private String dept;

    public Employee(){
        System.out.println("Employee 생성자 실행");

        /* 첫 번째 생성자에서 super();를 명시하지 않더라도 컴파일러는 부모 클래스인 Normal 클래스의 기본 생성자를 자동으로 호출합니다.
        이 경우에는 super();가 자동으로 삽입되어 부모 클래스의 기본 생성자를 호출합니다
         */
    }

    public Employee(String name, int age, String dept){
        super(name,age);
        this.dept = dept;
        System.out.println("EMPLOYEE 생성자 실행2");
    }
}
