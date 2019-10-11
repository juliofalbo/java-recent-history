package changes.versions.eight;

public class FunctionalProgramming {

    public static void main(String[] args) {
        calc((a, b) -> a + b);
    }

    public static void calc(FunctionInterface functionInterface) {
        Integer add = functionInterface.add(2, 2);
        System.out.println(add);
    }
}

interface FunctionInterface {
    Integer add(int param1, int param2);
}