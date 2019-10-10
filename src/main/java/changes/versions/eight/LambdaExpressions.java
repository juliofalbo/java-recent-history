package changes.versions.eight;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Lambda Expressions
 * They enable you to treat functionality as a method argument, or code as data.
 * Lambda expressions let you express instances of single-method interfaces (referred to as functional interfaces) more compactly.
 * <p>
 * Reference: https://docs.oracle.com/javase/8/docs/technotes/guides/language/enhancements.html#javase8
 */
public class LambdaExpressions {

    public static void main(String[] args) {
        beforeJava8FirstOption();
        beforeJava8SecondOption();
        java8();

        invoke((param1, param2) -> "Concat" + param1 + param2);
        invoke((param1, param2) -> {
        });
    }

    public static void invoke(PrintInterface p) {
        p.print("a", "b");
    }

    public static String invoke(ConcatStringInterface c) {
        return c.concat("a", "b");
    }

    public static void beforeJava8FirstOption() {
        ConcatStringInterface concatStringInterface = new ConcatStringImpl();
        System.out.println(concatStringInterface.concat("a", "b"));
    }

    public static void beforeJava8SecondOption() {
        ConcatStringInterface impl = new ConcatStringInterface() {
            @Override
            public String concat(String param1, String param2) {
                return param1 + param2;
            }
        };
        System.out.println(impl.concat("a", "b"));
    }

    public static void java8() {
        ConcatStringInterface impl = (param1, param2) -> param1 + param2;
        ConcatStringInterface impl1 = (param1, param2) -> { return param1 + param2; };
        SingleParameterInterface impl2 = single -> "a" + single;

        ConcatStringInterface implMultiLine = (param1, param2) -> {
            if (Objects.nonNull(param1) && Objects.nonNull(param2)) {
                return param1 + param2;
            }
            return "null";
        };

        NoParameterInterface impl4 = () -> System.out.println(LocalDate.now().toString());

        System.out.println(impl.concat("a", "b"));
        System.out.println(impl1.concat("a", "b1"));
        System.out.println(implMultiLine.concat("a", "b2"));
        System.out.println(implMultiLine.concat("a", null));
        System.out.println(impl2.single("b3"));
        impl4.printNow();
    }

}

interface SingleParameterInterface {
    String single(String param1);
}

interface NoParameterInterface {
    void printNow();
}

interface ConcatStringInterface {
    String concat(String param1, String param2);
}

interface PrintInterface {
    void print(String param1, String param2);
}

class ConcatStringImpl implements ConcatStringInterface {
    public String concat(String param1, String param2) {
        return param1 + param2;
    }
}
