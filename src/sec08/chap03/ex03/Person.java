package sec08.chap03.ex03;
import java.util.*;

public class Person implements Comparable<Person>{
    private static int lastNo = 0;
    private int no;
    private String name;
    private int age;
    private double height;

    public Person(String name, int age, double height) {
        this.no = ++lastNo;
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public int compareTo(Person p){
        return this.getName().compareTo(p.getName());
    } // 정렬기준 -> 아무런 기준도 넣어주지 않으면 compareTo에 의해 이름순(가나다)으로 정렬

    @Override
    public String toString(){
        return "Person{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
