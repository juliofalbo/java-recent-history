package changes.versions.seven;

/**
 * Garbage-First Collector
 *
 * The Garbage-First (G1) collector is a server-style garbage collector, targeted for multi-processor machines with large memories.
 * It meets garbage collection (GC) pause time goals with a high probability, while achieving high throughput.
 * The G1 garbage collector is fully supported in Oracle JDK 7 update 4 and later releases.
 *
 * The G1 collector is designed for applications that:
 * - Can operate concurrently with applications threads like the CMS collector.
 * - Compact free space without lengthy GC induced pause times.
 * - Need more predictable GC pause durations.
 * - Do not want to sacrifice a lot of throughput performance.
 * - Do not require a much larger Java heap.
 * - That require large heaps with limited GC latency. This means heap sizes of around 6GB or larger, and stable and predictable pause time below 0.5 seconds
 *
 *
 * Before Java 7
 * The older garbage collectors (Serial, Parallel and CMS) all structure the heap with a fixed memory size into three regions:
 * - Young Generation (Eden + Survivor Spaces)
 * - Old Generation (Tenured)
 * - Permanent Generation (Permgen)
 * It means that for each region the memory is reserved and fixed
 *
 * Java 7
 * The Garbage-First (G1) divides heap memory into multiple regions/blocks, keeping the size of each block equal.
 * It means that the heap is partitioned into a set of equal-sized heap regions, each a contiguous range of virtual memory.
 * Certain region sets are assigned the same roles (eden, survivor, old) as in the older collectors, but there is not a fixed size for them.
 * This provides greater flexibility in memory usage.
 * The JVM generally targets around 2000 regions varying in size from 1 to 32Mb.
 * When performing garbage collections, G1 operates in a manner similar to the CMS collector.
 * G1 performs a concurrent global marking phase to determine the liveness of objects throughout the heap.
 * After the mark phase completes, G1 knows which regions are mostly empty and it collects in these regions first, which usually yields a large amount of free space.
 * This is why this method of garbage collection is called Garbage-First.
 * As the name suggests, G1 concentrates its collection and compaction activity on the areas of the heap that are likely to be full of reclaimable objects, that is, garbage.
 *
 * Notes:
 * - It is important to note that G1 is not a real-time collector. It meets the set pause time target with high probability but not absolute certainty.
 * - Full garbage collections are still single threaded, but if tuned properly your applications should avoid full GCs.
 *
 * References:
 * https://docs.oracle.com/javase/7/docs/technotes/guides/vm/G1.html
 * https://www.oracle.com/technetwork/tutorials/tutorials-1876574.html
 */
public class G1GarbageCollector {
}
