package changes.versions.eight;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class ConsumerFI {

    public static void main(String[] args) {
        AtomicReference<String> atomic = new AtomicReference("Julio");
        Consumer<AtomicReference> firstConsumer = a -> System.out.println(a.get());
        Consumer<AtomicReference> secondConsumer = a -> a.set("Falbo");

        // The result will be:
        // Julio
        // Falbo
        // Because firstConsumer is printing the current value of the AtomicReference object, which is Julio (initial value).
        // The secondConsumer is changing the value of the AtomicReference to Falbo
        // So when we called firstConsumer after the secondConsumer, the current value of the AtomicReference now is Falbo.
        firstConsumer.andThen(secondConsumer).andThen(firstConsumer).accept(atomic);
    }

}
