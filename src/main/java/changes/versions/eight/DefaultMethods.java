package changes.versions.eight;

public class DefaultMethods {

    public static void main(String[] args) {
        beforeJava8();
        java8();
        new Number().defaultMethod();
    }

    public static void beforeJava8(){
        SomeInterfaceBeforeJava8 impl1 = new SomeImplementationBeforeJava8();
        SomeInterfaceBeforeJava8 impl2 = new AnotherImplementationBeforeJava8();
        System.out.println(impl1.calc(1, 2));
        System.out.println(impl2.calc(1, 2));
    }

    public static void java8(){
        SomeInterfaceJava8 impl1 = new SomeImplementationJava8();
        SomeInterfaceJava8 impl2 = new AnotherImplementationJava8();
        System.out.println(impl1.customCalc(1, 2));
        System.out.println(impl2.customCalc(1, 2));
    }

}

interface SomeInterfaceBeforeJava8 {
    Integer calc(int a, int b);
}

class SomeImplementationBeforeJava8 implements SomeInterfaceBeforeJava8 {
    @Override
    public Integer calc(int a, int b) {
        return (a + b) + 1;
    }
}

class AnotherImplementationBeforeJava8 implements SomeInterfaceBeforeJava8 {
    @Override
    public Integer calc(int a, int b) {
        return (a + b) + 2;
    }
}

interface SomeInterfaceJava8 {
    Integer customCalc(int a, int b);
    default Integer calc(int a, int b) {
        return (a + b);
    }
}

class SomeImplementationJava8 implements SomeInterfaceJava8 {
    @Override
    public Integer customCalc(int a, int b) {
        return calc(a, b) + 1;
    }
}

class AnotherImplementationJava8 implements SomeInterfaceJava8 {
    @Override
    public Integer customCalc(int a, int b) {
        return calc(a, b) + 2;
    }
}

interface OneInterface {
    default void defaultMethod(){
        System.out.println("One");
    }
}

interface TwoInterface {
    default void defaultMethod(){
        System.out.println("Two");
    }
}

class Number implements OneInterface, TwoInterface {

    @Override
    public void defaultMethod() {
        OneInterface.super.defaultMethod();
        TwoInterface.super.defaultMethod();
        System.out.println("Three");
    }
}