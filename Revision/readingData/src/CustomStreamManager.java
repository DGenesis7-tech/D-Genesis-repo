import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CustomStreamManager {
    public static void main(String[] args) {
        //1. Obtain a stream from a collection
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(numbers.stream().reduce( Integer::sum).orElseThrow());

        //2. Array.Stream(T[])
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.stream(nums).average().orElseThrow());

        //3. Stream.of()
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        //4. Infinite Stream
        Stream.generate(Math::random)
                .forEach(System.out::println);

        
    }

}

