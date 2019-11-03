package changes.versions.eight;

import java.util.function.Function;

@FunctionalInterface
public interface FunctionalI {
    void abstractMethod();

    default String defaultMethod() {
        return "defaultMethod";
    }

    static String staticMethod() {
        return "staticMethod";
    }

    boolean equals(Object obj);
}

class Main {
    public static void main(String[] args) {
        FunctionalI a = () -> System.out.println("test");
        a.abstractMethod();
        System.out.println(a.defaultMethod());
        System.out.println(FunctionalI.staticMethod());
    }
}

@FunctionalInterface
interface ParentInterface{
    void parentAbstractMethod();
}

@FunctionalInterface
interface ChildInterface extends ParentInterface{
    void parentAbstractMethod();

    default void defaultChildMethod1(){

    }

    default void defaultChildMethod2(){

    }

    static void staticChildMethod(){

    }

    String toString();
}

interface AnotherChildInterface extends ChildInterface{
    String someAbstractMethod(String someParameter);
}