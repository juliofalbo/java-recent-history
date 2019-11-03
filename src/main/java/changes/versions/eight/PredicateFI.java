package changes.versions.eight;

import java.util.function.Predicate;

public class PredicateFI {

    public static void main(String[] args) {
        // Will return false because we are comparing 2 objects with different types
        Predicate<Integer> testDifferentTypes = Predicate.isEqual("2");
        testDifferentTypes.test(2);

        // Will return true because we are comparing 2 equal objects
        Predicate<Integer> testSameTypes = Predicate.isEqual(2);
        testSameTypes.test(2);


        Predicate<String> firstPredicate = s -> s.startsWith("Julio");
        // The result will be false because the result of the predicate is true
        firstPredicate.negate().test("Julio");

        Predicate<String> secondPredicate = s -> s.endsWith("Falbo");
        Predicate<String> thirdPredicate = s -> s.length() == 11;

        // true case -> Because all the Predicates are returning true
        firstPredicate.or(secondPredicate).or(thirdPredicate).test("Julio Falbo");

        // true case -> Because firstPredicate is returning true
        firstPredicate.or(secondPredicate).or(thirdPredicate).test("Julio Falbo Still True");

        // true false -> Because all the Predicates are returning false
        firstPredicate.or(secondPredicate).or(thirdPredicate).test("False: Julio Falbo False");
    }

}
