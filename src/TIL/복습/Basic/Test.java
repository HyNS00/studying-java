package TIL.복습.Basic;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> list2 = Arrays.asList("10,20,30","40,50");
        List<Integer> result = new ArrayList<>();
        for (String str : list2){
            String[] parts = str.split(",");
            int[] intArr = new int[parts.length];
//            for(int i = 0; i < parts.length; i++){
//                intArr[i] = Integer.parseInt(parts[i]);
//                result.add(intArr[i]);
//                // 위를 좀 더 다듬기
//
//            }
            for(String part : parts){
                result.add(Integer.parseInt(part));
            }
        }
        System.out.println(result);
   }
}
