package changes.versions.seven;

/**
 * Underscores in Numeric Literals
 * Now we can use underscore characters (_) between digits in a numerical literal.
 * So we can use, for example, to separate groups of digits in numeric literals, which improve the readability of the code.
 *
 * The goal of this underscore is improve the readability of the number, but there are some cases that we can not use it.
 * - At the beginning or end of a number
 * - Adjacent to a decimal point in a floating point literal
 * - Prior to an F or L suffix
 * - In positions where a string of digits is expected
 *
 * Reference: https://docs.oracle.com/javase/7/docs/technotes/guides/language/underscores-literals.html
 */
public class UnderscoreInNumericLiterals {

    public static void main(String[] args) {
        int beforeJava7 = 111000222;
        int java7 = 111_000_222;

        System.out.println("Before Java 7: " + beforeJava7);
        System.out.println("Java 7: " + java7);
    }

}
