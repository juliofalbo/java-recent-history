package changes.versions.eight;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BinaryOperatorFI {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> addBi = (a, b) -> a + b;
        // Result will be 4
        System.out.println(addBi.apply(2,2));

        BinaryOperator<Integer> addBinary = (a, b) -> a + b;
        // Result will be 4
        System.out.println(addBinary.apply(2,2));
    }

}
