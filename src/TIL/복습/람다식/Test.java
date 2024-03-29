package TIL.복습.람다식;

import TIL.복습.람다식.Student;

import java.util.*;
import java.util.stream.*;
public class Test {
    public static void main(String[] args) {
        List<Student> totalList = new ArrayList<>();
        totalList.add(new Student("gd", "남", 32));
        totalList.add(new Student("g3", "남", 82));
        totalList.add(new Student("g4", "여", 95));
        totalList.add(new Student("g5", "여", 87));

        Map<String, Double> map = totalList.stream().collect(
                Collectors.groupingBy(
                        s -> s.getSex(),
                        Collectors.averagingDouble(s -> s.getScore())
                )
        );
    }
}