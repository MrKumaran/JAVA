package Learning.Basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        Stream<Integer> stream = list.stream();

        Stream<Integer> s1 = stream.map(n ->{
         if (n%2 != 0) return n*2;
         else return n*3;
        });

        s1.forEach(System.out::println);


         // can be rewritten using lambda
        Function<Integer, Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
             return integer*integer;
            }
        };

        stream.filter(n -> n%2 != 0).map(function).forEach(System.out::println);

        Predicate<Integer> p = new Predicate<Integer>() { // function interface can be written in lambda
            @Override
            public boolean test(Integer integer) {
                if (integer != 0) return true;
                return false;
            }
        };

        System.out.println(p.test(0));

        int[] arr = new int[]{1,23,4};

        Predicate<int[]> p1 = arr1 -> {
            for (int i = 0; i < arr1.length; i++){
                if (23 == arr1[i]) return true;
            }
            return false;
        };

        System.out.println(p1.test(arr));

    }
}
