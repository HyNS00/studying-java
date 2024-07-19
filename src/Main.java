import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("a", "b", "c");
        System.out.println(list2.containsAll(list1));
        System.out.println(list1.containsAll(list2));
    }
}