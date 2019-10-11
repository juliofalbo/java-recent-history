package changes.versions.eight;

/**
 * Method Reference
 * As we saw, we can use lambda expressions to create anonymous methods.
 * Sometimes, however, a lambda expression does nothing but call an existing method.
 * In those cases, it's often clearer to refer to the existing method by name.
 * Method references enable you to do this; they are compact, easy-to-read lambda expressions for methods that already have a name.
 *
 * Reference: https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
 */
public class MethodReference {
    private static void printFromMyMainClassWithStaticMethod() {
        System.out.println("Print Static");
    }

    private Integer printFromMyMainClassWithNonStaticMethod() {
        System.out.println("Print Non Static");
        return 1;
    }

    private static String printWithParameter(String text) {
        System.out.println(text);
        return text;
    }

    public static void main(String[] args) {
        //Lambda Expression
        MyInterface myInterfaceLambdaStatic = () -> MethodReference.printFromMyMainClassWithStaticMethod();
        MyInterface myInterfaceLambdaNonStatic = () -> new MethodReference().printFromMyMainClassWithNonStaticMethod();
        MyInterfaceWithParam myInterfaceWithParam = (text) -> MethodReference.printWithParameter(text);
        myInterfaceLambdaStatic.print();
        myInterfaceLambdaNonStatic.print();
        myInterfaceWithParam.print("Printing param Lambda");

        //Method Reference
        MyInterface myInterfaceStaticMethod = MethodReference::printFromMyMainClassWithStaticMethod;
        MyInterface myInterfaceNonStaticMethod = new MethodReference()::printFromMyMainClassWithNonStaticMethod;
        MyInterfaceWithParam myInterfaceWithParamMethodReference = MethodReference::printWithParameter;
        myInterfaceStaticMethod.print();
        myInterfaceNonStaticMethod.print();
        myInterfaceWithParamMethodReference.print("Printing param Method Reference");
    }
}

interface MyInterface {
    void print();
}

interface MyInterfaceWithParam {
    String print(String text);
}
