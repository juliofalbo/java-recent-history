package changes.versions.seven;

import java.io.IOException;

/**
 * try-with-resources Statement
 * The try-with-resources statement is a try statement that declares one or more resources.
 * A resource is as an object that must be closed after the program is finished with it.
 * The try-with-resources statement ensures that each resource is closed at the end of the statement.
 * Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, can be used as a resource.
 *
 * Problems solved:
 * - If the developer forget to close a resource, we have a memory leak
 * - You always need to check if the resource is null before close it, to avoid {@link NullPointerException}
 * - Unnecessary Finally block. We are using the finally block only to close the resources
 *
 * Advantages:
 * - The management of the resource is implicitly
 * - No need to close the resource manually. Resources will be implicitly closed after the try block, avoiding memory leak
 * - Readability
 *
 * Reference: https://docs.oracle.com/javase/7/docs/technotes/guides/language/try-with-resources.html
 */
public class TryWithResources {

    public static void main(String[] args) {
        beforeJava7();
        java7();
    }

    static class SomeResource implements AutoCloseable {
        public void start() throws IOException {
            System.out.println("Starting SomeResource");
        }

        @Override
        public void close() throws ArrayIndexOutOfBoundsException {
            System.out.println("Closing SomeResource");
        }
    }


    private static void beforeJava7() {
        SomeResource someResource = new SomeResource();
        try {
            someResource.start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(someResource != null){
                try {
                    someResource.close();
                } catch (ArrayIndexOutOfBoundsException a){
                    a.printStackTrace();
                }
            }
        }
    }

    private static void java7() {
        try (SomeResource someResource2 = new SomeResource()) {
            someResource2.start();
        } catch (IOException | ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

}
