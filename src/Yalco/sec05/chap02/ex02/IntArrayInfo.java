package Yalco.sec05.chap02.ex02;

public class IntArrayInfo {
    int count;
    int max;
    int min;
    int sum;
    double average;

    // 인스턴스를 만들 때 int배열이 들어와야한다.
    IntArrayInfo(int[] nums){
        count = nums.length;
        max = nums[0];
        min = nums[0];

        for (int num : nums){
            // 루프내에 num변수 또는 배열 num의 컬렉션
            max = max > num ? max : num;
            min = min < num ? min : num;
            sum += num;
        }

        // 소수부를 잃지 않도록 하여 1.0을 곱하여 double 생성
        average = 1.0 * sum /nums.length;
    }
}
