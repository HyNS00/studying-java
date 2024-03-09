package TIL.복습.toString;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Jp",12);

        System.out.printf("%s의 나이는 %d입니다%n",person.getName(), person.getAge());
        System.out.println(person);

    }
}
