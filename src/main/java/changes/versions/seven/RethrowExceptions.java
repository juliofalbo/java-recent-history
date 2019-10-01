package changes.versions.seven;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Rethrowing Exceptions with More Inclusive Type Checking
 * The Java SE 7 compiler performs more precise analysis of rethrown exceptions than earlier releases of Java SE.
 * This enables you to specify more specific exception types in the throws clause of a method declaration.
 *
 * Advantages:
 * - You don't need to specify the correct type of an exception you want to rethrow explicitly anymore, the compiler will take care of this for you!
 *
 * Reference: https://docs.oracle.com/javase/7/docs/technotes/guides/language/catch-multiple.html
 */
public class RethrowExceptions {

    public static void main(String[] args) {
        try {
            beforeJava7();
        } catch (RuntimeException e) {
            print(e);
        }

        try {
            java7();
        } catch (RuntimeException e) {
            print(e);
        }
    }

    private static void beforeJava7() throws RuntimeException {
        try {
            someMethodThatCanThrowsIllegalOrNoSuchElementException();
        } catch (RuntimeException e) {
            if (e instanceof IllegalArgumentException) {
                throw new IllegalArgumentException();
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    private static void java7() throws IllegalArgumentException, NoSuchElementException {
        someMethodThatCanThrowsIllegalOrNoSuchElementException();
    }

    private static void someMethodThatCanThrowsIllegalOrNoSuchElementException() {
        if (new Random().nextBoolean()) {
            throwIllegalArgumentException();
        } else {
            throwNoSuchElementException();
        }
    }


    private static void throwIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    private static void throwNoSuchElementException() {
        throw new NoSuchElementException();
    }

    private static void print(RuntimeException e) {
        System.out.println(e.getClass().getSimpleName());
    }
}
