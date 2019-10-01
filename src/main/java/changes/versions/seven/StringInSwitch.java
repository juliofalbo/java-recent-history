package changes.versions.seven;

/**
 * Strings in switch Statements
 * Now we can use a String object in the expression of a switch statement
 *
 *
 * Reference: https://docs.oracle.com/javase/7/docs/technotes/guides/language/strings-switch.html
 */
public class StringInSwitch {

    public static void main(String[] args) {
        System.out.println(getNumberByString("one"));
        System.out.println(getNumberByString("three"));
        System.out.println(getNumberByString("two"));
        System.out.println(getNumberByString("ten"));
    }

    private static int getNumberByString(String string) {
        int number;
        switch (string) {
            case "one":
                number = 1;
                break;
            case "two":
                number = 2;
                break;
            case "three":
                number = 3;
                break;
            case "four":
                number = 4;
                break;
            case "five":
                number = 5;
                break;
            default:
                number = 0;
        }
        return number;
    }

}
