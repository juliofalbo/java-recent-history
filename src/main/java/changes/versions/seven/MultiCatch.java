package changes.versions.seven;

import java.util.NoSuchElementException;

/**
 * Multi Catch
 * In Java SE 7 and later, a single catch block can handle more than one type of exception.
 * This feature can reduce code duplication and lessen the temptation to catch an overly broad exception.
 *
 * Advantages:
 * - Simpler
 * - More readable
 * - Avoid code duplication (not redundant)
 *
 * Reference: https://docs.oracle.com/javase/7/docs/technotes/guides/language/catch-multiple.html
 */
public class MultiCatch {

    public static void main(String[] args) {
        beforeJava7();
        java7();
    }

    private static void beforeJava7() {
        try {
            throwIllegalArgumentException();
        } catch (IllegalArgumentException e) {
            print(e);
        } catch (NoSuchElementException e) {
            print(e);
        }
    }

    private static void java7() {
        try {
            throwNoSuchElementException();
        } catch (IllegalArgumentException | NoSuchElementException | NullPointerException e) {
            print(e);
        }
    }

    private static void throwIllegalArgumentException(){
        throw new IllegalArgumentException();
    }

    private static void throwNoSuchElementException(){
        throw new NoSuchElementException();
    }

    private static void print(RuntimeException e){
        System.out.println(e.getClass().getSimpleName());
    }
}
