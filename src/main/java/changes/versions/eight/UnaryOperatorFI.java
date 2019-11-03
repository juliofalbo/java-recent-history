package changes.versions.eight;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorFI {
    public static void main(String[] args) {
        Function<Integer, Integer> integerFunction = i -> i + 2;
        UnaryOperator<Integer> unaryOperator  = i -> i + 2;

        System.out.println(integerFunction.apply(2));
        System.out.println(unaryOperator.apply(2));
    }
}
