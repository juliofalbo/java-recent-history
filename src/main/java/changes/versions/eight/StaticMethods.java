package changes.versions.eight;

public class StaticMethods {
    public static void main(String[] arxgs) {
        InterfaceWithStaticMethod impl1 = (text) -> System.out.println("Custom Message " + text);
        impl1.printWithCustomMessage("Text");
        InterfaceWithStaticMethod.print("Text");
    }
}

interface InterfaceWithStaticMethod {
    void printWithCustomMessage(String text);

    static void print(String text) {
        System.out.println(text);
    }
}

interface RunnableInterface {
    public static void main(String[] args) {
        System.out.println("Ran by an Interface");
    }
}