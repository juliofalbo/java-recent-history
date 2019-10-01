package changes.versions.seven;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Diamond Operator
 *
 * You can replace the type arguments required to invoke the constructor of a generic class with an
 * empty set of type parameters (<>) as long as the compiler can infer the type arguments from the context.
 * This pair of angle brackets is informally called the diamond.
 *
 * Advantages:
 * - Avoid code redundancy
 * - The compiler infers the value of type arguments, simplifying the code
 *
 * Reference: http://docs.oracle.com/javase/7/docs/technotes/guides/language/type-inference-generic-instance-creation.html
 */
public class DiamondOperator {

    private static List<Map<String, List<String>>> beforeJava7 = new ArrayList<Map<String, List<String>>>();
    private static List<Map<String, List<String>>> java7 = new ArrayList<>();

    public static void main(String[] args) throws NoSuchFieldException {
        System.out.println("Before Java 7: " + DiamondOperator.class.getDeclaredField("beforeJava7").getGenericType());
        System.out.println("Java 7: " + DiamondOperator.class.getDeclaredField("java7").getGenericType());
    }

}
