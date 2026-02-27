package dsa.sort;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //191, 203, 65, 293, 59,603, 105, 101, 301, 1001, 97, 106
        ShellSort mergeSort = new ShellSort();
        List<Integer> numbers  = new ArrayList<>();
        numbers.add(191);
        numbers.add(203);
        numbers.add(65);
        numbers.add(293);
        numbers.add(59);
        numbers.add(603);
        numbers.add(105);
        numbers.add(101);
        numbers.add(301);
        numbers.add(1001);
        numbers.add(97);
        numbers.add(106);
        mergeSort.sort(numbers);
        System.out.println(numbers.toString());
    }
}
