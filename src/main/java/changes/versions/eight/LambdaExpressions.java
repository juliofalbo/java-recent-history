package changes.versions.eight;

import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

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

        targetTypeAndMethodArgumentsTest();
        lexicalScopeTest();
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

        SingleParameterInterface impl2 = single -> "a" + single;

        // Multiline Implementation
        ConcatStringInterface impl1 = (param1, param2) -> {
            return param1 + param2;
        };

        // Single Line Implementation
        ConcatStringInterface impl = (param1, param2) -> param1 + param2;

        // Void Implementation
        NoParameterInterface impl4 = () -> System.out.println(LocalDate.now().toString());

        // Void Implementation Not Single Line
        NoParameterInterface impl7 = () -> {
            System.out.println("Now is");
            System.out.println(LocalDate.now().toString());
        };

        // Do Nothing
        NoParameterInterface impl5 = () -> {};

        ConcatStringInterface implMultiLine = (param1, param2) -> {
            if (Objects.nonNull(param1) && Objects.nonNull(param2)) {
                return param1 + param2;
            }
            return "null";
        };

        System.out.println(impl.concat("a", "b"));
        System.out.println(impl1.concat("a", "b1"));
        System.out.println(implMultiLine.concat("a", "b2"));
        System.out.println(implMultiLine.concat("a", null));
        System.out.println(impl2.single("b3"));
        impl4.printNow();
        impl5.printNow();
        impl7.printNow();
    }

    private static void lexicalScopeTest() {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        CountInterface count = () -> atomicInteger.incrementAndGet();

        System.out.println(count.count());
        System.out.println(count.count());
        System.out.println(count.count());
    }

    private static void targetTypeAndMethodArgumentsTest() {
        String invoke = invoke((param1, param2) -> "Concat" + param1 + param2);
        System.out.println(invoke);

        invoke((param1, param2) -> {
            System.out.println(param1 + param2);
        });
    }

    public static void invoke(PrintInterface p) {
        p.print("a", "b");
    }

    public static String invoke(ConcatStringInterface c) {
        return c.concat("a", "b");
    }

}

interface CountInterface {
    Integer count();
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
