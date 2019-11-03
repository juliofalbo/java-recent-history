package changes.versions.eight;

import java.util.function.*;

public class BiFunctionalInterfaces {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, String> calcAndToString = (first, second) -> String.valueOf(first + second);
        Function<String, Integer> add2 = first -> Integer.valueOf(first) + 2;

        System.out.println(calcAndToString.andThen(add2).apply(1, 10));

        BiPredicate<String, String> contains = (first, second) -> first.contains(second);
        BiPredicate<String, String> startsWith = (first, second) -> first.startsWith(second);

        // Will return true because all conditions are true
        System.out.println(contains.and(startsWith).test("Julio Falbo", "Julio"));

        // Will return true because contains BiPredicate is true
        System.out.println(contains.or(startsWith).test("Julio Falbo", "Falbo"));

        // Will return false because contains BiPredicate is true and we called the method negate
        System.out.println(contains.negate().test("Julio Falbo", "Falbo"));


        BiConsumer<String, String> printLove = (first, second) -> System.out.println("I (" + first + ") love " + second);
        BiConsumer<String, String> printAnotherPhrase = (first, second) ->
                System.out.println("I also love my wife and my daughter (and " + second + ")");

        printLove.andThen(printAnotherPhrase).accept("Julio Falbo", "Java");

    }

}
