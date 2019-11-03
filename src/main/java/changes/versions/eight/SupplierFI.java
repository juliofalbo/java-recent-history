package changes.versions.eight;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierFI {

    public static void main(String[] args) {
        Supplier<String> mySupplier = () -> String.valueOf(Math.random());
        // Will return a random object as String
        System.out.println(mySupplier.get());
    }

}
