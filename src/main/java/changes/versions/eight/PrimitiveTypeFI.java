package changes.versions.eight;

import java.util.function.*;

public class PrimitiveTypeFI {
    public static void main(String[] args) {

        functionPrimitiveAsParam();

        functionPrimitiveAsReturn();

        functionPrimitiveAsParamAndReturn();

        predicatePrimitive();

        consumerPrimitive();

        supplierPrimitive();

        unaryOperatorPrimitive();
    }

    private static void unaryOperatorPrimitive() {
        DoubleUnaryOperator doubleUnaryOperator = d -> d * d;
        System.out.println("DoubleUnaryOperator:" + doubleUnaryOperator.applyAsDouble(2.00));

        IntUnaryOperator intUnaryOperator = i -> i * i;
        System.out.println("IntUnaryOperator:" + intUnaryOperator.applyAsInt(2));

        LongUnaryOperator longUnaryOperator = l -> l * l;
        System.out.println("LongUnaryOperator:" + longUnaryOperator.applyAsLong(2));
    }

    private static void supplierPrimitive() {
        BooleanSupplier booleanSupplier = () -> true;
        System.out.println("BooleanSupplier:" + booleanSupplier.getAsBoolean());

        DoubleSupplier doubleSupplier = () -> 2.00;
        System.out.println("DoubleSupplier:" + doubleSupplier.getAsDouble());

        IntSupplier intSupplier = () -> 2;
        System.out.println("IntSupplier:" + intSupplier.getAsInt());

        LongSupplier longSupplier = () -> 2L;
        System.out.println("LongSupplier:" + longSupplier.getAsLong());
    }

    private static void consumerPrimitive() {
        DoubleConsumer doubleConsumer = d -> System.out.println("DoubleConsumer: " + (d + 2.00));
        doubleConsumer.accept(2.00);

        IntConsumer intConsumer = i -> System.out.println("IntConsumer: " + (i + 2));
        intConsumer.accept(2);

        LongConsumer longConsumer = l -> System.out.println("LongConsumer: " + (l + 2L));
        longConsumer.accept(2L);

        ObjDoubleConsumer<String> objDoubleConsumer = (s, d) -> System.out.println("ObjDoubleConsumer: " + s + d);
        objDoubleConsumer.accept("Test ", 2.00);

        ObjIntConsumer<String> objIntConsumer = (s, i) -> System.out.println("ObjIntConsumer: " + s + i);
        objIntConsumer.accept("Test ", 2);

        ObjLongConsumer<String> objLongConsumer = (s, l) -> System.out.println("ObjLongConsumer: " + s + l);
        objLongConsumer.accept("Test ", 2L);
    }

    private static void predicatePrimitive() {
        DoublePredicate doublePredicate = d -> d < 0.00;
        System.out.println("DoublePredicate: " + doublePredicate.test(2.00));

        IntPredicate intPredicate = i -> i < 0;
        System.out.println("IntPredicate: " + intPredicate.test(2));

        LongPredicate longPredicate = l -> l < 0L;
        System.out.println("LongPredicate: " + longPredicate.test(2L));
    }

    private static void functionPrimitiveAsParamAndReturn() {
        IntToLongFunction intToLongFunction = i -> i + 2L;
        System.out.println("IntToLongFunction: " + intToLongFunction.applyAsLong(2));

        IntToDoubleFunction intToDoubleFunction = i -> i + 2.00;
        System.out.println("IntToDoubleFunction: " + intToDoubleFunction.applyAsDouble(2));

        LongToIntFunction longToIntFunction = l -> Math.toIntExact(l) * 2;
        System.out.println("LongToIntFunction: " + longToIntFunction.applyAsInt(2L));

        LongToDoubleFunction longToDoubleFunction = l -> l * 2.00;
        System.out.println("LongToDoubleFunction: " + longToDoubleFunction.applyAsDouble(2L));

        DoubleToIntFunction doubleToIntFunction = d -> (int) d + 2;
        System.out.println("DoubleToIntFunction: " + doubleToIntFunction.applyAsInt(2.00));

        DoubleToLongFunction doubleToLongFunction = d -> (long) d + 2L;
        System.out.println("DoubleToLongFunction: " + doubleToLongFunction.applyAsLong(2.00));
    }

    private static void functionPrimitiveAsReturn() {
        ToIntFunction<Integer> toIntFunction = i -> i * i;
        System.out.println("ToIntFunction: " + toIntFunction.applyAsInt(2));

        ToIntBiFunction<Integer, Integer> toIntBiFunction = (i1, i2) -> i1 + i2;
        System.out.println("ToIntBiFunction: " + toIntBiFunction.applyAsInt(2, 2));

        ToLongFunction<Long> toLongFunction = l -> l * l;
        System.out.println("ToLongFunction: " + toLongFunction.applyAsLong(2L));

        ToLongBiFunction<Long, Long> toLongBiFunction = (l1, l2) -> l1 + l2;
        System.out.println("ToLongBiFunction: " + toLongBiFunction.applyAsLong(2L, 2L));

        ToDoubleFunction<Double> toDoubleFunction = d -> d * d;
        System.out.println("ToDoubleFunction: " + toDoubleFunction.applyAsDouble(2.00));

        ToDoubleBiFunction<Double, Double> toDoubleBiFunction = (d1, d2) -> d1 + d2;
        System.out.println("ToDoubleBiFunction: " + toDoubleBiFunction.applyAsDouble(2.00, 2.00));
    }

    private static void functionPrimitiveAsParam() {
        IntFunction<Integer> intFunction = i -> i + i;
        System.out.println("IntFunction: " + intFunction.apply(2));

        LongFunction<Long> longFunction = l -> l + l;
        System.out.println("LongFunction: " + longFunction.apply(2));

        DoubleFunction<Double> doubleFunction = d -> d + d;
        System.out.println("DoubleFunction: " + doubleFunction.apply(2.00));
    }
}
