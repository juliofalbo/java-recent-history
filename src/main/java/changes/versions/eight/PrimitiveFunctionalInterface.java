package changes.versions.eight;

import static java.lang.Integer.MAX_VALUE;

import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import org.openjdk.jol.info.GraphLayout;

public class PrimitiveFunctionalInterface {

    public static void main(String[] args) {
        operationWithWrapperClass();
        operationWithPrimitiveTypeFunctionInterface();
    }

    /**
     * In this operation we are doing 0 conversions, since we are working only with primitive type
     */
    private static void operationWithPrimitiveTypeFunctionInterface(){
        long startTime = System.currentTimeMillis();

        int[] array = initValues();

        IntPredicate predicate = i -> i % 2 == 0;

        for(int primitive : array){
            if(predicate.test(primitive)){
//                System.out.println(primitive);
            }
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("ElapsedTime operationWithPrimitiveTypeFunctionInterface: " + elapsedTime);
    }

    /**
     * In this operation we are doing 20 unintentionally conversions.
     */
    private static void operationWithWrapperClass(){
        long startTime = System.currentTimeMillis();

        int[] array = initValues();

        // Here we are doing (unintentionally) 10 conversions (auto-unboxing [Integer -> int])
        // since the type parameter of Predicate is Integer and we need to convert to int to make the math operation
        Predicate<Integer> predicate = i -> i % 2 == 0;

        for(int primitive : array){
            // Here we are doing (unintentionally) 10 conversions (autoboxing [int -> Integer]) since the type parameter of Predicate is Integer
            if(predicate.test(primitive)){
//                System.out.println(primitive);
            }
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("ElapsedTime operationWithWrapperClass: " + elapsedTime);
    }

    private static int[] initValues() {
        int[] values = new int[100000000];
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(MAX_VALUE);
        }
        return values;
    }

    private static void calculateWrapperClassesSize() {
        Boolean bool = new Boolean(true);
        Byte aByte = new Byte("7");
        Short aShort = new Short("9");
        Character character = Character.forDigit(1,0);
        Integer integer = new Integer(7);
        Float aFloat = new Float(7);
        Long aLong = new Long(7);
        Double aDouble = new Double(7.00);

        System.out.println("Boolean object size is: " + getBitValue(bool) + " bits");
        System.out.println("Byte object size is: " + getBitValue(aByte) + " bits");
        System.out.println("Short object size is: " + getBitValue(aShort) + " bits");
        System.out.println("Character object size is: " + getBitValue(character) + " bits");
        System.out.println("Integer object size is: " + getBitValue(integer) + " bits");
        System.out.println("Float object size is: " + getBitValue(aFloat) + " bits");
        System.out.println("Long object size is: " + getBitValue(aLong) + " bits");
        System.out.println("Double object size is: " + getBitValue(aDouble) + " bits");
    }

    private static long getBitValue(Object obj) {
        return GraphLayout.parseInstance(obj).totalSize() * 8;
    }


}
